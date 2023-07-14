package com.terzoOne.terzoOneBackend.service;

import com.terzoOne.terzoOneBackend.models.LeaveApplied;
import com.terzoOne.terzoOneBackend.models.LeavesApproved;

public interface LeavesApprovedService {
    void saveEntry(LeaveApplied leaveApplied);

    LeavesApproved getByEmpId(int id);
}
