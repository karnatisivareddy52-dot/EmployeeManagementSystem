package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeRepository;

@Service
public class EmployeeService
{
	 @Autowired
	 private EmployeeRepository repository;
	 
	 public List<Employee> getAllEmployees()
	 {
	        return repository.findAll();
	  }
	 
	 public Employee saveEmployee(Employee employee)
	 {
	        return repository.save(employee);
	 }
	 
	 
	 public Employee updateEmployee(Long id, Employee employee) 
	 {
	        Employee existing = repository.findById(id).orElseThrow();
	        existing.setFirstName(employee.getFirstName());
	        existing.setLastName(employee.getLastName());
	        existing.setEmail(employee.getEmail());
	        return repository.save(existing);
	  }
	 
	 
	 public void deleteEmployee(Long id)
	 {
	        repository.deleteById(id);
	  }
}
