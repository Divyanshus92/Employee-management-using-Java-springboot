package com.excelr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.entity.Employee;
import com.excelr.service.EmployeeService;
@CrossOrigin
@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/employee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
	{
		return new ResponseEntity<Employee>(employeeService.addEmployee(employee), HttpStatus.OK);
		
	}
	
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getAllEmployees()
	{
		return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(), HttpStatus.OK);
	}
	
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id)
	{
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id)
	{
		return new ResponseEntity<String>(employeeService.deleteEmployee(id), HttpStatus.OK);
	}
	 
	@PutMapping("/employee/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestBody Employee employee)
	{
		return new ResponseEntity<String>(employeeService.updateEmployee(id, employee), HttpStatus.OK);
	}
	
	
	
	
}
