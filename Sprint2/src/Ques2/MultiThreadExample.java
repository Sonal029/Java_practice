package Ques2;

public class MultiThreadExample {
    public static void main(String[] args) {
        // Create the 3 threads
        Thread virat = new Thread(new ViratTask(), "Virat");
        Thread dhoni = new Thread(new DhoniTask(), "Dhoni");
        Thread rohit = new Thread(new RohitTask(), "Rohit");

        // Set the max priority to the Dhoni thread
        dhoni.setPriority(Thread.MAX_PRIORITY);

        // Start the threads
        dhoni.start();
        rohit.start();
        virat.start();
    }

    // Define a task that prints the addition of the first 20 numbers
    static class ViratTask implements Runnable {
        @Override
        public void run() {
            int sum = 0;
            for (int i = 1; i <= 20; i++) {
                sum += i;
            }
            System.out.println(Thread.currentThread().getName() + " thread: Addition of first 20 numbers is " + sum);
        }
    }

    // Define a task that prints the numbers from 1 to 10
    static class DhoniTask implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + " thread: " + i);
            }
        }
    }

    // Define a task that prints the product of the first 10 numbers
    static class RohitTask implements Runnable {
        @Override
        public void run() {
            int product = 1;
            for (int i = 1; i <= 10; i++) {
                product *= i;
            }
            System.out.println(Thread.currentThread().getName() + " thread: Product of first 10 numbers is " + product);
        }
    }
}

