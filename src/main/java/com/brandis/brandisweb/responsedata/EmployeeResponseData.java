package com.brandis.brandisweb.responsedata;

import com.brandis.brandisweb.model.bemployee.BEmployee;
import com.brandis.brandisweb.model.bemployee.BHiredEmployee;
import lombok.Data;

import java.util.List;

@Data
public class EmployeeResponseData {
    private List<BEmployee> availableEmployees;
    private List<BHiredEmployee> hiredEmployees;
    private Double salaryExpense = 0.0;
}
