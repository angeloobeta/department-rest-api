package com.example.departmentrestapi.controller;

import com.example.departmentrestapi.entity.Department;
import com.example.departmentrestapi.services.DepartmentService;
import com.example.departmentrestapi.services.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController public class DepartmentController {

    @Autowired
    DepartmentService departmentService;
    @PostMapping("/department")
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveToDepartment(department);
    }

    @GetMapping("/get-department")
    public List<Department> getDepartment(@RequestBody Department department){
        return departmentService.getAllDepartment();
    }


}
