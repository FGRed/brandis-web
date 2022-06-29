package com.brandis.brandisweb.controller;

import com.brandis.brandisweb.dto.GameDTO;
import com.brandis.brandisweb.model.bemployee.BHiredEmployee;
import com.brandis.brandisweb.param.EmployeeInfo;
import com.brandis.brandisweb.repository.BEmployeeRepository;
import com.brandis.brandisweb.responsedata.EmployeeResponseData;
import com.brandis.brandisweb.service.BHiredEmployeeService;
import com.brandis.brandisweb.service.BSavedGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
        @Autowired
        private final BSavedGameService bSavedGameService;
        @Autowired
        private final BHiredEmployeeService bHiredEmployeeService;
        @Autowired
        private  BEmployeeRepository employeeRepository;

    public EmployeeController(BSavedGameService bSavedGameService, BHiredEmployeeService bHiredEmployeeService) {
        this.bSavedGameService = bSavedGameService;
        this.bHiredEmployeeService = bHiredEmployeeService;
    }


        @GetMapping(path = "/current-employees/")
        public EmployeeResponseData findCurrentEmployees(){
            return bHiredEmployeeService.getEmployeeData();
        }

        @PostMapping(path = "/hire-employee/")
        @ResponseBody
        public ResponseEntity<String> hireEmployee(@RequestBody EmployeeInfo employeeInfo){
            if(bHiredEmployeeService.hireEmployee(employeeInfo)){
                return new ResponseEntity<>(HttpStatus.OK);
            }else {
                return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        @PostMapping(path = "/fire-employee/")
        @ResponseBody
        public ResponseEntity<String> fireEmployee(@RequestBody EmployeeInfo employeeInfo){

            GameDTO gameDTO = bSavedGameService.getRecentSavedGame();
            BHiredEmployee bHiredEmployee = bHiredEmployeeService.findById(employeeInfo.getId());
            boolean employeeFired = gameDTO
                    .getBSavedGame()
                    .getHiredEmployees()
                    .removeIf(bEmployee -> Objects.equals(bEmployee.getId(), employeeInfo.getId()));
            if(employeeFired){
                gameDTO.getBSavedGame().getAvailableEmployees().add(bHiredEmployee.getEmployee());
                return new ResponseEntity<>(HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

    @PostMapping(path = "/fire-employees/")
    @ResponseBody
    public ResponseEntity<String> fireEmployees(final HttpServletRequest httpServletRequest){

        String[] rowsArr = httpServletRequest.getParameterValues("employeeRow");
        List<Long> ids = new ArrayList<>();
        for(String row : rowsArr){
            ids.add(Long.valueOf(row));
        }

        List<Boolean> statuses = new ArrayList<>();
        GameDTO gameDTO = bSavedGameService.getRecentSavedGame();
        ids.forEach(id -> {
            BHiredEmployee bHiredEmployee = bHiredEmployeeService.findById(id);
            boolean employeeFired = gameDTO
                    .getBSavedGame()
                    .getHiredEmployees()
                    .removeIf(bEmployee -> Objects.equals(bEmployee.getId(), id));
            statuses.add(employeeFired);
            gameDTO.getBSavedGame().getAvailableEmployees().add(bHiredEmployee.getEmployee());
        });

        if(statuses.contains(false)){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }else{
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }

        @PostMapping(path = "/change-salary/")
        @ResponseBody
        public ResponseEntity<String> changeSalary(@RequestBody EmployeeInfo employeeInfo){

            GameDTO gameDTO = bSavedGameService.getRecentSavedGame();
            gameDTO.getBSavedGame().getHiredEmployees().forEach( bHiredEmployee -> {
                if(Objects.equals(bHiredEmployee.getId(), employeeInfo.getId())) {
                    bHiredEmployee.setSalary(employeeInfo.getSalary());
                }
            });


            return new ResponseEntity<>(HttpStatus.OK);
        }


}
