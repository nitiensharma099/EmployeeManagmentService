package com.nitienit.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.nitienit.entity.Employee;
import com.nitienit.response.EmployeeBussinessResponse;
import com.nitienit.services.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/employee")
@Slf4j
public class EmployeeController {

	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService productService;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createEmployee(@RequestBody Employee employee) {
		log.info("[EmployeeController] :: createEmployee() starts");
		productService.createEmployee(employee);
		log.info("[EmployeeController] :: createEmployee() ends");
	}

	@GetMapping("{id}")
	public Employee getEmployee(@PathVariable(name = "id") Long id) {
		log.info("[EmployeeController] :: getEmployee() starts/ends id{}", id);
		return productService.getEmployee(id);
	}

//	@GetMapping()
//	public List<Employee> getAllEmployee() {
//		log.info("[EmployeeController] :: getAllEmployee() starts/ends ");
//		return	productService.getAllEmployee();
//	}
	@GetMapping()
	public EmployeeBussinessResponse getAllEmployee(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "5") Integer pageSize, @RequestParam(defaultValue = "DESC") String sortBy) {
		log.info("[EmployeeController] :: getAllEmployee() starts/ends ");
		if (sortBy.equalsIgnoreCase("ASC")) {
			log.info("[EmployeeController] :: getAllEmployee() in ASC order ");
			return productService.getAllEmployeeWithPagination(PageRequest.of(pageNo, pageSize, Direction.ASC, "price"));
		} else {
			log.info("[EmployeeController] :: getAllEmployee() in DESC order ");
			return productService
					.getAllEmployeeWithPagination(PageRequest.of(pageNo, pageSize, Direction.DESC, "price"));
		}
	}

	@PutMapping("{id}")
	public void updateEmployee(@PathVariable(name = "id") Long id, @RequestBody Employee employee) {
		log.info("[EmployeeController] :: updateEmployee() starts/ends id{}", id);
		productService.updateEmployee(id, employee);
	}

	@DeleteExchange("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteEmployee(@PathVariable(name = "id") Long id) {
		log.info("[EmployeeController] :: deleteEmployee() starts/ends id{}", id);
		productService.deleteEmployee(id);
	}

}
