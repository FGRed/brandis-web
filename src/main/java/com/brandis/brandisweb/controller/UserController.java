package com.brandis.brandisweb.controller;

import com.brandis.brandisweb.service.BUserService;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @Autowired
    private BUserService bUserserv;
    @GetMapping("/login/")
    public String logIn(Model model){
        return "sign-in";
    }

    @PostMapping(path = "/register/")
    public ResponseEntity<String> register(HttpServletRequest request){
        String email = request.getParameter("new-username");
        String pass = request.getParameter("new-password");
        if(!EmailValidator.getInstance().isValid(email) && !StringUtils.hasLength(pass)){
            return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
        }
        bUserserv.register(email,pass);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}
