package com.brandis.brandisweb.controller;

import com.brandis.brandisweb.service.CurrentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @Autowired
    private CurrentUserService currentUserService;

    @RequestMapping("/")
    public String LogIn(Model model){
        model.addAttribute("userLoggedIn", currentUserService.getUser() != null);
        return "index";
    }
}
