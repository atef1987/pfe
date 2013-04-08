package com.esprit.gestionPI.dao;

import java.util.Set;

import javax.ejb.Remote;
import com.esprit.gestionPI.persistence.Partie;

@Remote
public interface PartieDaoRemote {
	void add(Partie e);

	void delete(int id);

	void update(Partie e);

	Partie findById(int id);
	
	Set<Partie> findAll(); 

}
