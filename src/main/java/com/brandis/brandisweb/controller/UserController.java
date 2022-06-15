package com.brandis.brandisweb.controller;

import com.brandis.brandisweb.service.BUserService;
import com.brandis.brandisweb.util.PasswordUtil;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
public class UserController {
    @Autowired
    private BUserService bUserserv;
    @PostMapping(path = "/register/")
    public ResponseEntity<String> register(HttpServletRequest request){
        String email = request.getParameter("new-username");
        String pass = request.getParameter("new-password");
        String pass2 = request.getParameter("new-password2");
        if(!EmailValidator.getInstance().isValid(email) ||
                !PasswordUtil.isValid(pass) || !Objects.equals(pass, pass2)){
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
        bUserserv.register(email,pass);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

}
