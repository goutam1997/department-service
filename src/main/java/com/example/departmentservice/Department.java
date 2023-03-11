package com.example.departmentservice;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DEPARTMENT")
public class Department {
    @Id
    @GeneratedValue
    @JsonIgnore
    private int id;
    @JsonProperty("name")
    private String applicantName;
    private String departmentName;
}
