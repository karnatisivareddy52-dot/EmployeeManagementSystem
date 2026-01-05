package com.example.demo.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.services.EmployeeService;



@RestController
@RequestMapping("/api/employees")
public class EmployeeController 
{
	 @Autowired
	  private EmployeeService service;
	
	 
	 @GetMapping
	    public List<Employee> getAll()
	 {
	    return service.getAllEmployees();
	  } 

	  @PostMapping
	    public Employee create(@RequestBody Employee employee)
	  {
		  System.out.println(employee);
	        return service.saveEmployee(employee);
	  }
	  
	  @PutMapping("/{id}")
	    public Employee update(@PathVariable Long id, @RequestBody Employee employee)
	  {
	        return service.updateEmployee(id, employee);
	  }
	  
	  @DeleteMapping("/{id}")
	    public void delete(@PathVariable Long id)
	  {
	        service.deleteEmployee(id);
	   }
	  
}
