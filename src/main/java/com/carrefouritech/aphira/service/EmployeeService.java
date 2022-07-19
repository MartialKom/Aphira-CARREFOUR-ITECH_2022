package com.carrefouritech.aphira.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrefouritech.aphira.exceptions.EmployeeNotFoundException;
import com.carrefouritech.aphira.model.Employee;
import com.carrefouritech.aphira.repository.EmployeeRepository;

import lombok.Data;

@Data
@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Optional<Employee> getEmploye(final Long id)
	{
		return employeeRepository.findById(id);
	}
	
	
	public Iterable<Employee> getEmployeByName(String nom)
	{
		return employeeRepository.getEmployebynom(nom);
	}
	
	
	public Iterable<Employee> getEmployees()
	{
		return employeeRepository.findAll();
	}
	
	public void deleteEmployee(final Long id) 
	{
		
		Optional<Employee> employeExist =  employeeRepository.findById(id);
		
		if(!employeExist.isPresent()) 
		{
			throw new EmployeeNotFoundException(String.format("L'employe avec id %s n'a pas été trouvé"+id));
		}
		
		employeeRepository.deleteById(id);
		
	}
	
	public Employee saveEmployee(Employee e) 
	{
		Employee savedEmployee = employeeRepository.save(e);
		return savedEmployee;
	}
	
	public Employee updateEmployee(Employee e, Long id)
	{
		
		Optional<Employee> employeExist =  employeeRepository.findById(id);
		
		if(!employeExist.isPresent()) 
		{
			throw new EmployeeNotFoundException(String.format("L'employe avec id %s n'a pas été trouvé"+id));
		}
		
		return employeeRepository.save(e);
		
	}

}
