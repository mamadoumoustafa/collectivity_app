package com.digitalexperts.authService.service;

import java.util.List;

import com.digitalexperts.authService.bo.Role;

public interface IRoleService {
	Role findByName(String name);
	Role findById(Long id);
	Role saveRole(Role role);

	public String deleteRole(Long id);
	public Role updateRole(Role role);
	public List<Role> findAll();

}
