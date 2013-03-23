package com.esprit.gestionPI.dao;

import java.util.Set;

import javax.ejb.Remote;

import com.esprit.gestionPI.persistence.Classe;
@Remote
public interface ClasseDaoRemote {
	void add(Classe e);

	void delete(int id);

	void update(Classe e);

	Classe findById(int id);
	
	Set<Classe> findAll(); 


}
