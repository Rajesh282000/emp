package com.employee_backend.emp.repo;

import com.employee_backend.emp.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer> {
    public Employee findByEmail(String email);
}
