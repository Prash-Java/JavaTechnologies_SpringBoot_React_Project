package com.employeesmanagementsystems.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeesmanagementsystems.exception.ResourceNotFoundException;
import com.employeesmanagementsystems.model.Employee;
import com.employeesmanagementsystems.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {
	
	@Autowired //Inject Employee Repository
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/employees") //Rest API To fetch all Employees
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	
	@PostMapping("/employees") //Rest API To Add Employee
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@GetMapping("/employees/{id}") //Rest API to find Employee by Id
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
		Employee employee = employeeRepository.findById(id).orElseThrow(()-> 
					new ResourceNotFoundException("Employee not found with given Id: " + id));
		return ResponseEntity.ok(employee);
	}
	
	@PutMapping("/employees/{id}") //Rest API to Update Employee by ID
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
		Employee employee = employeeRepository.findById(id).orElseThrow(()->
				new ResourceNotFoundException("Employee not found with given Id: " + id));
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmailId(employeeDetails.getEmailId());
		Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	@DeleteMapping("/employees/{id}") //Rest API to delete Employee by ID
	public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id){
		Employee employee = employeeRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Employee not found with given Id: " + id));
		employeeRepository.delete(employee);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
}
