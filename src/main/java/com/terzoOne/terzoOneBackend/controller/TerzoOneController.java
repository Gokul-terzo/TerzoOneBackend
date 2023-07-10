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

    @PostMapping("/employee/new")
    public EmployeeDto newEmployeeCreate(@RequestBody EmployeeDto employeeDto){
        employeeService.saveEmployee(employeeDto);
        return employeeDto;
    }

    @DeleteMapping("/employee/{empId}/delete")
    public EmployeeDto deleteEmployee(@PathVariable int empId){
        Employee emp=employeeService.getById(empId);
        EmployeeDto employeeDto=mapToEmployeeDto(emp);
        employeeService.deleteById(empId);
        return employeeDto;
    }

    @PutMapping("/employee/{empId}/edit")
    public EmployeeDto editEmployee(@PathVariable("empId") int empId,@RequestBody EmployeeDto employeeDto) {
        employeeDto.setId(empId);
        employeeService.saveEmployee(employeeDto);
        return employeeDto;
    }
}
