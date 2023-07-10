package com.terzoOne.terzoOneBackend.repository;

import com.terzoOne.terzoOneBackend.models.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthoritiesRepository extends JpaRepository<Authorities,String> {
}
