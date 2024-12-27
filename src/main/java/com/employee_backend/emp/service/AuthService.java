package com.employee_backend.emp.service;

import com.employee_backend.emp.Entity.Employee;
import com.employee_backend.emp.dto.EmpDto;
import com.employee_backend.emp.dto.LoginDto;
import com.employee_backend.emp.dto.RegisterDto;
import com.employee_backend.emp.repo.EmpRepo;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final EmpRepo empRepo;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthService(
            EmpRepo empRepo,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.empRepo = empRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public EmpDto signup(RegisterDto input) {
        String[] fullName = input.getFullName().split(" ");
        Employee employee = new Employee();
        employee.setFirstName(fullName[0]);
        employee.setLastName(fullName[1]);
        employee.setDept(input.getDept());
        employee.setEmail(input.getEmail());
        employee.setPassword(passwordEncoder.encode(input.getPassword()));
        empRepo.save(employee);

        EmpDto empDto = new EmpDto();
        empDto.setFirstName(employee.getFirstName());
        empDto.setLastName(employee.getLastName());
        empDto.setEmail(employee.getEmail());
        empDto.setDept(employee.getDept());
        return empDto;
    }

    public Employee authenticate(LoginDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return empRepo.findByEmail(input.getEmail());
    }

}
