package postIt.UI;

import postIt.Staff.Employee;
import java.util.InputMismatchException;
import java.util.Scanner;

import postIt.EmployeeNoyFoundException;
import postIt.Gender;
import postIt.Role;
import postIt.StaffList;
import postIt.StaffManagementDataBase;
import postIt.WrongOptionException;
import static postIt.UI.EmployeeFormatter.*;

public class UI {

    static Scanner sc = new Scanner(System.in);
    private static StaffList staff;

    public static void mainMenu() {
        int op = -1;
        staff = StaffManagementDataBase.initializeDataBase();
        do {
            try {
                System.out.println("********************************");
                System.out.println("           MAIN MENU            ");
                System.out.println("********************************");
                System.out.println("What would you like to do today?");
                System.out.println("    1.- Access the staff list");
                System.out.println("    2.- Statistics");
                System.out.println("    3.- Exit the program");
                System.out.println("********************************");
                System.out.print("Insert your option: ");
                op = sc.nextInt();
                SwitchForMenu.switchMainMenu(op);
                sc.nextLine();

            } catch (InputMismatchException e) {
                errorInputMessage();
            }
        } while (op != 3);

    }

    public static void employeeMenu() {
        int op = -1;
        do {
            try {
                System.out.println("*****************************************************");
                System.out.println("                    Employee Menu          ");
                System.out.println("*****************************************************");
                System.out.println("What would you like to do? Choose a number below:");
                System.out.println("   1.- Add an employee.");
                System.out.println("   2.- Remove an employee by employee ID");
                System.out.println("   3.- Update the information about an employee.");//switch for choice
                System.out.println("   4.- Find an employee with staff ID.");//menu id or name?
                System.out.println("   5.- Show all employees.");
                System.out.println("   6.- Go back to main menu.");
                System.out.print("       Insert your option: ");
                op = sc.nextInt();
                SwitchForMenu.switchEmployeeMenu(op, staff);
                System.out.print("");
            } catch (InputMismatchException e) {
                errorInputMessage();
            }
        } while (op != 6);
    }

    public static void statisticMenu() {
        int op = -1;
        do {
            try {
                System.out.println("********************************************************");
                System.out.println("                    Statistic Menu          ");
                System.out.println("********************************************************");
                System.out.println(" What would you like to do? Choose a number below: ");
                System.out.println("     1.- Show highest salary in company.");
                System.out.println("     2.- Show highest salary for a certain role."); // What role? - pick one
                System.out.println("     3.- Show lowest salary in company.");
                System.out.println("     4.- Show lowest salary for a certain role."); // What role? - pick one
                System.out.println("     5.- Show gender distribution in the company.");
                System.out.println("     6.- Show gender distribution per role.");
                System.out.println("     7.- Show total amount of bonus for all employees in the company.");
                System.out.println("     8.- Show bonus for a certain role in the company."); // What role? - pick one
                System.out.println("     9.- Go back to main menu.");
                System.out.print("Insert your option: ");
                op = sc.nextInt();
                SwitchForMenu.statisticSwish(op, staff);
            } catch (InputMismatchException e) {
                errorInputMessage();
            } catch (WrongOptionException e) {

            }
        } while (op != 9);
    }

    public static void employeeMenuAdd() {
        sc.nextLine();
        System.out.println("*******************************************");
        System.out.println("|  Insert the employee information here:  |");
        System.out.println("*******************************************");
        System.out.println("First name: ");
        String name = sc.nextLine();
        System.out.println("Surname: ");
        String surname = sc.nextLine();
        System.out.println("Address: ");
        String address = sc.nextLine();
        System.out.println("Personal number: ");
        String pn = sc.nextLine();
        double salary = 0.0;
        do {
            System.out.println("Salary: ");
            try {
                salary = sc.nextDouble();
                break;
            } catch (InputMismatchException e) {
                errorInputMessage();
            }
        } while (true);
        sc.nextLine();
        Gender gender = genderMenu();
        Role role = menuRole();
        Employee employee = new Employee(name, surname, address, pn, gender, salary, role);
        staff.addToStaffList(employee);
        System.out.println(format(employee));
        System.out.println("****Employee added to the Data Base!!!****");
        System.out.println();
    }

