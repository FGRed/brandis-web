package com.brandis.brandisweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {
    @GetMapping ("/get-company-name/")
    public String GetCompanyName(){
        return "Brändös";
    }
}
