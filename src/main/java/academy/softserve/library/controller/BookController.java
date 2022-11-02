package academy.softserve.library.controller;

import academy.softserve.library.dto.BookDto;
import academy.softserve.library.service.AuthorService;
import academy.softserve.library.service.BookService;
import academy.softserve.library.util.DtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

   /* @GetMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {
        Book book;
        BookDto bookDto;
        if (id == null || id.equals(0L)) {
            bookDto = new BookDto();

        } else {
            book = bookService.get(id);
            bookDto = BookDto.toBookDto(book);
        }
        model.addAttribute("book", bookDto);

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
    }*/
}
