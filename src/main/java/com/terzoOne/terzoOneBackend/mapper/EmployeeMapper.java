package com.terzoOne.terzoOneBackend.mapper;

import com.terzoOne.terzoOneBackend.dto.EmployeeCardDto;
import com.terzoOne.terzoOneBackend.dto.EmployeeDto;
import com.terzoOne.terzoOneBackend.models.Employee;

public class EmployeeMapper {
    public static EmployeeCardDto mapToEmployeeCardDto(Employee employee){
        EmployeeCardDto employeeCardDto= EmployeeCardDto.builder()
                .id(employee.getId())
                .name(employee.getName())
                .designation(employee.getDesignation())
                .department(employee.getDepartment())
                .profileUrl(employee.getProfileUrl()).build();
        return employeeCardDto;
    }
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        EmployeeDto employeeDto= EmployeeDto.builder()
                .id(employee.getId())
                .name(employee.getName())
                .designation(employee.getDesignation())
                .department(employee.getDepartment())
                .employeeType(employee.getEmployeeType())
                .dob(employee.getDob())
                .email(employee.getEmail())
                .status(employee.getStatus())
                .mobile(employee.getMobile())
                .team(employee.getTeam())
                .workLocation(employee.getWorkLocation())
                .doj(employee.getDoj())
                .profileUrl(employee.getProfileUrl()).build();
        return employeeDto;
    }
    public static Employee mapToEmployee(EmployeeDto employeedto){
        Employee employee= Employee.builder()
                .id(employeedto.getId())
                .name(employeedto.getName())
                .designation(employeedto.getDesignation())
                .department(employeedto.getDepartment())
                .employeeType(employeedto.getEmployeeType())
                .dob(employeedto.getDob())
                .email(employeedto.getEmail())
                .status(employeedto.getStatus())
                .mobile(employeedto.getMobile())
                .team(employeedto.getTeam())
                .workLocation(employeedto.getWorkLocation())
                .doj(employeedto.getDoj())
                .profileUrl(employeedto.getProfileUrl()).build();
        return employee;
    }
}
