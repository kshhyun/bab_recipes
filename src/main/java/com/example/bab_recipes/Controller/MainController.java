package com.example.bab_recipes.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "/login";
    }

    @GetMapping("/bookmark")
    public String bookmark() {
        return "/bookmark";
    }
}
