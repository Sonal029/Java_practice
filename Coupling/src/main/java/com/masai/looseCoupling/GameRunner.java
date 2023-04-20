package com.masai.looseCoupling;

public class GameRunner {

	 private final Game game;

	    public GameRunner(Game game) {
	        this.game = game;
	    }

	    public void run() {
	        System.out.println("Game is started");
	        game.up();
	        game.down();
	        game.left();
	        game.right();
	    }
		
	

}
	
