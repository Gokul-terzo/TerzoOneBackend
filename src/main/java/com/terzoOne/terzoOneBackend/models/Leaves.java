package com.terzoOne.terzoOneBackend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
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

    @JoinColumn(referencedColumnName = "id")
    private int employee_id;

}
