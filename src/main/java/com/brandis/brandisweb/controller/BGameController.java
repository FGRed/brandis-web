package com.brandis.brandisweb.controller;

import com.brandis.brandisweb.model.bgame.BGame;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BGameController {
    @GetMapping(path = "/get-bgame/")
    public BGame getBGame(){
        BGame bGame = new BGame();
        bGame.setCompanyName("Bgame from backend Co.");
        bGame.setBrand(36.6);
        System.out.println("Loop loop");
        return bGame;
    }
}
