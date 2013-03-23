package com.esprit.gestionPI.dao;

import java.util.Set;

import javax.ejb.Remote;

import com.esprit.gestionPI.persistence.Note;
@Remote
public interface NoteDaoRemote {
	void add(Note e);

	void delete(int id);

	void update(Note e);

	Note findById(int id);
	
	Set<Note> findAll(); 

}
