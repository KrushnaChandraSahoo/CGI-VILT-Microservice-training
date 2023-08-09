package com.thevarungupta.employee.service.service;

import com.thevarungupta.employee.service.dto.EmployeeDepartment;
import com.thevarungupta.employee.service.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long employeeId);
    Employee saveEmployee(Employee newEmployee);
    EmployeeDepartment getEmployeeWithDepartment(Long employeeId);
}
