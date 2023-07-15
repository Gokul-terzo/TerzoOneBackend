package com.terzoOne.terzoOneBackend.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    private String name;
    private String department;
    private String designation;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private long mobile;
    private String workLocation;
    private String employeeType;
    private String status;
    private LocalDate dob;
    private LocalDate doj;
    private String team;
    @ColumnDefault("'https://allworldpm.com/wp-content/uploads/2016/10/230x230-avatar-dummy-profile-pic.jpg'")
    private String profileUrl;


    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<LeaveApplied> leavesApplied;

}
