package com.trojan.SpringBootTutorial.service;

import com.trojan.SpringBootTutorial.entity.Department;
import com.trojan.SpringBootTutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }

    @Override
    public Department getDepartmentByName(String departmentName) {
        return departmentRepository.getByDepartmentName(departmentName);
    }

    @Override
    public void deleteDepartmentById(long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public void updateDepartmentById(Department department) {
        Department dbDepartment = departmentRepository.findById(department.getDepartmentId()).get();
        dbDepartment.setDepartmentName(department.getDepartmentName());
        dbDepartment.setDepartmentAddress(department.getDepartmentAddress());
        dbDepartment.setDepartmentCode(department.getDepartmentCode());
        departmentRepository.save(dbDepartment);
    }
}
