package com.trojan.SpringBootTutorial.service;

import com.trojan.SpringBootTutorial.entity.Department;
import com.trojan.SpringBootTutorial.error.DepartmentNotFoundException;
import com.trojan.SpringBootTutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Department getDepartmentById(long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if (department.isPresent()) {
            return department.get();
        } else {
            throw new DepartmentNotFoundException("Department not found!");
        }
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
