package com.nitienit.services.impl;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nitienit.entity.Employee;
import com.nitienit.exception.ResourceNotFoundException;
import com.nitienit.repositories.RoleRepository;
import com.nitienit.repositories.EmployeeRepository;
import com.nitienit.response.EmployeeBussinessResponse;
import com.nitienit.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private RoleRepository categoryRepository;

	@Override
	public void createEmployee(Employee employee) {
		logger.info("[EmployeeServiceImpl] :: createEmployee starts ");
		employeeRepository.save(employee);
		logger.info("[EmployeeServiceImpl] :: createEmployee ends ");
	}

	@Override
	public Employee getEmployee(Long id) {
		logger.info("[EmployeeServiceImpl] :: getEmployee starts/ends ");
		return employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Prdouct id not found in db"));
	}

	@Override
	public void updateEmployee(Long id, Employee employee) {
		logger.info("[EmployeeServiceImpl] :: updateEmployee starts id {} ", id);
		Employee dbEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Prdouct id not found in db"));

		categoryRepository.findById(dbEmployee.getRole().getId())
				.orElseThrow(() -> new RuntimeException("Category id not found in db"));

		dbEmployee.setFirstName(employee.getFirstName());
		dbEmployee.setLastName(employee.getLastName());
		dbEmployee.setEmail(employee.getEmail());
		dbEmployee.setPassword(employee.getPassword());
		dbEmployee.setRole(employee.getRole());
		employeeRepository.save(dbEmployee);
		logger.info("[EmployeeServiceImpl] :: updateEmployee ends ");

	}

	@Override
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);

	}

	@Override
	public List<Employee> getAllEmployee() {
		logger.info("[EmployeeServiceImpl] :: getAllEmployee starts ");
		return employeeRepository.findAll();
	}

	@Override
	public EmployeeBussinessResponse getAllEmployeeWithPagination(PageRequest pageRequest) {
		logger.info("[EmployeeServiceImpl] :: getAllEmployeeWithPagination starts ");
		Page<Employee> page = employeeRepository.findAll(pageRequest);
		EmployeeBussinessResponse employee = new EmployeeBussinessResponse();
		employee.setTotalNumberOfPages(page.getTotalPages());
		employee.setTotalNumberOfRecords(page.getNumberOfElements());
		employee.setEmployees(page.getContent());
		return employee;
	}

}
