package com.terzoOne.terzoOneBackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeCardDto {
    private int id;
    private String name;
    private String designation;
    private String department;
    private String profileUrl;
}
