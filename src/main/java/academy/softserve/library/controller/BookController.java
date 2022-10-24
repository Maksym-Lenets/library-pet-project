package academy.softserve.library.controller;

import academy.softserve.library.dto.AuthorDto;
import academy.softserve.library.dto.BookDto;
import academy.softserve.library.model.Book;
import academy.softserve.library.service.AuthorService;
import academy.softserve.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/books")
public class BookController {
    private BookService bookService;

    private AuthorService authorService;

    @Autowired
    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }


    @GetMapping
    public String getAll(Model model) {
        List<BookDto> books = bookService.getAllAvailable()
                .stream()
                .map(BookDto::toBookDto)
                .collect(Collectors.toList());
        model.addAttribute("book", new BookDto());
        model.addAttribute("listBooks", books);
        return "books";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {
        BookDto book = BookDto.toBookDto(bookService.get(id));
        model.addAttribute("book", book);
        return "book";
    }

    @GetMapping("/remove/{id}")
    public String removeBook(@PathVariable("id") Long id) {
        this.bookService.remove(id);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {
        Book book;
        BookDto bookDto;
        AuthorDto authorDto;
        List<AuthorDto> coAuthors;
        List<AuthorDto> allAuthors;
        if (id == null || id.equals(0L)) {
            bookDto = new BookDto();
            authorDto = new AuthorDto();
            coAuthors = new ArrayList<>();
        } else {
            book = bookService.get(id);
            bookDto = BookDto.toBookDto(book);
            authorDto = AuthorDto.toAuthorDto(book.getAuthor());
            coAuthors = book.getCoAuthors().stream()
                    .map(AuthorDto::toAuthorDto)
                    .collect(Collectors.toList());
        }
        allAuthors = authorService.getAll().stream()
                .map(AuthorDto::toAuthorDto)
                .collect(Collectors.toList());

        model.addAttribute("book", bookDto);
        model.addAttribute("author", authorDto);
        model.addAttribute("coAuthors", coAuthors);
        model.addAttribute("allAuthors", allAuthors);

        return "bookForm";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("book") BookDto book) {
        Book originBook;
        if (book.getId() != null) {
            originBook = bookService.get(book.getId());
        } else {
            originBook = new Book();
        }
        originBook = book.toBook(originBook);
        bookService.save(originBook);
        return "redirect:/books";
    }
}
