package com.brandis.brandisweb.controller;

import com.brandis.brandisweb.dto.GameDTO;
import com.brandis.brandisweb.service.BSavedGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BSavedGameController {

    @Autowired
    private BSavedGameService bSavedGameService;

    @GetMapping(path = "/get-recent-save/")
    public GameDTO getRecentGame(){
        return bSavedGameService.getRecentSavedGame();
    }
}
