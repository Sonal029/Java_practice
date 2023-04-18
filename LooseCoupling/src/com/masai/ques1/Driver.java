package com.masai.ques1;

public class Driver {

	public static void main(String[] args) {
		
		Collage clg = new Collage(new Teacher());
		clg.doingJob();
		
		
		Collage clg2 =new Collage() ;
		clg2.setClg(new Clerk());
		clg2.doingJob();
	}
}
