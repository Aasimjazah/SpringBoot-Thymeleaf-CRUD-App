package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Employee;


public interface EmployeeRepo extends CrudRepository<Employee, Integer>  {

	
	public Employee  findById(int id);
	public Employee  findByName(String name);
}
