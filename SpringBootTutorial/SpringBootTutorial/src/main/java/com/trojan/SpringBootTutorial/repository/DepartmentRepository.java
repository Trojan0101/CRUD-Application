package com.trojan.SpringBootTutorial.repository;

import com.trojan.SpringBootTutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department getByDepartmentName(String departmentName);

}
