package com.terzoOne.terzoOneBackend.repository;

import com.terzoOne.terzoOneBackend.models.Employee;
import com.terzoOne.terzoOneBackend.models.Leaves;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeavesRepository extends JpaRepository<Leaves,Integer> {
}
