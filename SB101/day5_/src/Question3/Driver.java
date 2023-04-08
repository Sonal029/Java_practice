package Question3;

public class Driver {
	
	
	 public static void main(String[] args) throws InterruptedException {
	        PrimeNumber t1 = new PrimeNumber("T1", 201, 300, 5);
	        PrimeNumber t2 = new PrimeNumber("T2", 301, 400, 7);
	        PrimeNumber t3 = new PrimeNumber("T3", 601, 700, 3);

	        t1.start();
	        t1.join();
	        t2.start();
	        t3.start();
	        t2.join();
	        t3.join();

	        System.out.println("Main thread finished");
	    }
	}

