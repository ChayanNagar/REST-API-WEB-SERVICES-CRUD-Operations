package com.example.RestApi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RestApi.dao.EmployeeDao;
import com.example.RestApi.entities.Employee;

@Service
public class EmployeeService {

	@Autowired    //spring will automatically create the object of EmployeeDao interface
	EmployeeDao empdao;

	public Iterable<Employee> getAllEmp()  //method to view all records
	{
		return empdao.findAll();
		
	}
   
	//method to view specific records with help of eid
	public Employee getEmp(int eid) {
		
		return empdao.findOne(eid);
	}
     
	//method to insert new record
	public Employee createEmp(Employee emp) {
	
		return empdao.save(emp);
	}
    
	//method to delete record with help of eid
	public void deleteEmp(int eid) {
	
		empdao.delete(eid);
	}
	
	//method to update whole record
    public Employee updateEmp(Employee emp) {
		Employee e=empdao.findOne(emp.getEid());
		e.setEname(emp.getEname());
		e.setSalary(emp.getSalary());
		e.setAddress(emp.getAddress());
		return empdao.save(e);
	}
    
    //method to update salary with help of eid
	public Employee patchEmp(int eid, double salary) {
		Employee e=empdao.findOne(eid);
		e.setSalary(salary);
		return empdao.save(e);
	}

}
