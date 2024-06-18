package com.ibm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.dto.EmployeeDTO;
import com.ibm.entity.Employee;
import com.ibm.exception.InfyBankException;
import com.ibm.repository.EmployeeRepository;

@Service(value = "employeeServiceImpl")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Integer addEmployee(EmployeeDTO employeeDTO) throws InfyBankException {
		Employee employeeEntity = new Employee();	
		employeeEntity.setId(employeeDTO.getId());
		employeeEntity.setName(employeeDTO.getName());
		employeeEntity.setRole(employeeDTO.getRole());
		Employee employeeEntity2 = employeeRepository.save(employeeEntity);
		return employeeEntity2.getId();
	}
	
	@Override
	public EmployeeDTO getEmployee(Integer id) throws InfyBankException {
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee = optional.orElseThrow(() -> new InfyBankException("Service.EMPLOYEE_NOT_FOUND"));
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setId(employee.getId());
		employeeDTO.setName(employee.getName());
		employeeDTO.setRole(employee.getRole());
		return employeeDTO;
	}

	@Override
	public List<EmployeeDTO> getAllEmployees() throws InfyBankException {
		Iterable<Employee> employees = employeeRepository.findAll();
		List<EmployeeDTO> employeeDTOs = new ArrayList<>();
		employees.forEach(employee -> {
			EmployeeDTO emp = new EmployeeDTO();
			emp.setId(employee.getId());
			emp.setName(employee.getName());
			emp.setRole(employee.getRole());
			employeeDTOs.add(emp);
		});
		if (employeeDTOs.isEmpty())
			throw new InfyBankException("Service.EMPLOYEES_NOT_FOUND");
		return employeeDTOs;
	}

	@Override
	public void deleteEmployee(Integer id) throws InfyBankException {
		Optional<Employee> employee = employeeRepository.findById(id);
		employee.orElseThrow(() -> new InfyBankException("Service.EMPLOYEE_NOT_FOUND_APP"));
		employeeRepository.deleteById(id);
	}

	@Override
	public void updateEmployee(Integer id, String name, String role) throws InfyBankException {
		Optional<Employee> employee = employeeRepository.findById(id);
		Employee e = employee.orElseThrow(() -> new InfyBankException("Service.EMPLOYEE_NOT_FOUND_UPDATE"));
		e.setName(name);
		e.setRole(role);
		employeeRepository.save(e);
	}
	
}
