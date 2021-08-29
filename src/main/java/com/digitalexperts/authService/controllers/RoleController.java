package com.digitalexperts.authService.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digitalexperts.authService.bo.Role;
import com.digitalexperts.authService.service.impl.RoleServiceImpl;

@RestController
public class RoleController {
	private RoleServiceImpl roleService;

	public RoleController(RoleServiceImpl roleService) {
		super();
		this.roleService = roleService;
	}
	
	@PostMapping("/addrole")
	public Role addrole(@RequestBody Role  role) {
		return roleService.saveRole(role);
	}
	@GetMapping("/roles")
	public List<Role> listRole(){
		return roleService.findAll();
	}
	@DeleteMapping("/role/{id}")
	public String deleteRole(@RequestParam Long id) {
		return roleService.deleteRole(id);
	}
	@PutMapping("/update")
	public Role UpdateRole(@RequestBody Role role) {
		return roleService.updateRole(role);
	}
}
