package postIt.UI;

import postIt.Statistics.StaffStatistics;
import postIt.Staff.ITSupport;
import postIt.Staff.VicePresident;
import postIt.Staff.Developer;
import postIt.Staff.BuildingTechnician;
import postIt.Staff.BookKeeper;
import java.util.Scanner;
import postIt.Gender;
import postIt.Role;
import postIt.WrongOptionException;

public class MenuStatistics {

    static Scanner sc = new Scanner(System.in);

    public static Role menuRole() throws WrongOptionException {
        System.out.println("Select one Role:");
        System.out.println("1.- Vice President");
        System.out.println("2.- Developer");
        System.out.println("3.- IT support");
        System.out.println("4.- Book keeper");
        System.out.println("5.- Building Technician");

        switch (sc.nextInt()) {
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

    public static void statictSwich(int op, StaffStatistics statistic) throws WrongOptionException {

        Role role;
        int[] genderDistribution;

        switch (op) {
            case 1:
                System.out.println("The highest salary overall is: " + statistic.highestSalaryOverall());
                break;
            case 2:
                //Make the method menuRole()
                role = menuRole();
                System.out.println("The highest salary for: " + role.getRoleName() + " is: " + statistic.highestSalaryRole(role));
                break;
            case 3:
                System.out.println("The lowest salary overall is: " + statistic.lowestSalaryOverall());
                break;
            case 4:
                //Make the method menuRole()
                role = menuRole();
                System.out.println("The lowest salary for: " + role.getRoleName() + " is: " + statistic.highestSalaryRole(role));
                break;
            case 5:
                genderDistribution = statistic.genderDistributionOverall();
                System.out.println(Gender.genderFemale() + genderDistribution[0]);
                System.out.println(Gender.genderMale() + genderDistribution[1]);
                System.out.println(Gender.genderOther() + genderDistribution[2]);
                break;
            case 6:
                role = menuRole();
                genderDistribution = statistic.genderDistributionByRole(role);
                System.out.println("For the position: " + role.getRoleName() + " this is the distribution: ");
                System.out.println(Gender.genderFemale() + genderDistribution[0]);
                System.out.println(Gender.genderMale() + genderDistribution[1]);
                System.out.println(Gender.genderOther() + genderDistribution[2]);
                break;
            case 7:
                System.out.println("The total amount of bonus for all employee in the company is: " + statistic.bonusOverall());
                break;
            case 8:
                role = menuRole();
                System.out.println("The total bonus for the position of " + role.getRoleName() + " is: " + statistic.bonusByRole(role));
                break;
            case 9:
                //
                break;
            default:
                throw new WrongOptionException();
        }
    }

    public int statisticMenu() {
        System.out.println("What would you like to do? Choose a number below:");
        System.out.println("1. Show highest salary in company.");
        System.out.println("2. Show highest salary for a certain role."); // What role? - pick one
        System.out.println("3. Show lowest salary in company.");
        System.out.println("4. Show lowest salary for a certain role."); // What role? - pick one
        System.out.println("5. Show gender distribution in the company.");
        System.out.println("6. Show gender distribution per role.");
        System.out.println("7. Show total amount of bonus for all employees in the company.");
        System.out.println("8. Show bonus for a certain role in the company."); // What role? - pick one
        System.out.println("9. Go back to main menu.");

        return sc.nextInt();
        //Switch
    }

}
