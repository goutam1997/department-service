package com.example.departmentservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
@RestController
@Slf4j
@RequestMapping("/department-service")
public class DepartmentServiceApplication {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/add-all")
    public List<Department> addDepartments(@RequestBody List<Department> departments) throws JsonProcessingException {
        log.info("Departments received at {} are : {}", new Date(), new ObjectMapper().writeValueAsString(departments));
        log.info("Adding departments: {}", departments);
        return departmentService.addDepartments(departments);
    }

    @GetMapping("/view-all")
    public List<Department> viewDepartments() {
        log.info("Get departments info by {} at time {}",Thread.currentThread().getName(), new Date());
        return departmentService.viewDepartments();
    }

    public static void main(String[] args) {
        SpringApplication.run(DepartmentServiceApplication.class, args);
    }

}
