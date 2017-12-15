package postIt;

import postIt.UI.EmployeeFormatter;
import postIt.Statistics.StaffStatistics;
import postIt.Staff.Employee;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the data base manager for the staff
 */
public class StaffList {

    //List of employees
    private ArrayList<Employee> employees;
    //read from the command line
    private static Scanner sc;

    /**
     * Constructor for the staff
     */
    public StaffList() {
        employees = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    /**
     * @return an object Statistic with one can be manager the statistics
     */
    public StaffStatistics getStaffStatistic() {
        return new StaffStatistics(employees);
    }

    /**
     * Add an employee in the list of employees
     *
     * @param employee which will be add to the list
     */
    public void addToStaffList(Employee employee) {
        employees.add(employee);
    }

    /**
     * Take one employee and erase from the list of employees
     */
    public void deleteEmployee(Employee employee) {
        employees.remove(employee);
    }

    /**
     * Find a employee by the surname
     *
     * @param surName the surname of the employee
     * @return the employee which is found
     * @throws EmployeeNoyFoundException if the employee is not found
     */
    public Employee getEmployeeSurName(Employee surName) throws EmployeeNoyFoundException {

        for (Employee employee : employees) {
            if (employee.getSurName().equals(surName)) {
                return employee;
            }
        }
        throw new EmployeeNoyFoundException();
    }

    /**
     * Find a employee by its ID
     *
     * @param id the id of the employee
     * @return the employee which is found
     * @throws EmployeeNoyFoundException
     */
    public Employee getEmployee(int id) throws EmployeeNoyFoundException {

        for (Employee employee : employees) {
            if (employee.getStaffId() == id) {
                return employee;
            }
        }
        throw new EmployeeNoyFoundException();
    }

    /**
     *
     * @return a string with the complete list of all employees
     */
    @Override
    public String toString() {
        return EmployeeFormatter.format(this.employees);
    }


}
