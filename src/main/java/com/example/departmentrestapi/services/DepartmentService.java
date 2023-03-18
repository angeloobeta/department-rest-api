package com.example.departmentrestapi.services;

import com.example.departmentrestapi.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    Department saveToDepartment(Department department);

    List<Department> getAllDepartment();

    Optional<Department> getDepartmentById(Long departmentId);

    void deleteDepartmentById(Long departmentId);

    Department updateDepartment(Long departmentId, Department department);

    Department findByDepartmentName(String departmentName);
}
