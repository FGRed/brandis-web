package com.brandis.brandisweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String LogIn(Model model){
        model.addAttribute("compName", "Brändö");
        return "index";
    }
}
