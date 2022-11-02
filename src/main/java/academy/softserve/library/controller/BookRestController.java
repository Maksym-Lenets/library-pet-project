package academy.softserve.library.controller;

import academy.softserve.library.dto.AuthorDto;
import academy.softserve.library.dto.BookDto;
import academy.softserve.library.model.Book;
import academy.softserve.library.service.AuthorService;
import academy.softserve.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static academy.softserve.library.util.DtoUtil.*;
import static org.springframework.http.HttpStatus.*;


@RestController
@RequestMapping(value = "/rest/books")
public class BookRestController {

    private BookService bookService;

    private AuthorService authorService;

    @Autowired
    public BookRestController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BookDto>> getAll() {
        return new ResponseEntity<>(toBooksDtoList(bookService.getAllAvailable()), OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookDto> get(@PathVariable("id") Long id) {
        return new ResponseEntity<>(toBookDto(bookService.get(id)), OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        Book book = bookService.get(id);
        if (book == null) {
            return new ResponseEntity(NOT_FOUND);
        }
        return bookService.remove(id) ? new ResponseEntity(NO_CONTENT) : new ResponseEntity(INTERNAL_SERVER_ERROR);
    }

    @PostMapping
    public void save(BookDto bookDto) {
        Book book = bookService.get(bookDto.getId());
        bookService.save(toBook(bookDto, book));
    }

    //TODO USE AUTHOR REST CONTROLLER LATER
    @GetMapping("/authors")
    public ResponseEntity<List<AuthorDto>> getAuthors() {
        return new ResponseEntity<>(toAuthorDtoList(new HashSet<>(authorService.getAll())), OK);
    }
}
