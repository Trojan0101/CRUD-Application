package com.trojan.SpringBootTutorial.controller;

import com.trojan.SpringBootTutorial.entity.Department;
import com.trojan.SpringBootTutorial.error.DepartmentNotFoundException;
import com.trojan.SpringBootTutorial.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getDepartments() {
        LOGGER.info("Inside getDepartments of DepartmentController");
        return departmentService.getDepartmentList();
    }

    @GetMapping("/departments/getById")
    public Department getDepartmentById(@RequestParam long departmentId) throws DepartmentNotFoundException {
        return departmentService.getDepartmentById(departmentId);
    }

    @GetMapping("/departments/getByName")
    public Department getDepartmentByName(@RequestParam String departmentName) {
        return departmentService.getDepartmentByName(departmentName);
    }

    @DeleteMapping("/deleteDepartment")
    public ResponseEntity<?> deleteDepartmentById(@RequestParam long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
        return ResponseEntity.ok("Successfully deleted!");
    }

    @PostMapping("/updateDepartment")
    public ResponseEntity<Department> updateDepartmentNameById(@RequestBody Department department) throws DepartmentNotFoundException {
        departmentService.updateDepartmentById(department);
        Department department1 = departmentService.getDepartmentById(department.getDepartmentId());
        return ResponseEntity.ok().body(department1);
    }

}
