package com.thevarungupta.employee.service.dto;

import com.thevarungupta.employee.service.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDepartment {
    private Employee employee;
    private Department department;
}
