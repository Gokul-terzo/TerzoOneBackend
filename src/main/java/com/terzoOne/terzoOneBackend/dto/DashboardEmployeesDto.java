package com.terzoOne.terzoOneBackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DashboardEmployeesDto {
    private int id;
    private String name;
    private String designation;
    private String department;
    private String profileUrl;
    private String email;
    private LocalDate dob;
    private LocalDate doj;
}