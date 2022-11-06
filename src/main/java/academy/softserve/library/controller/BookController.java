package academy.softserve.library.controller;

import academy.softserve.library.dto.AuthorDto;
import academy.softserve.library.dto.BookDto;
import academy.softserve.library.model.Author;
import academy.softserve.library.model.Book;
import academy.softserve.library.service.AuthorService;
import academy.softserve.library.service.BookService;
import academy.softserve.library.util.DtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
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
        List<BookDto> books = bookService.getAllAvailable().stream()
                .map(DtoUtil::toBookDto)
                .collect(Collectors.toList());
        model.addAttribute("listBooks", books);
        return "books";
    }


    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {
        BookDto book = DtoUtil.toBookDto(bookService.get(id));
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
        BookDto bookDto = bookDto = DtoUtil.toBookDto(bookService.get(id));
        List<AuthorDto> authors = DtoUtil.toAuthorDtoList(authorService.getAll());
        model.addAttribute("book", bookDto);
        model.addAttribute("authorsArr", authors);
        return "bookForm";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("book") BookDto bookDto) {
        Book book;

        if (bookDto.isNew()) {
            book = new Book();

        } else {
            book = bookService.get(bookDto.getId());
        }


        List<Author> authors = authorService.get(bookDto.getCoAuthors().stream()
                .map(AuthorDto::getId)
                .collect(Collectors.toList()));

        book = DtoUtil.toBook(bookDto, book);
        book.setCoAuthors(new HashSet<>(authors));
        bookService.save(book);

        return "redirect:/books";
    }
}
