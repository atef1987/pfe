package com.esprit.gestionPI.dao.Impl;

import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.esprit.gestionPI.dao.ModelFicheDaoRemote;
import com.esprit.gestionPI.persistence.ModelFiche;
@Stateless
public class ModelFicheDao implements ModelFicheDaoRemote {
@PersistenceContext
EntityManager em;
	@Override
	public void add(ModelFiche e) {
		
		em.persist(e);
	}

	@Override
	public void delete(int id) {
		em.remove(findById(id));
		
	}

	@Override
	public void update(ModelFiche e) {
		em.merge(e);
		
	}

	@Override
	public ModelFiche findById(int id) {
		
		return em.find(ModelFiche.class, id);
	}

	@Override
	public Set<ModelFiche> findAll() {
		
		return (Set<ModelFiche>) em.createQuery("select e from ModelFiche e").getResultList();
	}

}
