package com.nitienit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nitienit.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
