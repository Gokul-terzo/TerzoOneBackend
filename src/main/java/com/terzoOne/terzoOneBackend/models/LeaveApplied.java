package com.terzoOne.terzoOneBackend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.util.List;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LeaveApplied {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate leaveDate;
    private String leaveType;
    private String note;
    @ColumnDefault(value = "0")
    private int approved;
    @ManyToOne
    @JsonBackReference
    private Employee employee;
}
