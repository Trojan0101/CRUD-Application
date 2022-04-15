package com.trojan.SpringBootTutorial.service;

import com.trojan.SpringBootTutorial.entity.Department;
import com.trojan.SpringBootTutorial.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> getDepartmentList();

    public Department getDepartmentById(long departmentId) throws DepartmentNotFoundException;

    public Department getDepartmentByName(String departmentName);

    public void deleteDepartmentById(long departmentId);

    public void updateDepartmentById(Department department);
}
