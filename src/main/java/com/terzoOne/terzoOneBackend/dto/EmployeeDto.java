package com.terzoOne.terzoOneBackend.dto;

import com.terzoOne.terzoOneBackend.models.Leaves;
import com.terzoOne.terzoOneBackend.models.Teams;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDto {
    private int id;
    private String name;
    private String department;
    private String designation;
    private String email;
    private long mobile;
    private String workLocation;
    private String employeeType;
    private String status;
    private LocalDate dob;
    private LocalDate doj;
    private String team;
    private String profileUrl;
}
