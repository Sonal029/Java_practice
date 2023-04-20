package com.masai.ques2;

public class Runner {

	public static void main(String[] args) {
		
		SuperContaGame scg = new SuperContaGame();
		scg.down();
		scg.up();
		scg.left();
		scg.right();
		
		PacManGame pmg = new PacManGame();
		pmg.down();
		pmg.up();
		pmg.left();
		pmg.down();
		
	}
	
	
}
