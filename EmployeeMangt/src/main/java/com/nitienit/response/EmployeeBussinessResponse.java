package com.nitienit.response;

import java.util.List;

import com.nitienit.entity.Employee;

import lombok.Data;

@Data
public class EmployeeBussinessResponse {

	int totalNumberOfPages;
	long totalNumberOfRecords;
	List<Employee> employees;
}
