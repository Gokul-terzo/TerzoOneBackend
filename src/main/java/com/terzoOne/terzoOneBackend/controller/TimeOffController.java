package com.terzoOne.terzoOneBackend.controller;

import com.terzoOne.terzoOneBackend.models.LeaveApplied;
import com.terzoOne.terzoOneBackend.models.LeavesApproved;
import com.terzoOne.terzoOneBackend.service.LeavesAppliedService;
import com.terzoOne.terzoOneBackend.service.LeavesApprovedService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/time-off")
@RequiredArgsConstructor
public class TimeOffController {

    private final LeavesAppliedService leavesAppliedService;
    private final LeavesApprovedService leavesApprovedService;
    @PostMapping("/apply-leave")
    public void addLeaveApplication(@RequestBody LeaveApplied leaveApplied){
        leavesAppliedService.saveLeave(leaveApplied);
    }

    @GetMapping("/view-applied-leaves")
    public List<LeaveApplied> viewAppliedLeaves(){
        List<LeaveApplied> leavesApplied=leavesAppliedService.getAll();
        return leavesApplied;
    }

    @PostMapping("/approve-leave/{leaveId}")
    public void approveLeave(@PathVariable int leaveId){
        LeaveApplied leaveApplied=leavesAppliedService.getById(leaveId);
        leavesAppliedService.delete(leaveApplied);
        leavesApprovedService.saveEntry(leaveApplied);
    }

    @GetMapping("/my-approved-leave/{empId}")
    public LeavesApproved getApprovedLeave(@PathVariable int empId){
        LeavesApproved leavesApproved=leavesApprovedService.getByEmpId(empId);
        return leavesApproved;
    }

}
