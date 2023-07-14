package com.terzoOne.terzoOneBackend.service;

import com.terzoOne.terzoOneBackend.dto.DashboardEmployeesDto;
import com.terzoOne.terzoOneBackend.dto.EmployeeCardDto;
import com.terzoOne.terzoOneBackend.dto.EmployeeDto;
import com.terzoOne.terzoOneBackend.models.Employee;

import java.util.List;
import java.util.SplittableRandom;

public interface EmployeeService {
    List<EmployeeCardDto> findAll();

    Employee getById(int empId);

    void deleteById(int empId);

    void saveEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> searchEmployees(String query);

    List<DashboardEmployeesDto> searchBirthdayBuddies();

    List<DashboardEmployeesDto> workAnniversary();

    List<DashboardEmployeesDto> newHires();

    Employee getByEmail(String email);

    void savenewEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> sortEmployeesByName(String order);

    List<EmployeeDto> sortEmployeesByDept(String order);
}
