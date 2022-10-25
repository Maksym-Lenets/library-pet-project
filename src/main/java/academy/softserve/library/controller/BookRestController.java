package academy.softserve.library.controller;

import academy.softserve.library.service.AuthorService;
import academy.softserve.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


public class BookRestController {

    private BookService bookService;

    private AuthorService authorService;

    @Autowired
    public BookRestController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }
}
