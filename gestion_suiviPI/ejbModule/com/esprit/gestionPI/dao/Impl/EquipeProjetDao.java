package com.esprit.gestionPI.dao.Impl;

import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.esprit.gestionPI.dao.EquipeProjetDaoRemote;
import com.esprit.gestionPI.persistence.EquipeProjet;
@Stateless
public class EquipeProjetDao implements EquipeProjetDaoRemote {
@PersistenceContext 
EntityManager em;
	@Override
	public void add(EquipeProjet e) {
		em.persist(e);
		
	}

	@Override
	public void delete(int id) {
		em.remove(findById(id));
		
	}

	@Override
	public void update(EquipeProjet e) {
		em.merge(e);
		
	}

	@Override
	public EquipeProjet findById(int id) {
		
		return em.find(EquipeProjet.class, id);
	}

	@Override
	public Set<EquipeProjet> findAll() {
		
		return (Set<EquipeProjet>) em.createQuery("select e from EquipeProjet e").getResultList();
	}

}
