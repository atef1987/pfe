package com.esprit.gestionPI.dao.Impl;

import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
<<<<<<< HEAD

import com.esprit.gestionPI.dao.ProjetDaoRemote;
import com.esprit.gestionPI.persistence.Projet;
@Stateless
public class ProjetDao implements ProjetDaoRemote {
@PersistenceContext
EntityManager em;
	@Override
	public void add(Projet e) {
		em.persist(e);
		
	}

	@Override
	public void delete(int id) {
		em.remove(findById(id));
		
	}

	@Override
	public void update(Projet e) {
		em.merge(e);
		
	}

	@Override
	public Projet findById(int id) {
		
		return em.find(Projet.class, id);
	}

	@Override
	public Set<Projet> findAll() {
		
		return (Set<Projet>) em.createQuery("select e from Projet e").getResultList();
=======
import com.esprit.gestionPI.dao.ProjetDaoRemote;
import com.esprit.gestionPI.persistence.Projet;

@Stateless
public class ProjetDao implements ProjetDaoRemote{

	@PersistenceContext
	EntityManager em;
	
	public void add(Projet e) {
		em.persist(e);
		
	}

	public void delete(int id) {
		em.remove(findById(id));
		
	}

	public void update(Projet e) {
		em.merge(e);
		
	}

	public Projet findById(int id) {
		return em.find(Projet.class, id);
	}

	public Set<Projet> findAll() {
		return (Set<Projet>) em.createQuery("select e from projet e").getResultList();
>>>>>>> refs/remotes/origin/master
	}

}
