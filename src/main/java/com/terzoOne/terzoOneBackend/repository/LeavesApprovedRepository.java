package com.terzoOne.terzoOneBackend.repository;

import com.terzoOne.terzoOneBackend.models.LeaveApplied;
import com.terzoOne.terzoOneBackend.models.LeavesApproved;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeavesApprovedRepository extends JpaRepository<LeavesApproved,Integer> {

    LeavesApproved getLeavesApprovedByEmployee_Id(int id);
}
