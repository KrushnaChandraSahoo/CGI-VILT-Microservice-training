package com.thevarungupta.employee.service.repoasitory;

import com.thevarungupta.employee.service.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
