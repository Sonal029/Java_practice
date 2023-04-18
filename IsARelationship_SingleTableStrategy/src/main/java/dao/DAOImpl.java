package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Connection.EMUtils;
import models.Coffee;
import models.Tea;

public class DAOImpl implements DAO
{

	@Override
	public void addTea(Tea tea) {
		EntityManager em = EMUtils.emf();
		em.getTransaction().begin();
		em.persist(tea);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public void addCoffee(Coffee coffee) {
		// TODO Auto-generated method stub
		EntityManager em = EMUtils.emf();
		em.getTransaction().begin();
		em.persist(coffee);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Tea> findTeaByFlavour(String flavor) {
		EntityManager em = EMUtils.emf();
		Query q = em.createNamedQuery("SELECT t from Tea t where t.flavor :flavor ");
		q.setParameter("flavor", flavor);
		
        List<Tea> tea = q.getResultList();
		
		
		return tea;
	}

	@Override
	public List<Tea> findTeaById(int teaId) {
		EntityManager em = EMUtils.emf();
		Query q = em.createNamedQuery("SELECT t from Tea t where t.teaId :teaId ");
		q.setParameter("teaId", teaId);
		
        List<Tea> tea = q.getResultList();
		
		
		return tea;
	}

	@Override
	public List<Tea> findTeaByPrice() {
		EntityManager em = EMUtils.emf();
		Query q = em.createNamedQuery("SELECT t from Tea t where t.price<100 ");
		
        List<Tea> tea = q.getResultList();
		
		
		return tea;
	}

	
   
	
}
