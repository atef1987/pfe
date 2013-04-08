package com.esprit.gestionPI.dao;

import java.util.Set;

import javax.ejb.Remote;

import com.esprit.gestionPI.persistence.Reponse;

@Remote
public interface ReponseDaoRemote {
	void add(Reponse e);

	void delete(int id);

	void update(Reponse e);

	Reponse findById(int id);
	
	Set<Reponse> findAll();

}
