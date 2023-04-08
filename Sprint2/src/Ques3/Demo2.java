package Ques3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class Demo2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Employee> employees;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employeedata.txt"))) {
            employees = (List<Employee>) ois.readObject();
            System.out.println("Deserialized employee data from employeedata.txt:");
            employees.forEach(System.out::println);
        }

        // Add another employee to the list
        employees.add(new Employee(6, "Kate Wilson", 100000, "katewilson@example.com", "password6", new Address("WA", "Seattle", "98101")));

        // Serialize the updated list back to employeedata.txt
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employeedata.txt"))) {
            oos.writeObject(employees);
            System.out.println("Serialized updated employee data to employeedata.txt");
        }
    }
}
