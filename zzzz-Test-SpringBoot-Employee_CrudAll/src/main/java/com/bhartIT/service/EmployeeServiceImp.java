package com.bhartIT.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhartIT.dto.EmployeeDto;
import com.bhartIT.entity.Employee;
import com.bhartIT.exception.NewSbiException;
import com.bhartIT.repository.EmployeeRepostory;

import jakarta.transaction.Transactional;

@Service(value="customerService")
@Transactional
public class EmployeeServiceImp implements EmployeeService{
	
@Autowired
private EmployeeRepostory employeeRepostory;

@Override
public EmployeeDto getData(Integer employeeId) throws NewSbiException {

	Optional<Employee> optional = employeeRepostory.findById(employeeId);
	Employee employee = optional.orElseThrow(()-> new NewSbiException("Service.CUSTOMER_NOT_FOUND"));
	
	EmployeeDto employeedto=new EmployeeDto();
	employeedto.setName(employee.getName());
	employeedto.setDateOfBirth(employee.getDateOfBirth());
	employeedto.setEmailId(employee.getEmailId());
	employeedto.setEmployeeId(employee.getEmployeeId());
	
	return employeedto;
}

@Override
public List<EmployeeDto> getAllData() throws NewSbiException {
	Iterable<Employee> employees = employeeRepostory.findAll();
	List<EmployeeDto>employee2=new ArrayList<>();
	
	employees.forEach(employee->{
		EmployeeDto employeeDto=new EmployeeDto();
		
		employeeDto.setDateOfBirth(employee.getDateOfBirth());
		employeeDto.setEmailId(employee.getEmailId());
		employeeDto.setEmployeeId(employee.getEmployeeId());
		employeeDto.setName(employee.getName());
		employee2.add(employeeDto);
		
	});
	if(employee2.isEmpty())
	{
		throw new NewSbiException("Service.employee_NOT_FOUND");
		
	}

	return employee2;
}

@Override
public Integer addEmployee(EmployeeDto employee) throws NewSbiException {
	
Employee empoyeeEntity	= new Employee();

empoyeeEntity.setDateOfBirth(employee.getDateOfBirth());
empoyeeEntity.setEmailId(employee.getEmailId());
empoyeeEntity.setEmployeeId(employee.getEmployeeId());
empoyeeEntity.setName(employee.getName());

Employee empoyeeEntity2 = employeeRepostory.save(empoyeeEntity);

	return empoyeeEntity2.getEmployeeId();
}

@Override
public void deleteData(Integer employeeId) throws NewSbiException {
	
	employeeRepostory.deleteById(employeeId);
	
}

@Override
public Employee updateEmployee(Integer employeeId, Employee updatedEmployee) {
    Employee existingEmployee = null;
	try {
		existingEmployee = employeeRepostory.findById(employeeId)
		.orElseThrow(() -> new NewSbiException("Service.Employee_Update" + employeeId));
	
    existingEmployee.setName(updatedEmployee.getName());
    existingEmployee.setEmailId(updatedEmployee.getEmailId());
    // Set other fields as needed
    return employeeRepostory.save(existingEmployee);
	} catch (NewSbiException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
	return existingEmployee;
}}


	

}
