package Question1;

public class DriverQ1 
{
	public static void main(String[] args) throws InterruptedException {
		
		Runnable r1 = new Akshay();
	    Runnable r2 = new Hrithik();
	    Runnable r3 = new Multithreaded();
	    
	    Thread t1 = new Thread(r1, "Akshay");
	    Thread t2 = new Thread(r2, "Hrithik");
	    Thread t3 = new Thread(r3, "Multithreaded");
	    
	    t3.start();
	    t2.start();
	    
	    t3.join();
	    t2.join();
	    
	    Thread.sleep(500);
	    
	    t1.start();
	    
	}
    
    
    
}
