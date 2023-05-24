package dao;

import java.util.List;

import entities.College;
import entities.Student;
import exceptions.CollegeException;
import exceptions.StudentException;

public class StudentDaoImpl implements StudentDao{

	@Override
	public Student registerStudent(Student student) throws StudentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getStudentFromStudentId(int studentId) throws StudentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getAllActiveStudents() throws StudentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public College getCollegeFromStudentId(int studentId) throws CollegeException, StudentException {
		// TODO Auto-generated method stub
		return null;
	}

}
