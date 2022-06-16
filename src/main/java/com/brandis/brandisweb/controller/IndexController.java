package com.brandis.brandisweb.controller;

import com.brandis.brandisweb.service.CurrentUserService;
import com.brandis.brandisweb.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class IndexController {

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private ProjectService projectService;

    @RequestMapping("/")
    public String LogIn(Model model) throws IOException {
        model.addAttribute("userLoggedIn", currentUserService.getUser() != null);
        model.addAttribute("version", "Brandis Web " + projectService.getProjectVersion());
        model.addAttribute("fmode", Boolean.TRUE);
        return "index";
    }
}
