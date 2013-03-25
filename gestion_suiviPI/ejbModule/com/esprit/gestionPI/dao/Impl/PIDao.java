package com.esprit.gestionPI.dao.Impl;

import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.esprit.gestionPI.dao.PIDaoRemote;
import com.esprit.gestionPI.persistence.PI;

@Stateless
public class PIDao implements PIDaoRemote {
	@PersistenceContext
	EntityManager em;

	@Override
	public void add(PI e) {
		em.persist(e);

	}

	@Override
	public void delete(int id) {
		em.remove(findById(id));

	}

	@Override
	public void update(PI e) {
		em.merge(e);

	}

	@Override
	public PI findById(int id) {

		return em.find(PI.class, id);
	}

	@Override
	public Set<PI> findAll() {

		return (Set<PI>) em.createQuery("select e from PI e").getResultList();
	}

	@Override
	public List<PI> findList() {
		
		return em.createQuery("select e from PI e").getResultList();
	}

	@Override
	public PI getPIbyIntitule(String intitule) {
		
		return   (PI) em.createNativeQuery(
				"select * FROM PI where intitule ='"+intitule+"'", PI.class).getSingleResult();
	}

}
