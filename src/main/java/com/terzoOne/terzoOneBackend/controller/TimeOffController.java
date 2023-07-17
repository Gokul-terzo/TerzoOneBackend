package com.terzoOne.terzoOneBackend.controller;

import com.terzoOne.terzoOneBackend.dto.LeaveAppliedDto;
import com.terzoOne.terzoOneBackend.models.Employee;
import com.terzoOne.terzoOneBackend.models.LeaveApplied;
import com.terzoOne.terzoOneBackend.models.Leaves;
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
    }

    @GetMapping("/leave-balance/{empId}")
    public Leaves getEmployeeLeave(@PathVariable int empId){
        Leaves leaves=leavesService.getByEmpId(empId);
        return leaves;
    }


    @GetMapping("/admin/view-applied-leaves")
    public List<LeaveAppliedDto> viewAppliedLeaves(){
        List<LeaveAppliedDto> leavesApplied=leavesAppliedService.getAll();
        return leavesApplied;
    }

    @GetMapping("/admin/approve-leave/{leaveId}")
    public void approveLeave(@PathVariable int leaveId){
        LeaveApplied leaveApplied=leavesAppliedService.getById(leaveId);
        leavesService.reduceLeave(leaveApplied);
        leavesAppliedService.approve(leaveApplied);
    }

    @GetMapping("/my-applied-leave/{empId}")
    public List<LeaveApplied> getApprovedLeave(@PathVariable int empId){
        Employee employee=employeeService.getById(empId);
        List<LeaveApplied> leavesApproved=leavesAppliedService.getApprovedByEmpId(employee);
        return leavesApproved;
    }

}
