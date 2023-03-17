package com.example.departmentrestapi.services;

import com.example.departmentrestapi.entity.Department;

import java.util.ArrayList;
import java.util.List;

public interface DepartmentService {
    Department saveToDepartment(Department department);

    List<Department> getAllDepartment();
}
