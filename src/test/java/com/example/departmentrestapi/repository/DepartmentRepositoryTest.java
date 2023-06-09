package com.example.departmentrestapi.repository;

import com.example.departmentrestapi.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("Quality TestUnit")
                .departmentAddress("IYT-4827")
                .departmentCode("891")
                .build();

        testEntityManager.persist(department);
    }

    @Test
    public  void whenFindById_thenReturnDepartment(){
        Department department = departmentRepository.findByDepartmentName("Quality TestUnit");
        assertEquals(department.getDepartmentName(), "Quality TestUnit");
    }
}