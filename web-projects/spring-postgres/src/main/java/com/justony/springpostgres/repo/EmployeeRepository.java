package com.justony.springpostgres.repo;

import com.justony.springpostgres.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee getEmployeeByNameAndPosition(String name, String position);
}
