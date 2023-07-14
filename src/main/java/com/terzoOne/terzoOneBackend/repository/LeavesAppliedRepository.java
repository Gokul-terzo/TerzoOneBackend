package com.terzoOne.terzoOneBackend.repository;

import com.terzoOne.terzoOneBackend.models.LeaveApplied;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeavesAppliedRepository extends JpaRepository<LeaveApplied,Integer> {
    LeaveApplied getLeaveAppliedById(int id);
}
