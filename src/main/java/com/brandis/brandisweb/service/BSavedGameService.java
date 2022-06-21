package com.brandis.brandisweb.service;

import com.brandis.brandisweb.dto.GameDTO;
import com.brandis.brandisweb.exception.GameException;
import com.brandis.brandisweb.model.bgame.BGame;
import com.brandis.brandisweb.model.bgame.BSavedGame;
import com.brandis.brandisweb.model.buser.BUser;
import com.brandis.brandisweb.repository.BSavedGameRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BSavedGameService implements BaseService<BSavedGame> {


    private final BSavedGameRepository bSavedGameRepository;

    private final CurrentUserService currentUserService;

    @Override
    public List<BSavedGame> findAll() {
        return bSavedGameRepository.findAll();
    }

    @Override
    public BSavedGame save(BSavedGame entity) {
        return bSavedGameRepository.save(entity);
    }

    @SneakyThrows
    @Override
    public BSavedGame findById(long id) {
        Optional<BSavedGame> bSavedGameOpt = bSavedGameRepository.findById(id);
        if(bSavedGameOpt.isPresent()){
            return bSavedGameOpt.get();
        }else {
            throw new GameException("Saved game not found with id " + id);
        }
    }

    @Override
    public void delete(BSavedGame entity) {
        bSavedGameRepository.delete(entity);
    }

    @Override
    public void deleteById(long id) {
        bSavedGameRepository.deleteById(id);
    }

    @Override
    public long count() {
        return bSavedGameRepository.count();
    }

    public GameDTO getRecentSavedGame(){
        BUser loggedInUser = currentUserService.getUser();
        List<BGame> bGames = loggedInUser.getBgames();
        GameDTO gameDTO = new GameDTO();
        if(!bGames.isEmpty()) {
            BGame bGame = bGames.get(bGames.size() - 1);
            List<BSavedGame> bSavedGames = bGame.getSaves();
            gameDTO.setBGame(bGame);
            gameDTO.setBSavedGame(bSavedGames.get(bSavedGames.size()-1));
        }
        return gameDTO;
    }

    public void transferFunds(String method, Double funder, Double receiver) {
        GameDTO gameDTO = getRecentSavedGame();
        BSavedGame bSavedGame = gameDTO.getBSavedGame();
        if(method.equals("userFundsToCompany")) {
            bSavedGame.setUserFunds(funder);
            bSavedGame.setCompanyFunds(receiver);
            save(bSavedGame);
        }else if(method.equals("companyFundsToYou")){
            bSavedGame.setUserFunds(receiver);
            bSavedGame.setCompanyFunds(funder);
            save(bSavedGame);
        }else{
            bSavedGame.setLoanFunds(receiver);
            bSavedGame.setCompanyFunds(funder);
            save(bSavedGame);
        }
    }
}
