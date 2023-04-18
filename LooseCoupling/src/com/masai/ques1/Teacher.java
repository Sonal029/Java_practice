package com.masai.ques1;

public class Teacher implements College{
	public void teaches(){
	      System.out.println("Teacher teaches");
	}

	@Override
	public void doJob() {
		// TODO Auto-generated method stub
		teaches();
	}
}
