package hark.ecom.controllers;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/dev")

public class DevController {

    @GetMapping("/hello")
    public String GetHello() {
        return "Hello there.";
    }
}
