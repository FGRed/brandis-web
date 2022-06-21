package com.brandis.brandisweb.service;

import com.brandis.brandisweb.model.buser.BUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.io.IOException;

@Service
public class IndexService {

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private ProjectService projectService;

    public Model initModel(Model model) throws IOException {
        model.addAttribute("userLoggedIn", currentUserService.getUser() != null);
        model.addAttribute("version", "Brandis Web " + projectService.getProjectVersion());
        model.addAttribute("fmode", Boolean.TRUE);
        BUser bUser = currentUserService.getUser();
        if(bUser != null) {
            model.addAttribute("username", currentUserService.getUser().getUsername());
        }
        return model;
    }


}
