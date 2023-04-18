package Connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMUtils {

	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ques2");
	
	public static EntityManager emf()
	{
	   EntityManager em = emf.createEntityManager();
	   return em;
	}
}
