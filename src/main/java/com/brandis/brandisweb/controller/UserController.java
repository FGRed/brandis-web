package com.brandis.brandisweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/sign-in/")
    public String LogIn(Model model){
        return "sign-in";
    }
}
