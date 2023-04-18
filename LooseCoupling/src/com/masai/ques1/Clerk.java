package com.masai.ques1;

public class Clerk implements College {

	public void registerStudent(){
	    System.out.println("enroll the Student in Collage");
	}

	@Override
	public void doJob() {
		// TODO Auto-generated method stub
		registerStudent();
	}
}
