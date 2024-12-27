package com.employee_backend.emp.dto;

public class RegisterDto {

        private String email;

        private String password;

        private String fullName;

        private String dept;

        public RegisterDto(String email, String password, String fullName, String dept) {
                this.email = email;
                this.password = password;
                this.fullName = fullName;
                this.dept = dept;
        }

        public RegisterDto() {

        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getFullName() {
                return fullName;
        }

        public void setFullName(String fullName) {
                this.fullName = fullName;
        }

        public String getDept() {
                return dept;
        }

        public void setDept(String dept) {
                this.dept = dept;
        }
}
