package com.terzoOne.terzoOneBackend.repository;

import com.terzoOne.terzoOneBackend.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,String> {
    Users findByEmail(String email);
}
