package com.nitienit.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nitienit.entity.Role;
import com.nitienit.services.RoleService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/role")
@Slf4j
public class RoleController {

	private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

	@Autowired
	private RoleService roleService;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createRole(@RequestBody Role role) {
		logger.info("[ROleController] :: (createRole)");
		roleService.createRole(role);
	}

	@GetMapping("{id}")
	public Role getAllRole(@PathVariable(name = "id") Long id) {
		logger.info("[ROleontroller] :: (getAllRole) {}", id);
		return roleService.getAllRole(id);
	}

}
