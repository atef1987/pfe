package com.esprit.gestionPI.dao.Impl;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.esprit.gestionPI.dao.ClasseDaoRemote;
import com.esprit.gestionPI.dao.EquipeEtudiantDaoRemote;
import com.esprit.gestionPI.persistence.EquipeEtudiant;

public class EquipeEtudiantDao implements EquipeEtudiantDaoRemote {
@PersistenceContext
EntityManager em;
	@Override
	public void add(EquipeEtudiant e) {
		
		em.persist(e);
	}

	@Override
	public void delete(int id) {
		em.remove(findById(id));
		
	}

	@Override
	public void update(EquipeEtudiant e) {
		em.merge(e);
		
	}

	@Override
	public EquipeEtudiant findById(int id) {
		
		return em.find(EquipeEtudiant.class, id);
	}

	@Override
	public Set<EquipeEtudiant> findAll() {
		
		return (Set<EquipeEtudiant>) em.createQuery("select e from EquipeEtudiant e").getResultList();
	}

}
