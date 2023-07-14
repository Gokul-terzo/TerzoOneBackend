package com.terzoOne.terzoOneBackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LeaveApplied {
    @Id
    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String leaveType;

    @ManyToOne
    private Employee employee;
}
