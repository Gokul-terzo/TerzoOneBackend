package com.terzoOne.terzoOneBackend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Authorities {
    @Id
    private String email;
    private String role;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email")
    private Users users;
}
