package postIt.Statistics;

import postIt.Staff.Employee;
import java.util.ArrayList;
import java.util.List;
import postIt.Gender;
import postIt.Role;

/**
 * In this class there are method that calculate the statistics for all the staff
 */
public class StaffStatistics {

    private List<Employee> staff;

    public StaffStatistics(List<Employee> staff) {
        this.staff = staff;
    }

    /**
     * This method get the highest value of the Salary from a employee in the given list
     * @return a double value which represent the Highest Salary in the list
     */
    public double highestSalaryOverall() {
        return getMaxSalary(staff);
    }

    /**
     * This method get the higest value of the Salary from a employee in the given list by Role
     * @param role this one is use as criteria for the search
     * @return a double value which represent the Highest Salary in the list by the Role
     */
    public double highestSalaryRole(Role role) {

        List<Employee> employeesByRole = getEmployeesListByRole(role);
        return getMaxSalary(employeesByRole);
    }

    /**
     * This method get the lowest value of the Salary from a employee in the given list
     * @return a double value which represent the lowest Salary in the list
     */
    public double lowestSalaryOverall() {
        return getMinSalary(staff);
    }

    /**
     * This method get the lowest value of the Salary from a employee in the given list by Roles
     * @param role this one is use as criteria for the search
     * @return a double value which represent the Lowest Salary in the list by the Role
     */
    public double lowestSalaryRole(Role role) {
        List<Employee> employeesByRole = getEmployeesListByRole(role);
        return getMinSalary(employeesByRole);
    }

    /**
     * This method is used to search the minimal salary in the list of employees
     * @return a double value which represent the lowest salary in the list
     */
    private double getMinSalary(List<Employee> list) {

        double minSalary = Integer.MAX_VALUE;
        for (Employee e : list) {
            if (e.getSalary() < minSalary) {
                minSalary = e.getSalary();
            }
        }
        return minSalary;
    }

    /**
     * This method is used to search the maximal salary in the list of employees
     * @return a double value which represent the highest salary in the list
     */
    private double getMaxSalary(List<Employee> list) {
        double maxSalary = 0.0;
        for (Employee e : list) {
            if (e.getSalary() > maxSalary) {
                maxSalary = e.getSalary();
            }
        }
        return maxSalary;
    }

    /**
     * This method take a list which have all the employees and build a new list with all the
     * employees whose role are the same
     * @param role this one is use as criteria for the search
     * @return a list with all the employees by the specific role
     */
    private List<Employee> getEmployeesListByRole( Role role) {
        List<Employee> employeesByRole = new ArrayList<>();
        for (Employee e : staff) {
            if (e.getRole().getClass().equals(role.getClass())) {
                employeesByRole.add(e);
            }
        }
        return employeesByRole;
    }

    /**
     * This is the distribution of Gender between all the staff
     * @return a Array of three int which represent first FEMALE, second MALE and third OTHER
     */
    public int[] genderDistributionOverall(){
        int[] genderDistribution = new int[]{0,0,0};

        for (Employee e: staff) {
            Gender gender = e.getGender();
            if (gender == Gender.FEMALE){
                genderDistribution[0]++;
            }else if (gender == Gender.MALE){
                genderDistribution[1]++;
            }else {
                genderDistribution[2]++;
            }
        }
        return genderDistribution;
    }

    /**
     * This is the distribution of the Gender by a specific Role
     * @return a Array of three int which represent first FEMALE, second MALE and third OTHER
     */
    public int[] genderDistributionByRole(Role role){
        int[] genderDistribution = new int[]{0,0,0};

        List<Employee> listByRole = getEmployeesListByRole(role);

        for (Employee e: listByRole) {
            Gender gender = e.getGender();
            if (gender == Gender.FEMALE){
                genderDistribution[0]++;
            }else if (gender == Gender.MALE){
                genderDistribution[1]++;
            }else {
                genderDistribution[2]++;
            }
        }
        return genderDistribution;
    }

    /**
     * @return The amount of the total Bonus which will be paid between the staff
     */
    public double bonusOverall(){

        double bonusTotal = 0.0;
        for (Employee e: staff) {
            Role r = e.getRole();
            bonusTotal += r.calculateBonus(e.getSalary());
        }
        return bonusTotal;
    }

    /**
     * @return The amount of the total Bonus which will be paid by a specific Role
     */
    public double bonusByRole(Role role){

        List<Employee> list = getEmployeesListByRole(role);
        double bonusTotal = 0.0;
        for (Employee e: list) {
            Role r = e.getRole();
            bonusTotal += r.calculateBonus(e.getSalary());
        }
        return bonusTotal;
    }

    //TODO create a method
    public void printLongestEmployee(){

        Employee longestEmployee;
        for (Employee e: staff) {

        }

    }
}
