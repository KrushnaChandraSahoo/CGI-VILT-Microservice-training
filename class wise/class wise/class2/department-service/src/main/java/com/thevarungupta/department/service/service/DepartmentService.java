package com.thevarungupta.department.service.service;

import com.thevarungupta.department.service.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartments();
    Department getDepartmentById(Long departmentId);
    Department saveDepartment(Department newDepartment);

}
