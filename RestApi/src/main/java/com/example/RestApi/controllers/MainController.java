package com.example.RestApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RestApi.entities.Employee;
import com.example.RestApi.services.EmployeeService;

@RestController
@RequestMapping("/api")
public class MainController {

	@Autowired     //spring will automatically create the object of EmployeeService
	EmployeeService empservice;
	
	//view all records
	@GetMapping("/getallemp")
	//@ResponseBody   //JavaObject into JSON OBject
     public Iterable<Employee> getAllEmp()
	{
		return empservice.getAllEmp();
	}
	
	//view specific records with eid
	@GetMapping("/getemp/{eid}")
	//public Employee getEmp(@RequestParam int eid)
     public Employee getEmp(@PathVariable int eid)
	{
		return empservice.getEmp(eid);
	}
	
	//insert new records
	@PostMapping("/createemp")
	//RequestBody   //JSON Object into Java Object
    public Employee createEmp(@RequestBody Employee emp)
	{
		return empservice.createEmp(emp);
	}
	
	//for delete the records
	@DeleteMapping("/deleteemp/{eid}")
	//public Employee getEmp(@RequestParam int eid)
     public void deleteEmp(@PathVariable int eid)
	{
	    empservice.deleteEmp(eid);
	}
    
	//For update full records
	@PutMapping("/updateemp")
	//RequestBody   //JSON Object into Java Object
    public Employee updateEmp(@RequestBody Employee emp)
	{
		return empservice.updateEmp(emp);
	}
	
	//For updating only few fields
	@PatchMapping("/patchemp/{eid}/{salary}")
	public Employee patchEmp(@PathVariable int eid,@PathVariable double salary)
	{
	   return empservice.patchEmp(eid,salary);
	}
    

}
