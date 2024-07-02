package com.nitienit.services;

import com.nitienit.entity.Role;

public interface RoleService {

	void createRole(Role role);

	Role getAllRole(Long id);
}
