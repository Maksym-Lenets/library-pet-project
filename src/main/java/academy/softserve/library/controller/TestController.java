package academy.softserve.library.controller;

import academy.softserve.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
    private AuthorService authorService;

    @Autowired
    public TestController( AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public String test() {
        return "test";
    }
}
