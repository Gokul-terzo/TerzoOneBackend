package com.terzoOne.terzoOneBackend.mapper;

import com.terzoOne.terzoOneBackend.dto.LeaveAppliedDto;
import com.terzoOne.terzoOneBackend.models.LeaveApplied;

public class LeaveAppliedMapper {
    public static LeaveAppliedDto mapToLeaveAppliedDto(LeaveApplied leaveApplied){
        LeaveAppliedDto leaveAppliedDto=LeaveAppliedDto.builder()
                .leaveDate(leaveApplied.getLeaveDate())
                .leaveType(leaveApplied.getLeaveType())
                .id(leaveApplied.getId())
                .note(leaveApplied.getNote())
                .approved(leaveApplied.getApproved())
                .employee(leaveApplied.getEmployee()).build();
        return leaveAppliedDto;
    }
}
