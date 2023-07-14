package com.terzoOne.terzoOneBackend.service;

import com.terzoOne.terzoOneBackend.models.LeaveApplied;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LeavesAppliedService {
void saveLeave(LeaveApplied leaveApplied);

List<LeaveApplied> getAll();

LeaveApplied getById(int id);

void delete(LeaveApplied leaveApplied);
}
