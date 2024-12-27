package com.employee_backend.emp.controller;

import com.employee_backend.emp.Entity.Employee;
import com.employee_backend.emp.dto.EmpDto;
import com.employee_backend.emp.dto.LoginDto;
import com.employee_backend.emp.dto.RegisterDto;
import com.employee_backend.emp.response.LoginResponse;
import com.employee_backend.emp.service.AuthService;
import com.employee_backend.emp.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtService jwtService;

    private final AuthService authService;

    public AuthController(JwtService jwtService, AuthService authService) {
        this.jwtService = jwtService;
        this.authService = authService;
    }


    @PostMapping("/signup")
    public ResponseEntity<EmpDto> register(@RequestBody RegisterDto registerDto) {
        EmpDto registeredEmployee = authService.signup(registerDto);

        return ResponseEntity.ok(registeredEmployee);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginDto loginDto) {
        Employee authenticatedEmployee = authService.authenticate(loginDto);

        String jwtToken = jwtService.generateToken(authenticatedEmployee);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}
