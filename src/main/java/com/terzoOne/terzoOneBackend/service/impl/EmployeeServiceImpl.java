package com.terzoOne.terzoOneBackend.service.impl;

import com.terzoOne.terzoOneBackend.dto.EmployeeCardDto;
import com.terzoOne.terzoOneBackend.dto.EmployeeDto;
import com.terzoOne.terzoOneBackend.models.Employee;
import com.terzoOne.terzoOneBackend.repository.EmployeeRepository;
import com.terzoOne.terzoOneBackend.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.terzoOne.terzoOneBackend.mapper.EmployeeMapper.mapToEmployee;
import static com.terzoOne.terzoOneBackend.mapper.EmployeeMapper.mapToEmployeeCardDto;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

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
    public void saveEmployee(EmployeeDto employeeDto) {
        Employee employee=mapToEmployee(employeeDto);
        employeeRepository.save(employee);
    }

}
