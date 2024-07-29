package com.example.bab_recipes.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodayController {

    @GetMapping("/Today")
    public String Today_eat(){
        return "/Today_eat";
    }
}
