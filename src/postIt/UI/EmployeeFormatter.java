package postIt.UI;

import postIt.Staff.Employee;
import java.util.List;

public class EmployeeFormatter {

    public static String format(Employee employee) {
        String header = header();
        StringBuilder sb = new StringBuilder();
        sb.append(header).append('\n');
        sb.append(formatWithoutBorder(employee)).append('\n');
        sb.append(footer());
        return sb.toString();

    }

    public static String format(List<Employee> employees) {

        String header = header();
        StringBuilder sb = new StringBuilder();
        sb.append(header).append('\n');
        for (Employee employee : employees) {
            sb.append(formatWithoutBorder(employee)).append('\n');
        }
        sb.append(footer());
        return sb.toString() ;
    }

    public static String formatWithoutBorder(Employee employee) {
        return String.format("| %-4s | %-13s | %-11s | %-15s | %-19s | %-8s | %12.2f | %-23s | %-15s |",
               employee.getStaffId(), employee.getFirstName(), employee.getSurName(),
               employee.getAddress(), employee.getPersonalNumber(), employee.getGender(), employee.getSalary(), employee.getRole().getRoleName(), employee.getStartDate());
    }

    public static String footer(){
        return "****************************************************************************************************************************************************\n";
    }

    private static String header(){
        return "****************************************************************************************************************************************************\n"+
                "|  ID  |  First name   |   Surname   |     Address     |   Personal Number   |  Gender  |    Salary    |         Position        |  Starting Date  |\n"+
                "****************************************************************************************************************************************************";
    }
}
