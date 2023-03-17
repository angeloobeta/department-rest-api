package com.example.departmentrestapi.controller;

import com.example.departmentrestapi.entity.Department;
import com.example.departmentrestapi.services.DepartmentService;
import com.example.departmentrestapi.services.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController public class DepartmentController {

    @Autowired
    DepartmentService departmentService;
    @PostMapping("/department")
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveToDepartment(department);

    }
}
