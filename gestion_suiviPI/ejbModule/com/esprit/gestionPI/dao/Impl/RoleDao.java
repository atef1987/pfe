package com.esprit.gestionPI.dao.Impl;

import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.esprit.gestionPI.dao.RoleDaoRemote;
import com.esprit.gestionPI.persistence.Role;

@Stateless
public class RoleDao implements RoleDaoRemote{

	@PersistenceContext
	EntityManager em;
	
	public void add(Role e) {
		em.persist(e);
		
	}

	public void delete(int id) {
		em.remove(findById(id));
		
	}

	public void update(Role e) {
		em.merge(e);
		
	}

	public Role findById(int id) {
		return em.find(Role.class, id);
	}

	public Set<Role> findAll() {
		return (Set<Role>) em.createQuery("select e from Role e").getResultList();
	}

}
