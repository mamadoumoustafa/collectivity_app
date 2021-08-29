package com.digitalexperts.authService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalexperts.authService.bo.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByNom(String nom);

}
