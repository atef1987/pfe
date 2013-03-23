package com.esprit.gestionPI.dao;

import java.util.Set;

import javax.ejb.Remote;

import com.esprit.gestionPI.persistence.EquipeProjet;

@Remote
public interface EquipeProjetDaoRemote {
	void add(EquipeProjet e);

	void delete(int id);

	void update(EquipeProjet e);

	EquipeProjet findById(int id);
	
	Set<EquipeProjet> findAll(); 
}
