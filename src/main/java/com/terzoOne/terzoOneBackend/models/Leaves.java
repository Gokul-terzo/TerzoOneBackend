package com.terzoOne.terzoOneBackend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Leaves {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private int earnedLeave;
    private int medicalLeave;
    private int paternityLeave;

    @OneToOne
    private Employee employee;
}
