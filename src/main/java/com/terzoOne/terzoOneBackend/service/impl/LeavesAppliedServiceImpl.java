package com.terzoOne.terzoOneBackend.service.impl;

import com.terzoOne.terzoOneBackend.models.Employee;
import com.terzoOne.terzoOneBackend.models.LeaveApplied;
import com.terzoOne.terzoOneBackend.repository.LeavesAppliedRepository;
import com.terzoOne.terzoOneBackend.service.LeavesAppliedService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LeavesAppliedServiceImpl  implements LeavesAppliedService {

    private final LeavesAppliedRepository leavesAppliedRepository;
    @Override
    public void saveLeave(LeaveApplied leaveApplied) {
        leavesAppliedRepository.save(leaveApplied);
    }

    @Override
    public List<LeaveApplied> getAll() {
        List<LeaveApplied> leaveApplied=leavesAppliedRepository.findAll();
        return leaveApplied;
    }

    @Override
    public LeaveApplied getById(int id) {
        LeaveApplied leaveApplied=leavesAppliedRepository.getLeaveAppliedById(id);
        return leaveApplied;
    }

    @Override
    public void delete(LeaveApplied leaveApplied) {
        leavesAppliedRepository.delete(leaveApplied);
    }

    @Override
    public List<LeaveApplied> getByEmpId(Employee employee) {
        List<LeaveApplied> leaveApplied=leavesAppliedRepository.getLeaveAppliedByEmployee(employee);
        return leaveApplied;
    }

    @Override
    public List<LeaveApplied> getApprovedByEmpId(Employee employee) {
        List<LeaveApplied> leaveApplied=leavesAppliedRepository.getLeaveAppliedByEmployee(employee);
        leaveApplied=leaveApplied.stream().filter(e->e.getApproved()==1).collect(Collectors.toList());
        return leaveApplied;
    }

    @Override
    public void approve(LeaveApplied leaveApplied) {
        leaveApplied.setApproved(1);
        leavesAppliedRepository.save(leaveApplied);
    }
}
