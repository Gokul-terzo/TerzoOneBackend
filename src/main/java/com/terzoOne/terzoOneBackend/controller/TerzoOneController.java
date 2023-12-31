package com.terzoOne.terzoOneBackend.controller;

import java.util.*;

import com.terzoOne.terzoOneBackend.dto.EmployeeCardDto;
import com.terzoOne.terzoOneBackend.dto.EmployeeDto;
import com.terzoOne.terzoOneBackend.models.Employee;
import com.terzoOne.terzoOneBackend.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import static com.terzoOne.terzoOneBackend.mapper.EmployeeMapper.mapToEmployeeDto;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class TerzoOneController {
    private EmployeeService employeeService;

    public TerzoOneController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<EmployeeCardDto> employeesList(){
        List<EmployeeCardDto> employees=employeeService.findAll();
        return employees;
    }

    @PostMapping("/admin/employee/new")
    public EmployeeDto newEmployeeCreate(@RequestBody EmployeeDto employeeDto){
        employeeService.savenewEmployee(employeeDto);
        return employeeDto;
    }

    @GetMapping("/employee/{empId}/view")
    public EmployeeDto getEmployeeDetails(@PathVariable int empId){
        Employee employee=employeeService.getById(empId);
        EmployeeDto employeeDto=mapToEmployeeDto(employee);
        return employeeDto;
    }



    @DeleteMapping("/admin/employee/{empId}/delete")
    public EmployeeDto deleteEmployee(@PathVariable int empId){
        Employee emp=employeeService.getById(empId);
        EmployeeDto employeeDto=mapToEmployeeDto(emp);
        employeeService.deleteById(empId);
        return employeeDto;
    }

    @PutMapping("/admin/employee/{empId}/edit")
    public EmployeeDto editEmployee(@PathVariable("empId") int empId,@RequestBody EmployeeDto employeeDto) {
        employeeDto.setId(empId);
        employeeService.saveEmployee(employeeDto);
        return employeeDto;
    }

    @GetMapping("/employees/search/{query}")
    public List<EmployeeDto> searchEmployees(@PathVariable String query){
        List<EmployeeDto> employees = employeeService.searchEmployees(query);
        return employees;
    }

    @GetMapping("/employees/sort-by-name/{query}")
    public List<EmployeeDto> sortEmployeesByName(@PathVariable String query){
        List<EmployeeDto> employees = employeeService.sortEmployeesByName(query);
        return employees;
    }

    @GetMapping("/employees/sort-by-department/{query}")
    public List<EmployeeDto> sortEmployeesByDept(@PathVariable String query){
        List<EmployeeDto> employees = employeeService.sortEmployeesByDept(query);
        return employees;
    }
}
