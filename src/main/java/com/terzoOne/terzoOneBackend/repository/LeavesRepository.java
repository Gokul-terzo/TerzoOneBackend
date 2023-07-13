package com.terzoOne.terzoOneBackend.repository;

import com.terzoOne.terzoOneBackend.models.Leaves;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeavesRepository extends JpaRepository<Leaves,Integer> {
//    Leaves findByEmployee_id(int empId);
}
