package com.sonia.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sonia.jpa.entities.ERole;
import com.sonia.jpa.entities.Role;

public interface RoleRepository  extends JpaRepository<Role, Long> {

	
	
	Optional<Role> findByName(ERole name);
}
