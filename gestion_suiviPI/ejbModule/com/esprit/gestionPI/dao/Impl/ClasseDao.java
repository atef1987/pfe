package com.esprit.gestionPI.dao.Impl;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.esprit.gestionPI.dao.ClasseDaoRemote;
import com.esprit.gestionPI.persistence.Classe;

public class ClasseDao implements ClasseDaoRemote {
@PersistenceContext
EntityManager em;

	public void add(Classe e) {
		em.persist(e);
	}

	
	public void delete(int id) {
		em.remove(findById(id));
	}

	
	public void update(Classe e) {
		em.merge(e);
		
	}

	
	public Classe findById(int id) {
		
		return em.find(Classe.class, id);
	}

	
	public Set<Classe> findAll() {
		
		return (Set<Classe>) em.createQuery("select e from Classe e")
				.getResultList();
	}

}
