package academy.softserve.library.controller;

import academy.softserve.library.dto.RequestReadBookDto;
import academy.softserve.library.dto.UserNotReturnedBookInTimeDto;
import academy.softserve.library.model.Request;
import academy.softserve.library.model.Role;
import academy.softserve.library.model.User;
import academy.softserve.library.service.RequestService;
import academy.softserve.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@Controller("/user")
public class UserController {
    private UserService userService;
    private RequestService requestService;

    @Autowired
    public UserController(UserService userService, RequestService requestService) {
        this.userService = userService;
        this.requestService = requestService;
    }

    @GetMapping(value = "/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping(value = "/register")
    public String registrationPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping(value = "/register")
    public String registerUser(ModelMap model,
                               @RequestParam String firstName,
                               @RequestParam String lastName,
                               @RequestParam String birthday,
                               @RequestParam String email,
                               @RequestParam String password) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setBirthday(LocalDate.parse(birthday));
        user.setRegistrationDate(LocalDate.now());
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(Role.READER);
        User saveUser = userService.save(user);
        if (saveUser == null) {
            model.put("errorMsg", "Some issue with registration");
            return "register";
        }
        model.put("successMsg", "User created successfully");
        return "login";
    }

    @GetMapping(value = "/logout")
    public String mainPage() {
        return "books";
    }

    @GetMapping("/users/books/statistic")
    @Secured({"ROLE_READER", "ROLE_MANAGER"})
    public String getAllReadBooks(Principal principal, Model model) {
        List<RequestReadBookDto> requests = requestService.getAllSuccessfulByUserId(userService.getUserByEmail(principal.getName()).getId());
        model.addAttribute("listRequest", requests);
        return "userBooksStatistic";
    }

    @GetMapping("/users/not_returned_book/statistic")
    @Secured("ROLE_MANAGER")
    public String getAllNotReturned(Model model) {
        List<UserNotReturnedBookInTimeDto> users = userService.getAllNotReturnedInTime();
        model.addAttribute("listUser", users);
        return "userNotReturnedBooks";
    }

    @GetMapping("/readers/statistic")
    @Secured("ROLE_MANAGER")
    public String getReadersStatistic(@RequestParam(value = "startDate", required = false)
                                      @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                      @RequestParam(value = "endDate", required = false)
                                      @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate, Model model) {
        Long averageAge = userService.getAverageAge();
        LocalDate minDate = startDate == null ? LocalDate.now().minusYears(100) : startDate;
        LocalDate maxDate = endDate == null ? LocalDate.now().plusYears(100) : endDate;
        List<Request> requests = requestService.get(minDate, maxDate);
        model.addAttribute("averageAge", averageAge);
        model.addAttribute("requests", requests);
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        return "readersStatistic";
    }

}
