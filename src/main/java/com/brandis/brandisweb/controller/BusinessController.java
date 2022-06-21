package com.brandis.brandisweb.controller;

import com.brandis.brandisweb.service.BSavedGameService;
import com.brandis.brandisweb.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class BusinessController {

    @Autowired
    private BSavedGameService bSavedGameService;

    @Autowired
    private IndexService indexService;

    @PostMapping(value = "/transfer-funds/")
    public String handleRequest(@RequestParam("method") String method,
                               @RequestParam("funder") Double funder,
                               @RequestParam("receiver") Double receiver,
                                Model model) throws IOException {
        bSavedGameService.transferFunds(method, funder, receiver);
        model = indexService.initModel(model);

        return "redirect:/";
    }


}
