
package com.assignment.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.dto.EmployeeDTO;
import com.assignment.entity.Department;
import com.assignment.entity.Employee;
import com.assignment.entity.Role;
import com.assignment.repository.DepartmentRepository;
import com.assignment.repository.EmployeeRepository;
import com.assignment.repository.RoleRepository;
import com.assignment.response.EmployeeResponse;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private RoleRepository roleRepository;

	// Task 1: Create Employee
	@PostMapping
	public ResponseEntity<String> createEmployee(@RequestBody EmployeeDTO  request) {
		Optional<Department> department = departmentRepository.findById(request.getDepartmentId());
		Optional<Role> role = roleRepository.findById(request.getRoleId());

		if (!department.isPresent() || !role.isPresent()) {
			return ResponseEntity.badRequest().body("Invalid Department or Role ID");
		}

		Employee employee = new Employee();
		employee.setName(request.getName());
		employee.setEmail(request.getEmail());
		employee.setDepartment(department.get());
		employee.setRole(role.get());

		employeeRepository.save(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body("Employee Added");
	}

	// Task 2: Get Employee Details
	@GetMapping("/{id}")
	public ResponseEntity<?> getEmployeeDetails(@PathVariable Integer id) {
		Optional<Employee> employee = employeeRepository.findById(id);

		if (!employee.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee Not Found");
		}

		EmployeeResponse response = new EmployeeResponse(employee.get().getName(), employee.get().getEmail(),
				employee.get().getDepartment().getName(), employee.get().getRole().getName());

		return ResponseEntity.ok(response);
	}
}
