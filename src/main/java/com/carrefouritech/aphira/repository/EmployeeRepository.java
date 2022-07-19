package com.carrefouritech.aphira.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carrefouritech.aphira.model.Employee;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> 
{
	
	@Query("select lastName, mail from Employee e where e.firstName=?1")
	public Iterable<Employee> getEmployebynom(String nom);
}
