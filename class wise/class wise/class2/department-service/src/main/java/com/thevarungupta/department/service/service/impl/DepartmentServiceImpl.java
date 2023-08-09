package com.thevarungupta.department.service.service.impl;

import com.thevarungupta.department.service.entity.Department;
import com.thevarungupta.department.service.repository.DepartmentRepository;
import com.thevarungupta.department.service.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
    @Override
    public Department getDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }
    @Override
    public Department saveDepartment(Department newDepartment) {
        return departmentRepository.save(newDepartment);
    }
}
