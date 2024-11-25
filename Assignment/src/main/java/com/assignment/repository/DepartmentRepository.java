package com.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	
}
