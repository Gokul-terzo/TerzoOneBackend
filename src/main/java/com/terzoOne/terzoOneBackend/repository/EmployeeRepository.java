package com.terzoOne.terzoOneBackend.repository;

import com.terzoOne.terzoOneBackend.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query("SELECT e from Employee e WHERE e.name LIKE CONCAT('%', :query, '%')")
    List<Employee> searchEmployees(String query);

    Employee getEmployeeByEmail(String email);
}
