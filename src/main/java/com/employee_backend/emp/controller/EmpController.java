package com.employee_backend.emp.controller;

import com.employee_backend.emp.Entity.Employee;
import com.employee_backend.emp.dto.EmpDto;
import com.employee_backend.emp.repo.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.employee_backend.emp.service.EmpServices;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmpServices empServices;

    @Autowired
    private EmpRepo empRepo;

    @PostMapping("/add")
    public Employee addEmp(@RequestBody EmpDto empDto) {
        return empServices.addEmp(empDto);
    }

    @GetMapping("/get")
    public Employee getEmpById(@RequestParam int id) {
        return empServices.getEmpById(id);
    }
    @GetMapping("/me")
    public ResponseEntity<EmpDto> authenticatedEmployee() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String userEmail = authentication.getName();

        // Find student by email
        Employee employee = empServices.getEmpByEmail(userEmail);

        if (employee == null) {
            return ResponseEntity.status(404).body(null);
        }
        EmpDto empDto = empServices.employeeToEmpDto(employee);
        return ResponseEntity.ok(empDto);
    }

    @GetMapping("/")
    public ResponseEntity<List<Employee>> allEmployees() {
        List <Employee> Employees = empServices.allEmployees();

        return ResponseEntity.ok(Employees);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteEmp(@PathVariable int id) {
         empServices.deleteEmp(id);
    }
}
