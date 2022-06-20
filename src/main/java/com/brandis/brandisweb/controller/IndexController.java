package com.brandis.brandisweb.controller;

import com.brandis.brandisweb.model.buser.BUser;
import com.brandis.brandisweb.service.AuthorityService;
import com.brandis.brandisweb.service.CurrentUserService;
import com.brandis.brandisweb.service.IndexService;
import com.brandis.brandisweb.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class IndexController {

    @Autowired
    private IndexService indexService;

    @RequestMapping("/")
    public String LogIn(Model model) throws IOException {
        model = indexService.initModel(model);
        return "index";
    }
}
