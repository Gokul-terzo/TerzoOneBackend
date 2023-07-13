package com.terzoOne.terzoOneBackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeavesApplied {
    @Id
    private int id;
    private LocalDate date;
    private String reason;
    private String note;
//    @ManyToMany(mappedBy = "leavesApplied")
//    private List<Employee> employees;
}
