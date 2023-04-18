package com.masai.ques1;

public class Collage {

	public void doJob(){
		System.out.println("Job is started");
		//here it needs the service of its Dependencies
		}
	College clg ;
	
	public Collage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setClg(College clg) {
		this.clg = clg;
	}

	public Collage(College clg) {
		super();
		this.clg = clg;
	}

	public void doingJob()
	{
		clg.doJob();
	}
}
