package com.terzoOne.terzoOneBackend.service;

import com.terzoOne.terzoOneBackend.dto.LeaveAppliedDto;
import com.terzoOne.terzoOneBackend.models.Employee;
import com.terzoOne.terzoOneBackend.models.LeaveApplied;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LeavesAppliedService {
void saveLeave(LeaveApplied leaveApplied);

List<LeaveAppliedDto> getAll();

LeaveApplied getById(int id);

void delete(LeaveApplied leaveApplied);

List<LeaveApplied> getByEmpId(Employee employee);

List<LeaveApplied> getApprovedByEmpId(Employee employee);

void approve(LeaveApplied leaveApplied);
}
