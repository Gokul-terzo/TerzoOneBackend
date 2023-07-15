package com.terzoOne.terzoOneBackend.controller;

import com.terzoOne.terzoOneBackend.models.Employee;
import com.terzoOne.terzoOneBackend.models.LeaveApplied;
import com.terzoOne.terzoOneBackend.service.EmployeeService;
import com.terzoOne.terzoOneBackend.service.LeavesAppliedService;
import com.terzoOne.terzoOneBackend.service.LeavesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/time-off")
@RequiredArgsConstructor
public class TimeOffController {

    private final LeavesAppliedService leavesAppliedService;
    private final LeavesService leavesService;

    private final EmployeeService employeeService;
    @PostMapping("/apply-leave")
    public void addLeaveApplication(@RequestBody LeaveApplied leaveApplied){
        leavesAppliedService.saveLeave(leaveApplied);
        leavesService.reduceLeave(leaveApplied);
    }

    @GetMapping("/view-applied-leaves")
    public List<LeaveApplied> viewAppliedLeaves(){
        List<LeaveApplied> leavesApplied=leavesAppliedService.getAll();
        return leavesApplied;
    }

    @PostMapping("/approve-leave/{leaveId}")
    public void approveLeave(@PathVariable int leaveId){
        LeaveApplied leaveApplied=leavesAppliedService.getById(leaveId);
        leavesAppliedService.approve(leaveApplied);
    }

    @GetMapping("/my-approved-leave/{empId}")
    public List<LeaveApplied> getApprovedLeave(@PathVariable int empId){
        Employee employee=employeeService.getById(empId);
        List<LeaveApplied> leavesApproved=leavesAppliedService.getByEmpId(employee);
        return leavesApproved;
    }

}
