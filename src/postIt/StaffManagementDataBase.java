package postIt;

import postIt.Staff.ITSupport;
import postIt.Staff.VicePresident;
import postIt.Staff.Developer;
import postIt.Staff.Employee;
import postIt.Staff.BuildingTechnician;
import postIt.Staff.BookKeeper;

public class StaffManagementDataBase {

    public static StaffList initializeDataBase(){

        postIt.Role vp = new VicePresident();
        Employee em1 = new Employee("Pauline", "Risbecker", "Lidingö", "6458345146", Gender.FEMALE, 94500, vp);
        Employee em2 = new Employee("Louise", "Karlsson", "Stockholm", "7498305146", Gender.FEMALE, 123000, vp);
        Employee em3 = new Employee("Bita", "Jabbari", "Linköping", "8457343146", Gender.FEMALE, 145000, vp);
        Employee em4 = new Employee("Anders", "Löfström", "Värmdö", "4458645146", Gender.MALE, 91000, vp);

        postIt.Role dev = new Developer();
        Employee em5 = new Employee("Anna", "Flygare", "Huddinge", "1234566649", Gender.FEMALE, 100000,dev);
        Employee em6 = new Employee("Nils", "Eriksson", "Mjölby", "4534566649", Gender.OTHER, 50000,dev);

        postIt.Role bk = new BookKeeper();
        Employee em7 = new Employee("Mariela", "Roldan", "Stockholm", "6731266562", Gender.FEMALE, 55000,bk);
        Employee em8 = new Employee("Mathilda", "Kim", "Lidingö", "0931265574", Gender.FEMALE, 45000,bk);

        postIt.Role it = new ITSupport();
        Employee em9 = new Employee("Jagoda", "Cubrilo", "Stockholm", "1567123656", Gender.FEMALE, 58000,it);
        Employee em10 = new Employee("Ana", "Gonzalez", "Stockholm", "5488715146", Gender.FEMALE, 158000,it);

        postIt.Role bt = new BuildingTechnician();
        Employee em11 = new Employee("Santiago", "Arape", "Enköping", "5234235146", Gender.MALE, 26000,bt);
        Employee em12 = new Employee("Nelson", "Arape", "Enköping", "6546225146", Gender.MALE, 32000,bt);

        StaffList list = new StaffList();

        list.addToStaffList(em1);
        list.addToStaffList(em2);
        list.addToStaffList(em3);
        list.addToStaffList(em4);
        list.addToStaffList(em5);
        list.addToStaffList(em6);
        list.addToStaffList(em7);
        list.addToStaffList(em8);
        list.addToStaffList(em9);
        list.addToStaffList(em10);
        list.addToStaffList(em11);
        list.addToStaffList(em12);


        return list;
    }
}