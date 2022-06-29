package com.brandis.brandisweb.service;

import com.brandis.brandisweb.enums.Difficulty;
import com.brandis.brandisweb.exception.GameException;
import com.brandis.brandisweb.model.bemployee.BEmployee;
import com.brandis.brandisweb.model.bemployee.BHiredEmployee;
import com.brandis.brandisweb.model.bgame.BGame;
import com.brandis.brandisweb.model.bgame.BSavedGame;
import com.brandis.brandisweb.model.buser.BUser;
import com.brandis.brandisweb.repository.BEmployeeRepository;
import com.brandis.brandisweb.repository.BGameRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BGameService implements BaseService<BGame> {

    private final BGameRepository bGameRepository;

    private final BSavedGameService bSavedGameService;
    private final CurrentUserService currentUserService;

    private final BHiredEmployeeService hiredEmployeeService;

    private final BEmployeeRepository employeeRepository;

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

        BSavedGame bSavedGame = new BSavedGame();
        Difficulty difficulty = Difficulty.valueOf(difficulties.get(0).toUpperCase());
        double balance = 0.0;
        double brand = 0.0;
        double loan = 100.0;
        if(difficulty == Difficulty.EASY){
            balance = 10000.0;
            brand = 30.0;
        }else if(difficulty == Difficulty.NORMAL){
            balance = 5000.0;
            loan = 100.0;
            brand = 20.0;
        }else if(difficulty == Difficulty.HARD){
            balance = 2500.0;
            brand = 10.0;
        }else if(difficulty == Difficulty.VERY_HARD){
            balance = 100.0;
            brand = 0.0;
        }else if(difficulty == Difficulty.DEV_TEST){
            balance = 100000000.0;
            brand = 30.0;

        }

        BEmployee employee = new BEmployee();
        employee.setName("Bertti Backend");
        employeeRepository.save(employee);

        BEmployee employee2 = new BEmployee();
        employee2.setName("Erkki esimerkki");
        employeeRepository.save(employee2);

        BEmployee employee3 = new BEmployee();
        employee3.setName("Tauno Jallinen");
        employeeRepository.save(employee3);

        bSavedGame.getAvailableEmployees().add(employee2);
        bSavedGame.getAvailableEmployees().add(employee3);

        BHiredEmployee bHiredEmployee = new BHiredEmployee(employee, 2000.0);
        bHiredEmployee = hiredEmployeeService.save(bHiredEmployee);
        bSavedGame.getHiredEmployees().add(bHiredEmployee);


        bSavedGame.setUserFunds(balance);
        bSavedGame.setBrand(brand);
        bSavedGame.setLoanFunds(loan);
        bSavedGame.setCompanyFunds(0.0);
        bSavedGame = bSavedGameService.save(bSavedGame);

        BGame bGame = BGame
                .builder()
                .originalBalance(balance)
                .companyName(companyName)
                .build();

        bGame = bGameRepository.save(bGame);
        bGame.setSaves(Collections.singletonList(bSavedGame));
        BUser currentUser = currentUserService.getUser();
        currentUser.getBgames().add(bGame);
        return bGame;
    }



}
