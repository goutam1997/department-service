package com.example.departmentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    public List<Department> addDepartments(List<Department> departments) {
        return departmentRepo.saveAll(departments);
    }

    public List<Department> viewDepartments() {
        return departmentRepo.findAll();
    }
}
