package com.terzoOne.terzoOneBackend.service.impl;

import com.terzoOne.terzoOneBackend.dto.DashboardEmployeesDto;
import com.terzoOne.terzoOneBackend.dto.EmployeeCardDto;
import com.terzoOne.terzoOneBackend.dto.EmployeeDto;
import com.terzoOne.terzoOneBackend.models.Employee;
import com.terzoOne.terzoOneBackend.models.Leaves;
import com.terzoOne.terzoOneBackend.repository.EmployeeRepository;
import com.terzoOne.terzoOneBackend.service.EmployeeService;
import com.terzoOne.terzoOneBackend.service.LeavesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.terzoOne.terzoOneBackend.mapper.EmployeeMapper.*;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    private final LeavesService leavesService;
    public List<EmployeeCardDto> findAll(){
        List<Employee> employees=employeeRepository.findAll();
        return employees.stream().map(e->mapToEmployeeCardDto(e)).collect(Collectors.toList());
    }

    @Override
    public Employee getById(int empId) {
        return employeeRepository.getById(empId);
    }

    @Override
    public void deleteById(int empId) {
        employeeRepository.deleteById(empId);
    }

    @Override
    public void savenewEmployee(EmployeeDto employeeDto) {
        Employee employee=mapToEmployee(employeeDto);
        Leaves leaves=new Leaves();
        leaves.setEarnedLeave(6);
        leaves.setMedicalLeave(12);
        leaves.setPaternityLeave(12);
        employeeRepository.save(employee);
        leaves.setEmployee(employee);
        leavesService.saveLeaves(leaves);

    }

    @Override
    public List<EmployeeDto> sortEmployeesByName(String order) {
        List<Employee> employees=employeeRepository.findAll();
        List<Employee> sortedEmployees;
        if(order.equals("ascending"))
        {
             sortedEmployees= employees.stream()
                    .sorted(Comparator.comparing(Employee::getName))
                    .collect(Collectors.toList());
        }
        else{
            sortedEmployees=employees.stream()
                    .sorted(Comparator.comparing(Employee::getName).reversed())
                    .collect(Collectors.toList());

        }
        return sortedEmployees.stream().map(e->mapToEmployeeDto(e)).collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDto> sortEmployeesByDept(String order) {
        List<Employee> employees=employeeRepository.findAll();
        List<Employee> sortedEmployees;
        if(order.equals("ascending"))
        {
            sortedEmployees= employees.stream()
                    .sorted(Comparator.comparing(Employee::getDepartment))
                    .collect(Collectors.toList());
        }
        else{
            sortedEmployees=employees.stream()
                    .sorted(Comparator.comparing(Employee::getDepartment).reversed())
                    .collect(Collectors.toList());

        }
        return sortedEmployees.stream().map(e->mapToEmployeeDto(e)).collect(Collectors.toList());
    }
    @Override
    public void saveEmployee(EmployeeDto employeeDto) {
        Employee employee=mapToEmployee(employeeDto);
        employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeDto> searchEmployees(String query) {
        List<Employee> employees= employeeRepository.searchEmployees(query);
        return employees.stream().map(employee -> mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public List<DashboardEmployeesDto> searchBirthdayBuddies() {
        List<Employee> employees=employeeRepository.findBirthdayBuddies(LocalDate.now());
        List<DashboardEmployeesDto> dashboardEmployeesDto;
        dashboardEmployeesDto=employees.stream().map(e->mapToDashboardEmployeesDto(e)).collect(Collectors.toList());
        return dashboardEmployeesDto;
    }

    @Override
    public List<DashboardEmployeesDto> workAnniversary() {
        List<Employee> employees=employeeRepository.findAnniversary(LocalDate.now());
        List<DashboardEmployeesDto> dashboardEmployeesDto;
        dashboardEmployeesDto=employees.stream().map(e->mapToDashboardEmployeesDto(e)).collect(Collectors.toList());
        return dashboardEmployeesDto;
    }

    @Override
    public List<DashboardEmployeesDto> newHires() {
        List<Employee> employees=employeeRepository.findNewHires(LocalDate.now());
        List<DashboardEmployeesDto> dashboardEmployeesDto;
        dashboardEmployeesDto=employees.stream().map(e->mapToDashboardEmployeesDto(e)).collect(Collectors.toList());
        return dashboardEmployeesDto;
    }

    @Override
    public Employee getByEmail(String email) {
        Employee employee=employeeRepository.getEmployeeByEmail(email);
        return employee;
    }

}
