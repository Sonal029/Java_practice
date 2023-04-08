package Question1;

//Create two threads, one thread to display all even numbers between 1 & 20, and another to
//display odd numbers between 1 & 20.
//Note: Display all even numbers followed by odd numbers from the main method.
//Hint: use join
public class EvenThread implements Runnable{

	@Override
	public void run() {
		
		for(int i=2;i<20;i=i+2)
		{
			System.out.print(i+" ");
		}
	}

}
