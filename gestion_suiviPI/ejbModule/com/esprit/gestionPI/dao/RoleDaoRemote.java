package com.esprit.gestionPI.dao;

import java.util.Set;

import javax.ejb.Remote;

import com.esprit.gestionPI.persistence.Role;

@Remote
public interface RoleDaoRemote {
	void add(Role e);

	void delete(int id);

	void update(Role e);

	Role findById(int id);
	
	Set<Role> findAll();

}
