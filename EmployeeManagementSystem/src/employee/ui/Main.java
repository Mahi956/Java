package employee.ui;

import employee.dao.EmployeeDAO;
import employee.model.Employee;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EmployeeDAO dao = new EmployeeDAO();

        while (true) {

            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Exit");

            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String department = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();

                    Employee employee =
                            new Employee(name, department, salary);

                    dao.addEmployee(employee);

                    break;

                case 2:

                    dao.viewEmployees();

                    break;

                case 3:

                    System.out.println("Thank You!");
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice");
            }
        }
    }
}