package com.ibm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.NewSbiException.NewSbiException;
import com.ibm.dto.EmployeeDTO;
import com.ibm.entity.Employee;
import com.ibm.repository.EmployeeRepository;

@Service(value = "EmployeeServiceImpl")
public class EmployeeServiceImp implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public EmployeeDTO getData(Integer employeeId) throws NewSbiException {
		Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
		Employee employee = optionalEmployee.orElseThrow( ()->new NewSbiException("Service.EMPLOYEE_NOT_FOUND"));
		
		EmployeeDTO employeeDTO=new EmployeeDTO();
		
		employeeDTO.setName(employee.getName());
		employeeDTO.setDateOfBirth(employee.getDateOfBirth());
		employeeDTO.setEmailId(employee.getEmailId());
		employeeDTO.setEmployeeId(employee.getEmployeeId());
		
		return employeeDTO;
	}
	@Override
	public List<EmployeeDTO> getAllEmployee() throws NewSbiException {
		Iterable<Employee> itrableEmployee = employeeRepository.findAll();
		
		List<EmployeeDTO>emplist= new ArrayList<>();	
		
		itrableEmployee.forEach(employee-> {
			
			EmployeeDTO employeeDTO=new EmployeeDTO();
			
			employeeDTO.setName(employee.getName());
			employeeDTO.setDateOfBirth(employee.getDateOfBirth());
			employeeDTO.setEmailId(employee.getEmailId());
			employeeDTO.setEmployeeId(employee.getEmployeeId());
			emplist.add(employeeDTO);
		});
		
		if(emplist.isEmpty()) throw new NewSbiException("Service.EMPLOYEE_NOT_FOUND");
		{
			return emplist;
		}
		
		
	}

}
