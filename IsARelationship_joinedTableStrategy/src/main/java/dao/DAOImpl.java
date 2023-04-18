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
	public List<Coffee> findCoffee(int coffeeId) {
		// TODO Auto-generated method stub
		
		EntityManager em = EMUtils.emf();
		Query q = em.createNamedQuery("get coffee By id");
		q.setParameter("coffeeId", 1);
		List<Coffee> coffee = q.getResultList();
		
		
		return coffee;
	}

	@Override
	public List<Coffee> findCoffeeByOrigin(String origin) {
		EntityManager em = EMUtils.emf();
		Query q = em.createNamedQuery("SELECT c from COffee c where c.origin  :origin ");
		q.setParameter("origin", origin);
		
        List<Coffee> coffee = q.getResultList();
		
		
		return coffee;
	}
   
	
}
