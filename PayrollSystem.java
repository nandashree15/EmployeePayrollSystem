import java.io.*;
import java.util.*;

public class PayrollSystem {

    static Scanner sc = new Scanner(System.in);
    static final String FILE_NAME = "employees.txt";

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch(choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    displayEmployees();
                    break;
                case 3:
                    searchEmployee();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        } while(choice != 4);
    }

    public static void addEmployee() {
        try {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Basic Salary: ");
            double salary = sc.nextDouble();

            Employee emp = new Employee(id, name, salary);

            FileWriter fw = new FileWriter(FILE_NAME, true);
            fw.write(emp.toFileString() + "\n");
            fw.close();

            System.out.println("Employee added successfully!");

        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void displayEmployees() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            String line;

            while((line = br.readLine()) != null) {
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                double salary = Double.parseDouble(data[2]);

                Employee emp = new Employee(id, name, salary);
                emp.display(true);
                System.out.println("-------------------");
            }

            br.close();

        } catch(Exception e) {
            System.out.println("No records found.");
        }
    }

    public static void searchEmployee() {
        try {
            System.out.print("Enter ID to search: ");
            int searchId = sc.nextInt();

            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            boolean found = false;

            while((line = br.readLine()) != null) {
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);

                if(id == searchId) {
                    String name = data[1];
                    double salary = Double.parseDouble(data[2]);

                    Employee emp = new Employee(id, name, salary);
                    emp.display(true);
                    found = true;
                    break;
                }
            }

            br.close();

            if(!found) {
                System.out.println("Employee not found!");
            }

        } catch(Exception e) {
            System.out.println("Error searching file.");
        }
   }
}