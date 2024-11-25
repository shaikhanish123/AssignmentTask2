package com.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
