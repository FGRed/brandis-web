package com.brandis.brandisweb.controller;

import com.brandis.brandisweb.model.bgame.BGame;
import com.brandis.brandisweb.model.buser.BUser;
import com.brandis.brandisweb.service.BGameService;
import com.brandis.brandisweb.service.CurrentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class BGameController {

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private BGameService bGameService;

    @GetMapping(path = "/get-bgame/")
    @ResponseBody
    public BGame getBGame(){

        BGame bGame = new BGame();
        BUser currUser = currentUserService.getUser();

        if(currentUserService.getUser() != null) {
            List<BGame> games = currUser.getBgames();
            if(games.isEmpty()){
                bGame.setCompanyName("");
                bGame.setBrand(0.0);
            }else {
                bGame = games.get(games.size()-1);
            }


        }else {
            bGame.setCompanyName("");
            bGame.setBrand(0.0);
        }

        return bGame;
    }

    @PostMapping(path = "/create-new-game/")
    public String newGame(@RequestParam("companyName") final String companyName){
        bGameService.createNew(companyName);
        return "redirect:/";
    }

}
