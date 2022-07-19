package com.carrefouritech.aphira.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.carrefouritech.aphira.model.Employee;
import com.carrefouritech.aphira.service.EmployeeService;

@RestController
@RequestMapping(path = "/api/v1/rest", name = "app_Aphira")
public class EmployeeController {

	@Autowired
	public EmployeeService employeeService;
	
	
	@GetMapping(path = "/employees", name ="List")
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Employee> getEmployees()
	{
		//return employeeService.getEmployeByName("kom");
		return employeeService.getEmployees();
	}
	
	@PostMapping(path = "/employees", name = "create")
	@ResponseStatus(HttpStatus.CREATED)
	public Employee addEmployee(@RequestBody Employee employee) 
	{
		return employeeService.saveEmployee(employee);
	}
	
	@GetMapping(path = "/employees/{id}", name = "read")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Employee> getEmployee(@PathVariable Long id)
	{
		return employeeService.getEmploye(id);
	}
	
	@PutMapping(path = "/employees/{id}", name = "update")
	@ResponseStatus(HttpStatus.OK)
	public Employee update(@RequestBody Employee employee, @PathVariable Long id) {
		return employeeService.updateEmployee(employee, id);
	}
	
	@DeleteMapping(path = "/employees/{id}", name = "remove")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable Long id) 
	{
		employeeService.deleteEmployee(id);
	}
	
	
	
}
