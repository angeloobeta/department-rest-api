package com.example.departmentrestapi.controller;

import com.example.departmentrestapi.entity.Department;
import com.example.departmentrestapi.error.DepartmentErrorException;
import com.example.departmentrestapi.services.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(Department.class);
    @PostMapping("/department")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside SaveDepartment Controller");
        return departmentService.saveToDepartment(department);
    }

    @GetMapping("/get-AllDepartment")
    public List<Department> getDepartment(){
        LOGGER.info("Inside getDepartment Controller");
        return departmentService.getAllDepartment();
    }

    @GetMapping("/get-departmentById/{id}")
    public Department findDepartmentById(@PathVariable("id") Long departmentId) {
        LOGGER.info("Inside findDepartmentById Controller");
        return departmentService.getDepartmentById(departmentId);
    }

    @GetMapping("/get-departmentByName/{departmentName}")
    public Department findDepartmentByName(@PathVariable("departmentName") String departmentName){
        return departmentService.findByDepartmentName(departmentName);
    }


    @DeleteMapping("/delete-departmentById/{id}")
    public String deleteById(@PathVariable("id") Long departmentId) throws DepartmentErrorException{
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully";
    }

    @PutMapping("/update-department/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){
        return departmentService.updateDepartment(departmentId, department);
    }

    @DeleteMapping("/delete-departmentByAll")
    public String deleteById() throws DepartmentErrorException{
        String deleteMessage = departmentService.deleteAllDepartment();
        return deleteMessage;
    }

}
