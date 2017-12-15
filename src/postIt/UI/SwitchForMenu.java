package postIt.UI;

import postIt.Gender;
import postIt.Role;
import postIt.Statistics.StaffStatistics;
import postIt.Staff.ITSupport;
import postIt.Staff.VicePresident;
import postIt.Staff.Developer;
import postIt.Staff.Employee;
import postIt.Staff.BuildingTechnician;
import postIt.Staff.BookKeeper;
import postIt.StaffList;
import postIt.WrongOptionException;
import static postIt.UI.UI.*;

public class SwitchForMenu {

    public static void switchMainMenu(int op) {

        switch (op) {
            case 1:
                employeeMenu();
                break;
            case 2:
                statisticMenu();
                break;
            case 3:
                System.out.println("Thank you, see you next time! =)");
                break;
            default:
                System.out.println("Wrong input, try again!\n");
                break;
        }
    }

    public static void updateEmployee(Employee employee, int input1) {

        sc.nextLine();
        switch (input1) {
            case 1:
                System.out.println("Add updated surname: ");
                String sn = sc.nextLine();
                employee.setSurName(sn);
                break;
            case 2:
                System.out.println("Add updated first name: ");
                String fn = sc.nextLine();
                employee.setFirstName(fn);
                break;
            case 3:
                System.out.println("Add updated address: ");
                String ad = sc.nextLine();
                employee.setAddress(ad);
                break;
            case 4:
                System.out.println("Add updated personal number: ");
                String pn = sc.nextLine();
                employee.setPersonalNumber(pn);
                break;
            case 5:
                System.out.println("Add updated gender:");
                employee.setGender(genderMenu());
                break;
            case 6:
                System.out.println("Add updated salary: ");
                double sa = sc.nextDouble();
                employee.setSalary(sa);
                break;
            case 7:
                Role role = menuRole();
                employee.setRole(role);
                break;
            default:
                System.out.println("Not a valid choice");
        }
        System.out.println("Employee updated!!!");
    }

    public static void statisticSwish(int op, StaffList staff) throws WrongOptionException {

        Role role;
        int[] genderDistribution;
        StaffStatistics staffStat = staff.getStaffStatistic();
        switch (op) {
            case 1:
                System.out.println("The highest salary overall is: " + staffStat.highestSalaryOverall());
                System.out.println();
                break;
            case 2:
                role = menuRole();
                System.out.println("The highest salary for: " + role.getRoleName() + " is: " + staffStat.highestSalaryRole(role));
                System.out.println();
                break;
            case 3:
                System.out.println("The lowest salary overall is: " + staffStat.lowestSalaryOverall());
                System.out.println();
                break;
            case 4:
                role = menuRole();
                System.out.println("The lowest salary for: " + role.getRoleName() + " is: " + staffStat.lowestSalaryRole(role));
                System.out.println();
                break;
            case 5:
                genderDistribution = staffStat.genderDistributionOverall();
                printGenderDistribution(genderDistribution);
                System.out.println();
                break;
            case 6:
                role = menuRole();
                genderDistribution = staffStat.genderDistributionByRole(role);
                System.out.println("For the position: " + role.getRoleName() + " this is the distribution: ");
                printGenderDistribution(genderDistribution);
                System.out.println();
                break;
            case 7:
                System.out.println("The total amount of bonus for all employee in the company is: " + staffStat.bonusOverall());
                System.out.println();
                break;
            case 8:
                role = menuRole();
                System.out.println("The total bonus for the position of " + role.getRoleName() + " is: " + staffStat.bonusByRole(role));
                System.out.println();
                break;
            case 9:
                break;
            default:
                throw new WrongOptionException();
        }
    }

    public static void switchEmployeeMenu(int op, StaffList staff) {
            switch (op) {
                case 1:
                    UI.employeeMenuAdd();
                    break;
                case 2:
                    UI.removeEmployeeUI();
                    break;
                case 3:
                    UI.updateEmployeeUI();
                    break;
                case 4:
                    UI.findEmployeeUI();
                    break;
                case 5:
                    System.out.println(staff);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Wrong input, try again!\n");
                    break;
        }
    }

    public static Role swishRoleMenu(int op) throws WrongOptionException{
        switch (op) {
            case 1:
                return new VicePresident();
            case 2:
                return new Developer();
            case 3:
                return new ITSupport();
            case 4:
                return new BookKeeper();
            case 5:
                return new BuildingTechnician();
            default:
                throw new WrongOptionException();
        }
    }

    public static Gender swishGenderMenu(int op){
        switch (op) {
            case 1:
                return Gender.FEMALE;
            case 2:
                return Gender.MALE;
            case 3:
                return Gender.OTHER;
            default:
                break;
        }
        return null;
    }

    private static void printGenderDistribution(int[] genderDistribution) {
        System.out.println(Gender.genderFemale()+": " + genderDistribution[0]);
        System.out.println(Gender.genderMale() + ": " +  genderDistribution[1]);
        System.out.println(Gender.genderOther() + ": " +  genderDistribution[2]);
    }
}
