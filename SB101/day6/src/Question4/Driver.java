package Question4;

public class Driver {

	public static void main(String[] args) throws InterruptedException
	{
		Country c = new Country();
		
		Runnable r1 = new master(c);
		Runnable r2 = new student(c);
		
		
		Thread T1 = new Thread(r1);
		Thread T2 = new Thread(r2);
		
		T1.start();
		T2.start();
		
		T1.join();
		T2.join();
				
		
		
	}
}
