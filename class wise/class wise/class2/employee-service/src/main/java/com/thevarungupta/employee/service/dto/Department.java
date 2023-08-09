package com.thevarungupta.employee.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

//@Entity - don't add Entity annotation otherwise you end create a department table in emp service
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    private Long departmentId;
    private String departmentName;
    private String departmentAddress;
}
