package com.terzoOne.terzoOneBackend.service.impl;

import com.terzoOne.terzoOneBackend.models.LeaveApplied;
import com.terzoOne.terzoOneBackend.models.LeavesApproved;
import com.terzoOne.terzoOneBackend.repository.LeavesApprovedRepository;
import com.terzoOne.terzoOneBackend.service.LeavesApprovedService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LeavesApprovedServiceImpl implements LeavesApprovedService {

    private final LeavesApprovedRepository leavesApprovedRepository;
    @Override
    public void saveEntry(LeaveApplied leaveApplied) {
        LeavesApproved leavesApproved=new LeavesApproved();
        leavesApproved.setLeaveDate(leaveApplied.getLeaveDate());
        leavesApproved.setLeaveType(leaveApplied.getLeaveType());
        leavesApprovedRepository.save(leavesApproved);
    }

    @Override
    public LeavesApproved getByEmpId(int id) {
        LeavesApproved leavesApproved=leavesApprovedRepository.getLeavesApprovedByEmployee_Id(id);
        return leavesApproved;
    }
}
