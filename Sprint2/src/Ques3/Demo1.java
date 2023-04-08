package Ques3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) throws IOException {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "John Doe", 50000, "johndoe@example.com", "password1", new Address("CA", "Los Angeles", "90001")));
        employees.add(new Employee(2, "Jane Smith", 60000, "janesmith@example.com", "password2", new Address("NY", "New York", "10001")));
        employees.add(new Employee(3, "Bob Johnson", 70000, "bobjohnson@example.com", "password3", new Address("TX", "Dallas", "75001")));
        employees.add(new Employee(4, "Alice Lee", 80000, "alicelee@example.com", "password4", new Address("CA", "San Francisco", "94101")));
        employees.add(new Employee(5, "Tom Brown", 90000, "tombrown@example.com", "password5", new Address("FL", "Miami", "33010")));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employeedata.txt"))) {
            oos.writeObject(employees);
            System.out.println("Serialized employee data to employeedata.txt");
        }
    }
}
