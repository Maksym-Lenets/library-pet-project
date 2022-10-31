package academy.softserve.library.controller;

import academy.softserve.library.model.User;
import academy.softserve.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String booksPage(ModelMap model, @RequestParam String email, @RequestParam String password) {
        User user =  userService.getUserByEmail(email);
        if (user.getPassword().equals(password)) {
            model.put("user",user);
            return "books";
        }
        model.put("errorMsg","Please provide your credentials!");
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registrationPage(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("user") User user, ModelMap model){
        User saveUser = userService.save(user);
        if(user==null){
            model.put("errorMsg", "Some issue with registration");
            return "register";
        }
        model.put("successMsg","User created successfully");
        return "login";
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