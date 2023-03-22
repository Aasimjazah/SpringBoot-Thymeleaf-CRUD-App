package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepo;

@Controller
public class IndexController {
	
	@Autowired
	private EmployeeRepo repo;
	
	@GetMapping("/")
	public String index(Model model)
	{
		Employee emp = new Employee();
		model.addAttribute("employee",emp);
		return "index";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee emp)
	{
	     repo.save(emp);
		
		System.out.println(emp);
		
		return "Success";
		
	}
	
	@GetMapping("/edit")
	public String editEmployee(Model model)
	{
		
		Employee emp = new Employee();
		model.addAttribute("employee",emp);
		
		return "edit";
		
	}
	
	@PostMapping("/editDetails")
	public String editEmployeeDetails(@ModelAttribute("employee") Employee emp)
	{
		System.out.println(emp);
		
		Employee empl = repo.findById(emp.getId());
		
		empl.setName(emp.getName());
		empl.setEmail(emp.getEmail());
		
		repo.save(empl);		
	
		
		return "success";
	}
	
	@GetMapping("/delete" )
	public String deleteEmployeeDetails(Model model)
	{
		Employee emp = new Employee();
		model.addAttribute("employee",emp);
		
		return "deleteEmployee";
	}
	
	@PostMapping("/deleteDetails")
	public String deleteEmployeeDetails(@ModelAttribute("employee") Employee emp)
	{
		repo.deleteById(emp.getId());
		
		return "success";
	}
	
	@GetMapping("/all")
	public String showAll(Model model) {
	    model.addAttribute("employee", repo.findAll());
	    return "AllEmployees";
	}
	
	

}
