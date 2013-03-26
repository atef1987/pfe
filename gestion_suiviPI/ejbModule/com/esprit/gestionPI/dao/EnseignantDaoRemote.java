package com.esprit.gestionPI.dao;

import java.util.List;
import java.util.Set;

import javax.ejb.Remote;

import com.esprit.gestionPI.persistence.Enseignant;

@Remote
public interface EnseignantDaoRemote {
	void add(Enseignant e);

	void delete(int id);

	void update(Enseignant e);

	Enseignant findById(int id);
	
	Set<Enseignant> findAll(); 
	List<Enseignant>findallList();
}
