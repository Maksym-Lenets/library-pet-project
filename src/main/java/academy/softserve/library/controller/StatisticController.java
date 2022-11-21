package academy.softserve.library.controller;

import academy.softserve.library.dto.RequestReadBookDto;
import academy.softserve.library.model.Request;
import academy.softserve.library.service.BookInstanceService;
import academy.softserve.library.service.BookService;
import academy.softserve.library.service.RequestService;
import academy.softserve.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/statistic")
public class StatisticController {
    private UserService userService;
    private BookInstanceService bookInstanceService;
    private BookService bookService;
    private RequestService requestService;

    @Autowired
    public StatisticController(UserService userService, BookInstanceService bookInstanceService, BookService bookService, RequestService requestService) {
        this.userService = userService;
        this.bookInstanceService = bookInstanceService;
        this.bookService = bookService;
        this.requestService =requestService;
    }

    @GetMapping("/reader/{userId}")
    public String getAllPerPage(@PathVariable Long userId, Model model) {
        List<RequestReadBookDto> requests = requestService.getAllByUserId(userId);
        model.addAttribute("listRequest", requests);
        return "bookStatistic";
    }
}
