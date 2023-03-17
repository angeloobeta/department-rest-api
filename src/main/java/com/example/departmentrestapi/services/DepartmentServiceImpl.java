package com.example.departmentrestapi.services;

import com.example.departmentrestapi.entity.Department;
import com.example.departmentrestapi.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    /**
     * @param department
     * @return
     */
    @Override
    public Department saveToDepartment(Department department) {
        return departmentRepository.save(department);
    }
}
