package com.example.departmentrestapi.controller;

import com.example.departmentrestapi.entity.Department;
import com.example.departmentrestapi.services.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockmvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentCode("XC23")
                .departmentName("Marketing Unit")
                .departmentAddress("78vywt")
                .departmentId(3L).build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                .departmentCode("XC23")
                .departmentName("Marketing Unit")
                .departmentAddress("78vywt").build();

        Mockito.when(departmentService.saveToDepartment(inputDepartment)).thenReturn(department);

        mockmvc.perform(post("/department")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                "\t\"departmentName\":\"CyberOps Team\", \n" +
                "\t \"departmentAddress\": \"CY- 395\", \n" +
                "\t \"departmentCode\":\"Code 3Y85\" \n" +
                        "}")).andExpect(status().isOk());
    }

    @Test
    void findDepartmentByName() throws Exception{
        String departmentName = "CyberOps";

        Mockito.when(departmentService.findByDepartmentName(departmentName)).thenReturn(department);

        mockmvc.perform(get("/departname/"+"CyberOps")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

//                .andExpect(jsonPath("$.departmentName")
//                        .value(department.getDepartmentName()));
    }

    @Test
    void deleteById() throws Exception {
        String departmentId = "20403";
        mockmvc.perform(delete("/delete-departmentById/20403")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}