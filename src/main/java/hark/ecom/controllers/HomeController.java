package hark.ecom.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String DefaultMessage() {
        return "Hello! You have found my server. Please don't do anything unkind.";
    }
}
