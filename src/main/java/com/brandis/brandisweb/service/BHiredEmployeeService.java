package com.brandis.brandisweb.service;

import com.brandis.brandisweb.dto.GameDTO;
import com.brandis.brandisweb.model.bemployee.BEmployee;
import com.brandis.brandisweb.model.bemployee.BHiredEmployee;
import com.brandis.brandisweb.param.EmployeeInfo;
import com.brandis.brandisweb.repository.BEmployeeRepository;
import com.brandis.brandisweb.repository.BHiredEmployeeRepository;
import com.brandis.brandisweb.responsedata.EmployeeResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BHiredEmployeeService implements BaseService<BHiredEmployee> {

    @Autowired
    private BSavedGameService bSavedGameService;
    @Autowired
    private BHiredEmployeeRepository hiredEmployeeRepository;

    @Autowired
    private BEmployeeRepository employeeRepository;



    @Override
    public List<BHiredEmployee> findAll() {
        return hiredEmployeeRepository.findAll();
    }

    @Override
    public BHiredEmployee save(BHiredEmployee entity) {
        return hiredEmployeeRepository.save(entity);
    }


    @Override
    public BHiredEmployee findById(long id) {
        Optional<BHiredEmployee> employeeOptional = hiredEmployeeRepository.findById(id);
        return employeeOptional.orElse(null);
    }

    @Override
    public void delete(BHiredEmployee entity) {
        hiredEmployeeRepository.delete(entity);
    }

    @Override
    public void deleteById(long id) {
        hiredEmployeeRepository.deleteById(id);
    }

    @Override
    public long count() {
        return hiredEmployeeRepository.count();
    }

    public EmployeeResponseData getEmployeeData(){
        EmployeeResponseData employeeResponseData = new EmployeeResponseData();
        GameDTO gameDTO = bSavedGameService.getRecentSavedGame();
        if(gameDTO.getBSavedGame() != null) {
            employeeResponseData.setAvailableEmployees(gameDTO.getBSavedGame().getAvailableEmployees());
            employeeResponseData.setHiredEmployees(gameDTO.getBSavedGame().getHiredEmployees());

            gameDTO.getBSavedGame().getHiredEmployees().forEach(bHiredEmployee -> {
                employeeResponseData.setSalaryExpense(employeeResponseData.getSalaryExpense() + bHiredEmployee.getSalary());
            });
        }
        return employeeResponseData;
    }

    public boolean hireEmployee(final EmployeeInfo employeeInfo){
        Long id = employeeInfo.getId();

        boolean removed = bSavedGameService.getRecentSavedGame()
                .getBSavedGame()
                .getAvailableEmployees()
                .removeIf(bEmployee -> Objects.equals(bEmployee.getId(), id));
        if(!removed) return false;

        Optional<BEmployee> bEmployeeOptional = employeeRepository.findById(id);
        if(!bEmployeeOptional.isPresent()) return false;
        BHiredEmployee bHiredEmployee = new BHiredEmployee();
        bHiredEmployee.setEmployee(bEmployeeOptional.get());
        bHiredEmployee.setSalary(employeeInfo.getSalary());
        bHiredEmployee = save(bHiredEmployee);

        bSavedGameService.getRecentSavedGame()
                .getBSavedGame().getHiredEmployees().add(bHiredEmployee);
        return true;

    }
}
