package com.terzoOne.terzoOneBackend.dto;

import com.terzoOne.terzoOneBackend.models.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveAppliedDto {
    private int id;
    private LocalDate leaveDate;
    private String leaveType;
    private String note;
    private int approved;
    private Employee employee;
}
