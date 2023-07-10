package com.terzoOne.terzoOneBackend.service;

import com.terzoOne.terzoOneBackend.dto.EmployeeCardDto;
import com.terzoOne.terzoOneBackend.dto.EmployeeDto;
import com.terzoOne.terzoOneBackend.models.Employee;

import java.util.List;

public interface EmployeeService {
    List<EmployeeCardDto> findAll();

    Employee getById(int empId);

    void deleteById(int empId);

    void saveEmployee(EmployeeDto employeeDto);
}
