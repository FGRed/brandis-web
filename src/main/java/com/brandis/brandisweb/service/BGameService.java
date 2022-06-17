package com.brandis.brandisweb.service;

import com.brandis.brandisweb.enums.Difficulty;
import com.brandis.brandisweb.exception.GameException;
import com.brandis.brandisweb.model.bgame.BGame;
import com.brandis.brandisweb.model.buser.BUser;
import com.brandis.brandisweb.repository.BGameRepository;
import com.brandis.brandisweb.repository.BSavedGameRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BGameService implements BaseService<BGame> {

    private final BGameRepository bGameRepository;
    private final BSavedGameRepository bSavedGameRepository;
    private final CurrentUserService currentUserService;
    private final BUserService bUserService;

    @Override
    public List<BGame> findAll() {
        return bGameRepository.findAll();
    }

    @Override
    public BGame save(BGame entity) {
        return bGameRepository.save(entity);
    }

    @SneakyThrows
    @Override
    public BGame findById(long id) {
        Optional<BGame> bGameOptional = bGameRepository.findById(id);
        if(bGameOptional.isPresent()){
            return bGameOptional.get();
        }else {
            throw new GameException("No game found with id " + id);
        }
    }

    @Override
    public void delete(BGame entity) {
        bGameRepository.delete(entity);
    }

    @Override
    public void deleteById(long id) {
        bGameRepository.deleteById(id);
    }

    @Override
    public long count() {
        return bGameRepository.count();
    }

    public BGame createNew(String companyName, List<String> difficulties){

        Difficulty difficulty = Difficulty.valueOf(difficulties.get(0).toUpperCase());
        double balance = 0.0;
        double brand = 0.0;
        if(difficulty == Difficulty.EASY){
            balance = 10000000.0;
            brand = 30.0;
        }else if(difficulty == Difficulty.NORMAL){
            balance = 500000.0;
            brand = 20.0;
        }else if(difficulty == Difficulty.HARD){
            balance = 250000.0;
            brand = 10.0;
        }else if(difficulty == Difficulty.VERY_HARD){
            balance = 125000.0;
            brand = 0.0;
        }

        BGame bGame = BGame
                .builder()
                .balance(balance)
                .companyName(companyName)
                .brand(brand)
                .build();

        bGame = bGameRepository.save(bGame);
        BUser currentUser = currentUserService.getUser();
        currentUser.getBgames().add(bGame);
        return bGame;
    }
}
