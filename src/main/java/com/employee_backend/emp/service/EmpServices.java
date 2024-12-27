package com.employee_backend.emp.service;

import com.employee_backend.emp.Entity.Employee;
import com.employee_backend.emp.dto.EmpDto;
import com.employee_backend.emp.repo.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class EmpServices {
    @Autowired
    private EmpRepo empRepo;


    public Employee addEmp(EmpDto empDto){
        Employee emp = new Employee();
        emp.setFirstName(empDto.getFirstName());
        emp.setLastName(empDto.getLastName());
        emp.setEmail(empDto.getEmail());
        emp.setPassword(empDto.getPassword());
        emp.setDept(empDto.getDept());

        return empRepo.save(emp);
    }
    public Employee getEmpById(int id) {
        return empRepo.findById(id).get();
    }

    public void deleteEmp(int id) {
        empRepo.deleteById(id);
    }

    public List<Employee> allEmployees() {
        List<Employee> employees = new java.util.ArrayList<>();
         empRepo.findAll().forEach(employees::add);
        return employees;
    }

    public Employee getEmpByEmail(String email) {
        return empRepo.findByEmail(email);
    }

    public EmpDto employeeToEmpDto(Employee employee) {
        EmpDto empDto = new EmpDto();
        empDto.setFirstName(employee.getFirstName());
        empDto.setLastName(employee.getLastName());
        empDto.setEmail(employee.getEmail());
        empDto.setPassword(employee.getPassword());
        empDto.setDept(employee.getDept());
        return empDto;
    }
}
