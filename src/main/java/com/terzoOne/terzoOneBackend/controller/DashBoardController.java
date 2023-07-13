package com.terzoOne.terzoOneBackend.controller;

import com.terzoOne.terzoOneBackend.dto.DashboardEmployeesDto;
import com.terzoOne.terzoOneBackend.dto.EmployeeDto;
import com.terzoOne.terzoOneBackend.models.Employee;
import com.terzoOne.terzoOneBackend.models.Holidays;
import com.terzoOne.terzoOneBackend.service.EmployeeService;
import com.terzoOne.terzoOneBackend.service.HolidayService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.terzoOne.terzoOneBackend.mapper.EmployeeMapper.mapToEmployeeDto;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/dashboard")
public class DashBoardController {

    private final EmployeeService employeeService;
    private final HolidayService holidayService;
    @GetMapping("/holidays")
    public List<Holidays> getHolidays(){
       List<Holidays> holidaysList;
       holidaysList=holidayService.getHolidays();
       return holidaysList;
    }

    @GetMapping("/employee/{email}/get")
    public EmployeeDto getEmployeeDetails(@PathVariable String email){
        Employee employee=employeeService.getByEmail(email);
        EmployeeDto employeeDto=mapToEmployeeDto(employee);
        return employeeDto;
    }

    @GetMapping("/new-hires")
    public List<DashboardEmployeesDto> getNewHires() {
        List<DashboardEmployeesDto> dashboardEmployeesDto=employeeService.newHires();
        return dashboardEmployeesDto;
    }

    @GetMapping("/work-anniversary")
    public List<DashboardEmployeesDto> getWorkAnniversary() {
        List<DashboardEmployeesDto> dashboardEmployeesDto=employeeService.workAnniversary();
        return dashboardEmployeesDto;
    }

    @GetMapping("/birthday-buddies")
    public List<DashboardEmployeesDto> getBirthdayBuddies() {
        List<DashboardEmployeesDto> dashboardEmployeesDto=employeeService.searchBirthdayBuddies();
        return dashboardEmployeesDto;
    }

}
