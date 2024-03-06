package com.excelr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.entity.Employee;
import com.excelr.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	
	@Override
	public Employee addEmployee(Employee employee) {
		
	    Employee employee2=employeeRepository.save(employee);
		return employee2;
	}

	
	@Override
	public List<Employee> getAllEmployees() {
		 
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {
	   Optional<Employee> optionalEmployee = employeeRepository.findById(id);
	  Employee employee=null;
	  
	  if(optionalEmployee.isPresent())
	   {
		   employee= optionalEmployee.get();
	   }
		
		return employee;
	}

	@Override
	public String deleteEmployee(int id) {
		String msg="";
		   if(employeeRepository.existsById(id))
		   {
			   employeeRepository.deleteById(id);
			   msg="product deleted";
		   }
		   else
			   msg="no id found to delete";
		
		return msg;
	}

	
	@Override
	public String updateEmployee(int id, Employee employee) {
		String msg="";
		   if(employeeRepository.existsById(id))
		   {
			    Employee employee2 = employeeRepository.findById(id).get();
			    employee2.setName(employee.getName());
			    employee2.setDepartment(employee.getDepartment());
			    employee2.setContact(employee.getContact());
			    employee2.setProject(employee.getProject());
			    employee2.setReporting(employee.getReporting());
			    
			    employeeRepository.save(employee2);
			    msg="product successfull updated";
			    
		   }
		   else
			   msg="no id found to update";
		return msg;
	}

	

}
