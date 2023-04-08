package Ques1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class StudentThreadPoolExample {
    public static void main(String[] args) {
        // Create a thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Create a list of tasks to submit to the thread pool
        List<Callable<String>> tasks = new ArrayList<>();
        tasks.add(new StudentTask(new Student(10, "Varun", "Pune", 450)));
        tasks.add(new StudentTask(new Student(20, "Sonia", "Mumbai", 650)));
        tasks.add(new StudentTask(new Student(30, "Rahul", "Delhi", 750)));
        tasks.add(new StudentTask(new Student(40, "Amit", "Bangalore", 550)));
        tasks.add(new StudentTask(new Student(50, "Rajesh", "Chennai", 350)));
        tasks.add(new StudentTask(new Student(60, "Priya", "Kolkata", 800)));

        try {
            // Submit tasks to the thread pool and wait for them to complete
            List<Future<String>> results = executor.invokeAll(tasks);

            // Print the results of each task
            for (Future<String> result : results) {
                System.out.println(result.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // Shutdown the thread pool
            executor.shutdown();
        }
    }

    // Define a task that accepts a Student object and returns a result string
    static class StudentTask implements Callable<String> {
        private final Student student;

        public StudentTask(Student student) {
            this.student = student;
        }

        @Override
        public String call() throws Exception {
            String result;
            if (student.getMarks() < 500) {
                result = "Roll " + student.getRoll() + " student is Fail";
            } else {
                result = "Roll " + student.getRoll() + " student is Pass";
            }
            return result;
        }
    }

    // Define a Student class with roll, name, address, and marks properties
    static class Student {
        private final int roll;
        private final String name;
        private final String address;
        private final int marks;

        public Student(int roll, String name, String address, int marks) {
            this.roll = roll;
            this.name = name;
            this.address = address;
            this.marks = marks;
        }

        public int getRoll() {
            return roll;
        }

        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }

        public int getMarks() {
            return marks;
        }
    }
}

