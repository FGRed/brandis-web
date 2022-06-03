package com.brandis.brandisweb.service;

import com.brandis.brandisweb.exception.GameException;
import com.brandis.brandisweb.model.bgame.BGame;
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

    /*public Object rollMonth(BGame game){

    }*/
}
