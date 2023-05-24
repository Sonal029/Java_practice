package dao;

import java.util.List;

import entities.College;
import entities.Student;
import exceptions.CollegeException;
import exceptions.StudentException;

public class CollegeDaoImpl implements CollegeDao{

	@Override
	public College registerCollege(College college) throws CollegeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public College getCollegeFromCollegeId(int collegeId) throws CollegeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<College> getAllCollege() throws CollegeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student registerStudentToCollege(int studentId, int collegeId) throws CollegeException, StudentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getAllStudentsFromCollegeId(int collegeId) throws CollegeException, StudentException {
		// TODO Auto-generated method stub
		return null;
	}

}
