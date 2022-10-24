package academy.softserve.library.controller;

import academy.softserve.library.dto.BookDto;
import academy.softserve.library.model.Book;
import academy.softserve.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/books")
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
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
        BookDto book;
        if (id == null || id.equals(0L)) {
            book = new BookDto();
        } else {
            book = BookDto.toBookDto(bookService.get(id));
        }
        model.addAttribute("book", book);
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
