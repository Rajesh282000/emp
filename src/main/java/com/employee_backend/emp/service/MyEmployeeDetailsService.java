package com.employee_backend.emp.service;

import com.employee_backend.emp.Entity.Employee;
import com.employee_backend.emp.repo.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyEmployeeDetailsService implements UserDetailsService {
    @Autowired
    private EmpRepo Employee;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee  employee = Employee.findByEmail(username);
        if(employee == null) {
            throw new UsernameNotFoundException("Student not found ");
        }
        return employee;
    }

}
