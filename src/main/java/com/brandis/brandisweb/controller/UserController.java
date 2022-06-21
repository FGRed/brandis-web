package com.brandis.brandisweb.controller;

import com.brandis.brandisweb.model.buser.BUser;
import com.brandis.brandisweb.service.AuthorityService;
import com.brandis.brandisweb.service.BUserService;
import com.brandis.brandisweb.service.CurrentUserService;
import com.brandis.brandisweb.service.ProjectService;
import com.brandis.brandisweb.util.PasswordUtil;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Controller
public class UserController {
    @Autowired
    private BUserService bUserserv;

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private CurrentUserService currentUserService;

    @PostMapping(path = "/register/")
    public String register(HttpServletRequest request){
        String email = request.getParameter("new-username");
        String pass = request.getParameter("new-password");
        String pass2 = request.getParameter("new-password2");
        if(!EmailValidator.getInstance().isValid(email) ||
                !PasswordUtil.isValid(pass) || !Objects.equals(pass, pass2)){
            return "redirect:/error";
        }
        bUserserv.register(email,pass);
        return "redirect:/";
    }

    @PostMapping(path = "/module-login/")
    public String moduleLogin(@RequestParam("username") final String username,
                        @RequestParam("password") final String password, Model model){
        model.addAttribute("userLoggedIn", true);
        BUser bUser = currentUserService.getUser();
        if(bUser != null) {
            model.addAttribute("username", currentUserService.getUser().getUsername());
        }
        try {
            model.addAttribute("version", "Brandis Web " + projectService.getProjectVersion());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        model.addAttribute("fmode", Boolean.TRUE);
        authorityService.loginDirectly(username, password);
        return "redirect:/";
    }

    @GetMapping(path = "/module-logout/")
    public String moduleLogout(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        return "redirect:/";
    }

}
