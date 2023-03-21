package com.example.departmentrestapi.services;

import com.example.departmentrestapi.entity.Department;
import com.example.departmentrestapi.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    private final Logger LOGGER = LoggerFactory.getLogger(Department.class);

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private  DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department
                .builder()
                .departmentName("Devops Unit")
                .departmentAddress("Top floor by the left")
                .departmentCode("GTA-Build").departmentId(31L)
                .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("Devops Unit"))
                .thenReturn(department);
    }

    @Test
    @DisplayName("Get Data base on Valid Department Name")
    @Disabled
    public void whenValidDepartName_thenDepartmentShowFound(){

        String departmentName1 = "CyberOps";
        String departmentName2 = "Devops Unit";
        LOGGER.info("");
        LOGGER.info("");
        LOGGER.info("");
        Department foundObject1 = departmentService.findByDepartmentName(departmentName1);
        LOGGER.info("\nThis is the value of departmentService at findByDepartmentName ===================>  " + departmentService.findByDepartmentName(departmentName1));
        Department foundObject2 = departmentService.findByDepartmentName(departmentName2);
        assertEquals(departmentName1, foundObject1.getDepartmentName());
        assertEquals(departmentName2, foundObject2.getDepartmentName());
    }
}