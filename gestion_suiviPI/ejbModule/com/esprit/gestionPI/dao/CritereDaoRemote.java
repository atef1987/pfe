package com.esprit.gestionPI.dao;

import java.util.Set;

import javax.ejb.Remote;

import com.esprit.gestionPI.persistence.Critere;


@Remote
public interface CritereDaoRemote {
	void add(Critere e);

	void delete(int id);

	void update(Critere e);

	Critere findById(int id);
	
	Set<Critere> findAll(); 
}
