package com.brandis.brandisweb.controller;

import com.brandis.brandisweb.model.bgame.BGame;
import com.brandis.brandisweb.service.CurrentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class BGameController {

    @Autowired
    private CurrentUserService currentUserService;

    @GetMapping(path = "/get-bgame/")
    public BGame getBGame(){

        BGame bGame = new BGame();
        if(currentUserService.getUser() != null) {
            bGame.setCompanyName("Test Corporation Group Co.");
            bGame.setBrand(36.6);

        }else {
            bGame.setCompanyName("Company name Co.");
            bGame.setBrand(0.0);
        }

        return bGame;
    }
}
