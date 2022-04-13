package com.trojan.SpringBootTutorial.controller;

import com.trojan.SpringBootTutorial.entity.Department;
import com.trojan.SpringBootTutorial.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getDepartments() {
        return departmentService.getDepartmentList();
    }

    @GetMapping("/departments/getById")
    public Department getDepartmentById(@RequestParam long departmentId) {
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
    public ResponseEntity<Department> updateDepartmentNameById(@RequestBody Department department) {
        departmentService.updateDepartmentById(department);
        Department department1 = departmentService.getDepartmentById(department.getDepartmentId());
        return ResponseEntity.ok().body(department1);
    }

}
