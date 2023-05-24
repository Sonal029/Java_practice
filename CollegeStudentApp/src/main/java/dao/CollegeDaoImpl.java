package dao;

import java.util.List;

import entities.College;
import entities.Student;
import exceptions.CollegeException;
import exceptions.StudentException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import utilities.EMUtil;

public class CollegeDaoImpl implements CollegeDao{

	@Override
	public College registerCollege(College college) throws CollegeException {
		
		if(college==null)
		{
			throw new CollegeException("College data can't be null");
		}
		EntityManager em = EMUtil.provideEntityManager();
		try
		{
			em.getTransaction().begin();
			em.persist(college);
			em.getTransaction().commit();
		}
		catch(Exception ex)
		{
			throw new CollegeException("Couldn't register "+ex.getMessage());
		}
		finally
		{
			em.close();
		}
		
		return college;
	}

	@Override
	public College getCollegeFromCollegeId(int collegeId) throws CollegeException {
		// TODO Auto-generated method stub
		
		EntityManager em = EMUtil.provideEntityManager();
		try
		{
			College clg = em.find(College.class, collegeId);
			if(clg==null)
			{
				throw new CollegeException("Invalid collegeId "+collegeId);
			}
			return clg;
		}
		catch(Exception ex)
		{
			throw new CollegeException("Couldnot find college "+ex.getMessage());
		}
		finally
		{
			em.close();
		}
		
	}

	@Override
	public List<College> getAllCollege() throws CollegeException {
		// TODO Auto-generated method stub
		
		EntityManager em = EMUtil.provideEntityManager();
		try
		{
			String queryString = "SELECT c FROM College c";
	        Query query = em.createQuery(queryString);
	        return query.getResultList();
		}
		catch(Exception ex)
		{
			throw new CollegeException("Couldnot get all college"+ex.getMessage());
		}
		finally
		{
			em.close();
		}
	}

	@Override
	public Student registerStudentToCollege(int studentId, int collegeId) throws CollegeException, StudentException {
		EntityManager em = EMUtil.provideEntityManager();
		
		try
		{
			College clg = em.find(College.class, collegeId);
			if(clg == null)
			{
				throw new CollegeException("Invalid collegeId "+collegeId);
			}
			
			Student std = em.find(Student.class, studentId);
			if(std==null)
			{
				throw new StudentException("Invalid studentId "+studentId);
			}
			std.setCollege(clg);
			clg.getStudents().add(std);
			em.getTransaction().begin();
			em.getTransaction().commit();
			
			return std;
			
		}
		catch(Exception ex)
		{
			throw new CollegeException("There is an error "+ex.getMessage());
		}
		finally
		{
			em.close();
		}
		
	}

	@Override
	public List<Student> getAllStudentsFromCollegeId(int collegeId) throws CollegeException, StudentException {


		EntityManager em = EMUtil.provideEntityManager();
		
		try
		{
			College clg=em.find(College.class, collegeId);
			if(clg==null)
			{
				throw new CollegeException("Invalid college Id "+collegeId);
			}
			
			String query = "Select s from student s where s.college :college";
			Query q = em.createQuery(query);
			q.setParameter("college", clg);
			
			return q.getResultList();
		}
		catch(Exception ex)
		{
			throw new CollegeException("There is an error "+ex.getMessage());
		}
		finally
		{
			em.close();
		}
	}

}
