package com.esprit.gestionPI.dao;

import java.util.Set;

import javax.ejb.Remote;

import com.esprit.gestionPI.persistence.ModelFiche;

@Remote
public interface ModelFicheDaoRemote {
	void add(ModelFiche e);

	void delete(int id);

	void update(ModelFiche e);

	ModelFiche findById(int id);
	
	Set<ModelFiche> findAll(); 
}
