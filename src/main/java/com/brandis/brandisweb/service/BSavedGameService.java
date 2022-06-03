package com.brandis.brandisweb.service;

import com.brandis.brandisweb.exception.GameException;
import com.brandis.brandisweb.model.bgame.BSavedGame;
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
}
