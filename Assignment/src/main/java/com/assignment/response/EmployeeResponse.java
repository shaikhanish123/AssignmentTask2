package com.assignment.response;

public class EmployeeResponse {

    private String name;
    private String email;
    private String departmentName;
    private String roleName;

    public EmployeeResponse(String name, String email, String departmentName, String roleName) {
        this.name = name;
        this.email = email;
        this.departmentName = departmentName;
        this.roleName = roleName;
    }

    
    public String getName() {
		return name;
	}
    public void setName(String name) {
		this.name = name;
	}
    
    public String getEmail() {
		return email;
	}
    public void setEmail(String email) {
		this.email = email;
	}
    
    public String getDepartmentName() {
		return departmentName;
	}
    public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
    
    public String getRoleName() {
		return roleName;
	}
    public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
