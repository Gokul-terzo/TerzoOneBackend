package com.terzoOne.terzoOneBackend.repository;

import com.terzoOne.terzoOneBackend.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query("SELECT e from Employee e WHERE e.name LIKE CONCAT('%', :query, '%')")
    List<Employee> searchEmployees(String query);

    @Query("SELECT e FROM Employee e WHERE MONTH(e.dob) = MONTH(:date) AND ((DAY(e.dob) - DAY(:date) < 7) OR (DAY(e.dob) = DAY(:date)))")
    List<Employee> findBirthdayBuddies(LocalDate date);
    @Query("SELECT e FROM Employee e WHERE MONTH(e.doj) = MONTH(:date) AND DAY(e.doj) = DAY(:date)")
    List<Employee> findAnniversary( LocalDate date);
    @Query("SELECT e FROM Employee e WHERE (YEAR(e.doj)=YEAR(:date)  AND DAY(e.doj)-DAY(:date) <=30)"  )
    List<Employee> findNewHires(LocalDate date);
    Employee getEmployeeByEmail(String email);
}
