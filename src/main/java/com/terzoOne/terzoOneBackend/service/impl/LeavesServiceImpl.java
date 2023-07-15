package com.terzoOne.terzoOneBackend.service.impl;

import com.terzoOne.terzoOneBackend.models.Employee;
import com.terzoOne.terzoOneBackend.models.LeaveApplied;
import com.terzoOne.terzoOneBackend.models.Leaves;
import com.terzoOne.terzoOneBackend.repository.LeavesRepository;
import com.terzoOne.terzoOneBackend.service.LeavesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LeavesServiceImpl implements LeavesService {
    private final LeavesRepository leavesRepository;


    @Override
    public void reduceLeave(LeaveApplied leaveApplied) {
        Employee employee=leaveApplied.getEmployee();
        Leaves leaves=leavesRepository.getLeavesByEmployee_Id(employee.getId());
        String type=leaveApplied.getLeaveType();
        if(type.equals("Sick"))
        leaves.setMedicalLeave(leaves.getMedicalLeave()-1);
        else if(type.equals("Earned"))
            leaves.setEarnedLeave(leaves.getEarnedLeave()-1);
        else
            leaves.setPaternityLeave(leaves.getPaternityLeave()-1);
        leavesRepository.save(leaves);
    }

    @Override
    public void saveLeaves(Leaves leaves) {
        leavesRepository.save(leaves);
    }

    @Override
    public Leaves getByEmpId(int id) {
        Leaves leaves=leavesRepository.getLeavesByEmployee_Id(id);
        return leaves;
    }
}
