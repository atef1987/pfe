package com.esprit.gestionPI.dao;

import java.util.Set;

import javax.ejb.Remote;

import com.esprit.gestionPI.persistence.PI;

@Remote
public interface PIDaoRemote {
	void add(PI e);

	void delete(int id);

	void update(PI e);

	PI findById(int id);
	
	Set<PI> findAll(); 

}
