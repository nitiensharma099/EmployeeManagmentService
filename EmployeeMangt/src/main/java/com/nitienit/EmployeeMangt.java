package com.nitienit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EmployeeMangt {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeMangt.class, args);
	}

}
