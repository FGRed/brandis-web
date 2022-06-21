package com.brandis.brandisweb.dto;

import com.brandis.brandisweb.model.bgame.BGame;
import com.brandis.brandisweb.model.bgame.BSavedGame;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameDTO {
    private BGame bGame;
    private BSavedGame bSavedGame;
}