    public static Gender genderMenu() {
        boolean cont = true;
        int op = -1;
        do {
            try {
                System.out.println("*******************************************");
                System.out.println("                 Gender: ");
                System.out.println("*******************************************");
                System.out.println("                1.- Female");
                System.out.println("                2.- Male");
                System.out.println("                3.- Other");
                System.out.println("*******************************************");
                System.out.print("                   Select one: ");
                op = sc.nextInt();
                cont = false;
            } catch (InputMismatchException e) {
                errorInputMessage();
            }
        } while (cont);

        return SwitchForMenu.swishGenderMenu(op);
    }

    public static void findEmployeeUI() {
        try {
            System.out.println("*********************************************************************");
            System.out.println("|  Which employee would you like to find? Please input employee id: |");
            System.out.println("*********************************************************************");
            int id = sc.nextInt();
            Employee employee;
            sc.nextLine();
            employee = staff.getEmployee(id);
            System.out.println("****Employee found!!!****");
            System.out.println(format(employee));
        } catch (InputMismatchException e) {
            errorInputMessage();
        } catch (EmployeeNoyFoundException e) {
            System.out.println(e);
        }
    }

    public static void removeEmployeeUI() {
        try {
            System.out.println("***********************************************************************");
            System.out.println("|  Which employee would you like to remove? Please input employee id: |");
            System.out.println("***********************************************************************");
            int id = sc.nextInt();
            Employee employee;
            sc.nextLine();
            employee = staff.getEmployee(id);
            System.out.println(format(employee));
            System.out.println("****Are you sure you want to remove this employee? y/n****");
            String answer = sc.nextLine();
            if (answer.equalsIgnoreCase("y")) {
                staff.deleteEmployee(employee);
            }
            System.out.println("****Employee removed!!!****");
            System.out.println();
        } catch (InputMismatchException e) {
            errorInputMessage();
        } catch (EmployeeNoyFoundException e) {
            System.out.println(e);
        }
    }

    public static void updateEmployeeUI() {
        System.out.println("***********************************************************************");
        System.out.println("|  Which employee would you like to update? Please input employee id: |");
        System.out.println("***********************************************************************");
        try {
            int id = sc.nextInt();
            Employee employee;
            employee = staff.getEmployee(id);
            System.out.println(format(employee));
            System.out.println();
            int op = updateEmployeeMenu();
            SwitchForMenu.updateEmployee(employee, op);
        } catch (InputMismatchException e) {
            errorInputMessage();
        } catch (EmployeeNoyFoundException e) {
            System.out.println(e);
        }
    }

    public static int updateEmployeeMenu() {
        int op = -1;
        boolean cont = true;
        do {
            try {
                System.out.println("*****************************************");
                System.out.println("  Which field would you like to update?");
                System.out.println("*****************************************");
                System.out.println("     1.- Surname");
                System.out.println("     2.- First name");
                System.out.println("     3.- Address");
                System.out.println("     4.- Personal number");
                System.out.println("     5.- Gender");
                System.out.println("     6.- Salary");
                System.out.println("     7.- Role");
                System.out.println("*****************************************");
                System.out.print("    Select one: ");
                op = sc.nextInt();
                cont = false;
            } catch (InputMismatchException e) {
                errorInputMessage();
            }
        } while (cont);
        return op;
    }

    public static Role menuRole() {
        boolean cont = true;
        Role role = null;
        do {
            try {
                System.out.println("*******************************************");
                System.out.println("                   Role:");
                System.out.println("*******************************************");
                System.out.println("          1.- Vice President");
                System.out.println("          2.- Developer");
                System.out.println("          3.- IT support");
                System.out.println("          4.- Book keeper");
                System.out.println("          5.- Building Technician");
                System.out.println("*******************************************");
                System.out.print("          Select one: ");

                int op = sc.nextInt();
                role = SwitchForMenu.swishRoleMenu(op);
                cont = false;
            } catch (InputMismatchException e) {
                errorInputMessage();
            }catch (WrongOptionException e){
                errorInputMessage();
            }
        } while (cont);
        return role;
    }

    private static void errorInputMessage() {

        System.err.println("Wrong input. Please try again ");
        System.out.println();
        sc.nextLine();
    }
}
