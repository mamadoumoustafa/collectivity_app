package com.digitalexperts.authService.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.digitalexperts.authService.bo.Role;
import com.digitalexperts.authService.repository.RoleRepository;
import com.digitalexperts.authService.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {
	
	private final RoleRepository roleRepository;

	public RoleServiceImpl(RoleRepository roleRepository) {
		super();
		this.roleRepository = roleRepository;
	}

	@Override
	public Role findByName(String name) {
		// TODO Auto-generated method stub
		return roleRepository.findByNom(name);
	}

	@Override
	public Role saveRole(Role role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}

	@Override
	public String deleteRole(Long id) {
		// TODO Auto-generated method stub
		roleRepository.deleteById(id);
		return "remove "+ id;
	}

	@Override
	public Role updateRole(Role role) {
		// TODO Auto-generated method stub
		Role roleExis=roleRepository.findById(role.getId()).orElse(null);
		roleExis.setNom(role.getNom());
		roleExis.setCreateDateTime(role.getCreateDateTime());
		roleExis.setUpdateDateTime(role.getUpdateDateTime());
		return roleRepository.save(roleExis);
	}

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

	@Override
	public Role findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}




}
