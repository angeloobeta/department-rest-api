package com.example.departmentrestapi.services;

import com.example.departmentrestapi.entity.Department;
import com.example.departmentrestapi.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    /**
     * @return All department
     */
    @Override
    public  List<Department> getAllDepartment() {
        return  departmentRepository.findAll();
    }

    /**
     * @return
     */
    public Optional<Department> getDepartmentById(Long departmentId) {
        return Optional.of(departmentRepository.findById(departmentId).get());
    }

    /**
     * @param departmentId
     */
    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }
}
