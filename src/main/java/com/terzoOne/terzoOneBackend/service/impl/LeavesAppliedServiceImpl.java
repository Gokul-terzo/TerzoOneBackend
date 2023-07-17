package com.terzoOne.terzoOneBackend.service.impl;

import com.terzoOne.terzoOneBackend.dto.LeaveAppliedDto;
import com.terzoOne.terzoOneBackend.models.Employee;
import com.terzoOne.terzoOneBackend.models.LeaveApplied;
import com.terzoOne.terzoOneBackend.repository.LeavesAppliedRepository;
import com.terzoOne.terzoOneBackend.service.LeavesAppliedService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.terzoOne.terzoOneBackend.mapper.LeaveAppliedMapper.mapToLeaveAppliedDto;

@Service
@RequiredArgsConstructor
public class LeavesAppliedServiceImpl  implements LeavesAppliedService {

    private final LeavesAppliedRepository leavesAppliedRepository;
    @Override
    public void saveLeave(LeaveApplied leaveApplied) {
        leavesAppliedRepository.save(leaveApplied);
    }

    @Override
    public List<LeaveAppliedDto> getAll() {
        List<LeaveApplied> leaveApplied=leavesAppliedRepository.findAll();
        List<LeaveAppliedDto> leaveAppliedDto=leaveApplied.stream().map(e->mapToLeaveAppliedDto(e)).collect(Collectors.toList());
        leaveAppliedDto=leaveAppliedDto.stream().filter(e->e.getApproved()==0).collect(Collectors.toList());
        return leaveAppliedDto;
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
        leaveApplied=leaveApplied.stream().filter(e->e.getLeaveDate().isAfter(LocalDate.now())).collect(Collectors.toList());
        return leaveApplied;
    }

    @Override
    public void approve(LeaveApplied leaveApplied) {
        leaveApplied.setApproved(1);
        leavesAppliedRepository.save(leaveApplied);
    }
}
