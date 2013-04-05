package com.esprit.gestionPI.dao;

import java.util.Set;

import javax.ejb.Remote;

import com.esprit.gestionPI.persistence.Projet;
@Remote
public interface ProjetDaoRemote {
	void add(Projet e);

	void delete(int id);

	void update(Projet e);

	Projet findById(int id);
	
	Set<Projet> findAll(); 
}
