package com.masai.ques3;

public class Runner {

	private DrawShape d;

	private Circle circle;
	
	public Runner() {
		super();
	}

	public Runner(DrawShape d, Circle circle) {
		super();
		this.d = d;
		this.circle = circle;
	}

	public Runner(DrawShape d) {
		super();
		this.d = d;
	}

	public DrawShape getD() {
		return d;
	}

	public void setD(DrawShape d) {
		this.d = d;
	}
	

}
