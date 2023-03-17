package com.example.departmentrestapi.controller;

import com.example.departmentrestapi.entity.Department;
import com.example.departmentrestapi.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController public class DepartmentController {

    @Autowired
    DepartmentService departmentService;
    @PostMapping("/department")
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveToDepartment(department);
    }

    @GetMapping("/get-department")
    public List<Department> getDepartment(){
        return departmentService.getAllDepartment();
    }

    @GetMapping("/get-departmentById/{id}")
    public Optional<Department> getDepartmentById(@PathVariable("id") Long departmentId){
        return departmentService.getDepartmentById(departmentId);
    }


    @DeleteMapping("/delete-departmentById/{id}")
    public String deleteById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully";
    }


}
