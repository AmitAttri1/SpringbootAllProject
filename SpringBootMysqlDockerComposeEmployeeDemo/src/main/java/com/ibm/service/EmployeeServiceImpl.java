package com.ibm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.dto.EmployeeDTO;
import com.ibm.entity.Employee;
import com.ibm.exception.SBIException;
import com.ibm.repository.EmployeeRepository;

@Service(value = "employeeServiceImpl")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDTO getEmployee(Integer employeeId) throws SBIException {
		Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
		Employee employee = employeeOptional.orElseThrow(() -> new SBIException("Service.EMPLOYEE_NOT_FOUND"));
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmployeeId(employee.getEmployeeId());
		employeeDTO.setEmailId(employee.getEmailId());
		employeeDTO.setDateOfBirth(employee.getDateOfBirth());
		employeeDTO.setName(employee.getName());
		return employeeDTO;
	}

	@Override
	public List<EmployeeDTO> getAllEmployee() throws SBIException {

		Iterable<Employee> iterableEmployees = employeeRepository.findAll();
		List<EmployeeDTO> listEmployeeDTO = new ArrayList<>();
		iterableEmployees.forEach(employee -> {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setEmployeeId(employee.getEmployeeId());
			employeeDTO.setName(employee.getName());
			employeeDTO.setDateOfBirth(employee.getDateOfBirth());
			employeeDTO.setEmailId(employee.getEmailId());
			listEmployeeDTO.add(employeeDTO);
		});
		

		if(listEmployeeDTO.isEmpty()) throw  new SBIException("Service.EMPLOYEE_NOT_FOUND");
		return listEmployeeDTO;
		
	}

	@Override
	public Integer addEmployee(EmployeeDTO employeeDTO) throws SBIException {	
		Employee employee = new Employee();
		employee.setEmployeeId(employeeDTO.getEmployeeId());
		employee.setName(employeeDTO.getName());
		employee.setDateOfBirth(employeeDTO.getDateOfBirth());
		employee.setEmailId(employeeDTO.getEmailId());
		Employee saveEmployee = employeeRepository.save(employee);
		return saveEmployee.getEmployeeId();
	}

	@Override
	public void updateEmployee(Integer employeeId, String employeename) throws SBIException {	
		
		System.out.println("Name is repository :>>>" + employeename);
		System.out.println("ID   is repository :>>>" + employeeId);
		
		Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
		Employee employee = optionalEmployee.orElseThrow(() -> new SBIException("Service.EMPLOYEE_NOT_FOUND"));
		employee.setName(employeename);
		employeeRepository.save(employee);
		
	}


}
