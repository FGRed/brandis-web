package com.brandis.brandisweb.controller;

import com.brandis.brandisweb.dto.GameDTO;
import com.brandis.brandisweb.model.bgame.BGame;
import com.brandis.brandisweb.model.bgame.BSavedGame;
import com.brandis.brandisweb.model.buser.BUser;
import com.brandis.brandisweb.service.BGameService;
import com.brandis.brandisweb.service.BSavedGameService;
import com.brandis.brandisweb.service.CurrentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class BGameController {

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private BGameService bGameService;

    @Autowired
    private BSavedGameService bSavedGameService;

    @GetMapping(path = "/get-bgame/")
    @ResponseBody
    public GameDTO getBGame(){

        GameDTO gameDTO = new GameDTO();

        BGame bGame = new BGame();
        BUser currUser = currentUserService.getUser();

        if(currentUserService.getUser() != null) {
            List<BGame> games = currUser.getBgames();
            if(games.isEmpty()){
                bGame.setCompanyName("");
            }else {
                bGame = games.get(games.size()-1);
            }

            List<BSavedGame> bSavedGames = bGame.getSaves();
            if(!bSavedGames.isEmpty()) {
                gameDTO.setBSavedGame(bSavedGames.get(bSavedGames.size() - 1));
            }
        }else {
            bGame.setCompanyName("");
        }

        gameDTO.setBGame(bGame);

        return gameDTO;
    }

    @PostMapping(path = "/create-new-game/")
    public String newGame(@RequestParam("companyName") final String companyName, @RequestParam("difficulty") List<String> difficulty){
        bGameService.createNew(companyName, difficulty);
        return "redirect:/";
    }



}
