package com.esprit.gestionPI.dao;

import java.util.Set;

import javax.ejb.Remote;

import com.esprit.gestionPI.persistence.FicheEquipe;
@Remote
public interface FicheEquipeDaoRemote {
	void add(FicheEquipe e);

	void delete(int id);

	void update(FicheEquipe e);

	FicheEquipe findById(int id);
	
	Set<FicheEquipe> findAll(); 
}
