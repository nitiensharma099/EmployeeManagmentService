package com.nitienit.services;

import java.util.List;

import org.springframework.data.domain.PageRequest;

import com.nitienit.entity.Employee;
import com.nitienit.response.EmployeeBussinessResponse;

public interface EmployeeService {

	void createEmployee(Employee employee);

	Employee getEmployee(Long id);

	List<Employee> getAllEmployee();

	void updateEmployee(Long id, Employee employee);

	void deleteEmployee(Long id);

	EmployeeBussinessResponse getAllEmployeeWithPagination(PageRequest pageRequest);
}
