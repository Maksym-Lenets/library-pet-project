package academy.softserve.library.controller;

import academy.softserve.library.model.Role;
import academy.softserve.library.model.User;
import academy.softserve.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/login")
    public String loginPage(){
        return "login";
    }

    @PostMapping(value = "/login")
    public String booksPage(ModelMap model, @RequestParam String email, @RequestParam String password) {
        User user =  userService.getUserByEmail(email);
        if (user.getPassword().equals(password)) {
            model.put("user",user);
            return "books";
        }
        model.put("errorMsg","Please provide your credentials!");
        return "login";
    }

    @GetMapping(value = "/register")
    public String registrationPage(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "register";
    }

    @PostMapping(value = "/register")
    public String registerUser(ModelMap model,
                               @RequestParam String firstName,
                               @RequestParam String lastName,
                               @RequestParam String birthday,
                               @RequestParam String email,
                               @RequestParam String password){
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setBirthday(LocalDate.parse(birthday));
        user.setRegistrationDate(LocalDate.now());
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(Role.READER);
        User saveUser = userService.save(user);
        if(saveUser==null){
            model.put("errorMsg", "Some issue with registration");
            return "register";
        }
        model.put("successMsg","User created successfully");
        return "login";
    }
    @GetMapping(value = "/logout")
    public String mainPage(){
        return "books";
    }
}
//package academy.softserve.library.controller;
//
//        import academy.softserve.library.model.User;
//        import academy.softserve.library.service.UserService;
//        import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.stereotype.Controller;
//        import org.springframework.ui.ModelMap;
//        import org.springframework.web.bind.annotation.RequestMapping;
//        import org.springframework.web.bind.annotation.RequestMethod;
//        import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//@RequestMapping
//public class LoginController {
//    UserService userService;
//
//    @Autowired
//    public LoginController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String loginPage(){
//        return "login";
//    }
//
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String booksPage(ModelMap model, @RequestParam String email, @RequestParam String password) {
//        User user =  userService.getUserByEmail(email);
//        if (user.getPassword().equals(password)) {
//            model.put("email",email);
//            return "books";
//        }
//        model.put("errorMsg","Please provide your credentials!");
//        return "login";
//    }
//
//
//}