package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class main {

	
	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ques3");
	EntityManager em = emf.createEntityManager();
	
	
	A a = new A("abc");
	B b = new B("bcd");
	
	a.setB(b);
	b.setA(a);
	
	em.getTransaction().begin();
	em.persist(a);
	em.getTransaction().commit();
	
	B a1 = em.find(B.class, 2);
	System.out.println(a1.getA().getName());
	em.close();
	System.out.println("end");
	
	}
}
