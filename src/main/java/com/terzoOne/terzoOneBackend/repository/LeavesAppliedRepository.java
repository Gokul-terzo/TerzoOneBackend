package com.terzoOne.terzoOneBackend.repository;

import com.terzoOne.terzoOneBackend.models.Employee;
import com.terzoOne.terzoOneBackend.models.LeaveApplied;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeavesAppliedRepository extends JpaRepository<LeaveApplied,Integer> {
    LeaveApplied getLeaveAppliedById(int id);
    List<LeaveApplied> getLeaveAppliedByEmployee(Employee employee);
}
