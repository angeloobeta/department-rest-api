package com.example.departmentrestapi.services;

import com.example.departmentrestapi.entity.Department;
import com.example.departmentrestapi.error.DepartmentErrorException;
import com.example.departmentrestapi.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
    public Department getDepartmentById(Long departmentId) throws DepartmentErrorException {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if(!department.isPresent())
            throw new DepartmentErrorException("Department not found");

        return department.get();
    }

    /**
     * @param departmentId
     */
    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    /**
     * @param departmentId
     * @return
     */
    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department departmentDB = departmentRepository.findById(departmentId).get();
        if(Objects.nonNull(department.getDepartmentName()) &&
                ! "".equalsIgnoreCase(department.getDepartmentName())){
            departmentDB.setDepartmentName(department.getDepartmentName());}

        if(Objects.nonNull(department.getDepartmentAddress()) &&
                ! "".equalsIgnoreCase(department.getDepartmentAddress())){
            departmentDB.setDepartmentAddress(department.getDepartmentAddress());}

        if(Objects.nonNull(department.getDepartmentCode()) &&
                ! "".equalsIgnoreCase(department.getDepartmentCode())){
            departmentDB.setDepartmentCode(department.getDepartmentCode());}

        return departmentRepository.save(departmentDB);
    }

    /**
     * @param departmentName
     * @return
     */
    @Override
    public Department findByDepartmentName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }

    public Department findByDepartmentNameIgnoreCase(String departmentName){
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }

    /**
     * @return
     */
    @Override
    public String deleteAllDepartment() {
        departmentRepository.deleteAll();
        return "All the data in database have been wide-out successfully";
    }
}
