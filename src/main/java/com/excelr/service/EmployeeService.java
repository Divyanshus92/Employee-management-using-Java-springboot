package com.excelr.service;

import java.util.List;

import com.excelr.entity.Employee;

public interface EmployeeService {
	
	Employee addEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(int id);
	String deleteEmployee(int id);
	String updateEmployee(int id, Employee employee);

}
