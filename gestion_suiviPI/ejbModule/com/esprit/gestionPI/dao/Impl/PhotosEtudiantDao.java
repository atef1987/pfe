package com.esprit.gestionPI.dao.Impl;

import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.esprit.gestionPI.dao.PhotosEtudiantRemote;
import com.esprit.gestionPI.persistence.PhotosEtudiant;

@Stateless
public class PhotosEtudiantDao implements PhotosEtudiantRemote {

	@PersistenceContext
	EntityManager em;
	
	public void add(PhotosEtudiant e) {
		em.persist(e);
		
	}

	public void delete(int id) {
		em.remove(findById(id));
		
	}

	public void update(PhotosEtudiant e) {
		em.merge(e);
		
	}

	public PhotosEtudiant findById(int id) {
		return em.find(PhotosEtudiant.class, id);
	}

	public Set<PhotosEtudiant> findAll() {
		return (Set<PhotosEtudiant>) em.createQuery("select e from photosEtudiant e").getResultList();
	}

}
