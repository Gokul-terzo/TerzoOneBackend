package com.terzoOne.terzoOneBackend.service;

import com.terzoOne.terzoOneBackend.models.Employee;
import com.terzoOne.terzoOneBackend.models.LeaveApplied;
import com.terzoOne.terzoOneBackend.models.Leaves;

import java.util.List;

public interface LeavesService {

    void reduceLeave(LeaveApplied leaveApplied);
    void saveLeaves(Leaves leaves);

    Leaves getByEmpId(int id);
}
