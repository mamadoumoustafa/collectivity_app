package com.digitalexperts.authService.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.digitalexperts.authService.bo.Role;
import com.digitalexperts.authService.service.impl.RoleServiceImpl;

@RestController
@RequestMapping("api/role/")

public class RoleController {

	private RoleServiceImpl roleService;

	public RoleController(RoleServiceImpl roleService) {
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
