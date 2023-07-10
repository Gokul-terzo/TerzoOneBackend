package com.terzoOne.terzoOneBackend.repository;

import com.terzoOne.terzoOneBackend.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
