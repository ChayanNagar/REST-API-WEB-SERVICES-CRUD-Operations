package com.example.RestApi.dao;
import org.springframework.data.repository.CrudRepository;

import com.example.RestApi.entities.Employee;


public interface EmployeeDao extends CrudRepository<Employee,Integer>{

}
