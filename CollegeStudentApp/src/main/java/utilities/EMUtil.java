package utilities;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EMUtil {
	
	 private static final EntityManagerFactory emFactory;

	    static {
	        try {
	            emFactory = Persistence.createEntityManagerFactory("CollegeStudentUnit");
	        } catch (Throwable ex) {
	            throw new ExceptionInInitializerError(ex);
	        }
	    }

	    public static EntityManager provideEntityManager() {
	        return emFactory.createEntityManager();
	    }
}
