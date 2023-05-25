package dao;

import java.util.List;

import entities.College;
import entities.Student;
import exceptions.CollegeException;
import exceptions.StudentException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import utilities.EMUtil;

public class StudentDaoImpl implements StudentDao{

	@Override
    public Student registerStudent(Student student) throws StudentException {
        if (student == null) {
            throw new StudentException("Student object is null.");
        }

        EntityManager entityManager = EMUtil.provideEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(student);
            transaction.commit();
            return student;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new StudentException("Failed to register student.");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Student getStudentFromStudentId(int studentId) throws StudentException {
        EntityManager entityManager = EMUtil.provideEntityManager();

        try {
            Student student = entityManager.find(Student.class, studentId);
            if (student == null) {
                throw new StudentException("Student not found with studentId: " + studentId);
            }
            return student;
        } catch (Exception e) {
            throw new StudentException("Failed to retrieve student with studentId: " + studentId);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Student> getAllActiveStudents() throws StudentException {
        EntityManager entityManager = EMUtil.provideEntityManager();

        try {
            TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s WHERE s.status = true", Student.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new StudentException("Failed to retrieve all active students.");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public College getCollegeFromStudentId(int studentId) throws CollegeException, StudentException {
        EntityManager entityManager = EMUtil.provideEntityManager();

        try {
            Student student = entityManager.find(Student.class, studentId);
            if (student == null) {
                throw new StudentException("Student not found with studentId: " + studentId);
            }
            return student.getCollege();
        } catch (StudentException e) {
            throw e;
        } catch (Exception e) {
            throw new CollegeException("Failed to retrieve college from student with studentId: " + studentId);
        } finally {
            entityManager.close();
        }
    }
}

