package academy.softserve.library.controller;

import academy.softserve.library.dto.AuthorDto;
import academy.softserve.library.dto.BookDto;
import academy.softserve.library.model.Author;
import academy.softserve.library.model.Book;
import academy.softserve.library.model.Status;
import academy.softserve.library.service.AuthorService;
import academy.softserve.library.service.BookInstanceService;
import academy.softserve.library.service.BookService;
import academy.softserve.library.util.DtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/books")
public class BookController {
    private BookService bookService;

    private AuthorService authorService;

    private BookInstanceService bookInstanceService;

    @Autowired
    public BookController(BookService bookService, AuthorService authorService, BookInstanceService bookInstanceService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.bookInstanceService = bookInstanceService;
    }


    @GetMapping
    public String getAll() {
        return "redirect:/books/1";
    }

    @GetMapping("/{page}")
    public String getAllPerPage(@PathVariable Integer page, Model model) {
        List<BookDto> books = bookService.getAllAvailable(page).stream()
                .map(DtoUtil::toBookDto)
                .collect(Collectors.toList());

        model.addAttribute("listBooks", books);
        model.addAttribute("lastPage", bookService.getLastPageNumber());
        model.addAttribute("currentPage", page);

        return "books";
    }

    @GetMapping("/filter")
    public String getFiltered(@RequestParam(value = "bookTitle", required = false) String bookTitle,
                              @RequestParam(value = "authorName", required = false) String authorName, Model model) {

        if (authorName.isEmpty() && bookTitle.isEmpty()) {
            return "redirect:/books/1";
        }

        if (authorName.isEmpty()) {
            List<BookDto> books = bookService.getAllAvailableByTitle(bookTitle).stream()
                    .map(DtoUtil::toBookDto)
                    .collect(Collectors.toList());

            model.addAttribute("listBooks", books);
        }

        if (!authorName.isEmpty()) {
            List<Author> authors = authorService.getByName(authorName);
            Set<Book> books = new HashSet<>();

            for (Author author : authors) {
                books.addAll(author.getBooks());
                books.addAll(author.getBookList());
            }

            if (!bookTitle.isEmpty()) {
                books = books.stream()
                        .filter(b -> b.getTitle().toLowerCase().contains(bookTitle.toLowerCase()))
                        .collect(Collectors.toSet());
            }
            model.addAttribute("listBooks", DtoUtil.toBooksDtoList(books));
        }

        model.addAttribute("bookTitle", bookTitle);
        model.addAttribute("authorName", authorName);
        model.addAttribute("searchDisplay", true);

        return "books";
    }

    @GetMapping("/book/{id}")
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
        BookDto bookDto = DtoUtil.toBookDto(bookService.get(id));
        List<AuthorDto> authors = DtoUtil.toAuthorDtoList(authorService.getAll());
        model.addAttribute("book", bookDto);
        model.addAttribute("authorsArr", authors);
        return "bookForm";
    }

    @GetMapping("/create")
    public String createBook(Model model) {
        BookDto bookDto = new BookDto();
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
            book.setStatus(Status.AVAILABLE);

        } else {
            book = bookService.get(bookDto.getId());
        }


        List<Author> coAuthors = authorService.get(bookDto.getCoAuthors().stream()
                .map(AuthorDto::getId)
                .collect(Collectors.toList()));

        DtoUtil.toBook(bookDto, book);
        book.setCoAuthors(new HashSet<>(coAuthors));

        bookService.save(book);

        return "redirect:/books";
    }


    @GetMapping("/top")
    public String topBooks(@RequestParam(value = "startDate", required = false)
                           @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                           @RequestParam(value = "endDate", required = false)
                           @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
                           Model model) {
        LocalDate minDate = startDate == null ? LocalDate.now().minusYears(100) : startDate;
        LocalDate maxDate = endDate == null ? LocalDate.now().plusYears(100) : endDate;


        List<Book> popularBooks = bookService.getMostPopularBooks(minDate, maxDate);
        List<Book> unpopularBooks = bookService.getLeastPopularBooks(minDate, maxDate);

        model.addAttribute("popularBooksList", DtoUtil.toBooksDtoList(popularBooks));
        model.addAttribute("unpopularBooksList", DtoUtil.toBooksDtoList(unpopularBooks));

        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        return "topBooks";
    }

}
