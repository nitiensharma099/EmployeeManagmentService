package com.nitienit.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nitienit.entity.Role;
import com.nitienit.exception.ResourceNotFoundException;
import com.nitienit.repositories.RoleRepository;
import com.nitienit.services.RoleService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

	private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void createRole(Role role) {

		logger.info("[RoleServiceImpl] :: (createRole) ");
		roleRepository.save(role);

	}

	@Override
	public Role getAllRole(Long id) {
		logger.info("[RoleServiceImpl] :: (getAllRole) ");
		return roleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Record found"));

	}

}
