package com.example.bab_recipes.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecipeController {

    /*
    Recipe - main / popular / Recipes_detail
     */

    @GetMapping("/main")
    public String recipe(){
        return "/main";
    }

}
