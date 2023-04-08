package Question1;

public class Driver {

	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		Runnable r1 = new EvenThread();
		Runnable r2 = new OddThread();
		
		Thread T1 = new Thread(r1);
		Thread T2 = new Thread(r2);
		
		T1.start();
		T1.join();
		T2.start();
		
		T2.join();
		

	}

}
