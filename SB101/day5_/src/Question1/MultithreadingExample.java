package Question1;

public class MultithreadingExample {

	    public static void main(String[] args) {
	        // Create Salman thread
	        Thread salmanThread = new Thread(() -> {
	            int sum = 0;
	            for (int i = 1; i <= 10; i++) {
	                sum += i;
	            }
	            System.out.println("Salman thread: Sum of first 10 numbers is " + sum);
	        });
	        // Create Hritik thread
	        Thread hritikThread = new Thread(() -> {
	            int product = 1;
	            for (int i = 1; i <= 10; i++) {
	                product *= i;
	            }
	            System.out.println("Hritik thread: Product of first 10 numbers is " + product);
	        });
	        // Create Akshay thread
	        Thread akshayThread = new Thread(() -> {
	            for (int i = 1; i <= 10; i++) {
	                System.out.println("Akshay thread: " + Thread.currentThread().getName());
	            }
	        });

	        // Start Salman and Hritik threads
	        salmanThread.start();
	        hritikThread.start();

	        // Wait for Salman and Hritik threads to complete
	        try {
	            salmanThread.join();
	            hritikThread.join();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        // Start Akshay thread (main thread)
	        akshayThread.start();
	        // Print Akshay thread name 10 times
	        for (int i = 1; i <= 10; i++) {
	            System.out.println("Main thread: " + Thread.currentThread().getName());
	        }
	    }
	}
