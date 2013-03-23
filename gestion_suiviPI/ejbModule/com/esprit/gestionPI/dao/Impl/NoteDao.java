package com.esprit.gestionPI.dao.Impl;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.esprit.gestionPI.dao.NoteDaoRemote;
import com.esprit.gestionPI.persistence.Note;

public class NoteDao implements NoteDaoRemote {
@PersistenceContext
EntityManager em;
	@Override
	public void add(Note e) {
		em.persist(e);
		
	}

	@Override
	public void delete(int id) {
		em.remove(findById(id));
		
	}

	@Override
	public void update(Note e) {
		em.merge(e);
		
	}

	@Override
	public Note findById(int id) {
		
		return em.find(Note.class, id);
	}

	@Override
	public Set<Note> findAll() {
		
		return (Set<Note>) em.createQuery("select e from Note e").getResultList();
	}

}
