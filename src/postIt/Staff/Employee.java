package postIt.Staff;

import java.text.SimpleDateFormat;

import java.util.GregorianCalendar;
import postIt.Gender;

public class Employee {

    private String firstName;
    private String surName;
    private String address;
    private String personalNumber;
    private int staffId;
    private Gender gender;
    private double salary;
    private postIt.Role role;
    private String startDate;
    static int counter = 1;

    public Employee(String firstName, String surName, String address, String personalNumber, Gender gender, double salary, postIt.Role role) {
        this.firstName = firstName;
        this.surName = surName;
        this.address = address;
        this.personalNumber = personalNumber;
        this.gender = gender;
        this.salary = salary;
        this.role = role;
        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        this.startDate = df.format(gc.getTime());
        this.staffId = counter;
        counter++;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurName() {
        return surName;
    }

    public String getAddress() {
        return address;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public int getStaffId() {
        return staffId;
    }

    public Gender getGender() {
        return gender;
    }

    public double getSalary() {
        return salary;
    }

    public postIt.Role getRole() {
        return role;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setRole(postIt.Role role) {
        this.role = role;
    }

}

    


