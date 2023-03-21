package com.example.departmentrestapi.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

    // department id would be the primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long departmentId;
    @NotBlank(message = "departmental name can't be empty")
    private String departmentName;
    private  String departmentAddress;
    private String departmentCode;
}
