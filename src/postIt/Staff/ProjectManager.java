package postIt.Staff;

import postIt.Role;

public class ProjectManager extends Role {

    private double bonus = 20;

    @Override
    public double calculateBonus(double salary) {
        return salary * ((bonus * 0.01) + 1);
    }

    @Override
    public String getRoleName() {
        return "Project Manager";
    }

    public double getBonus() {
        return bonus;
    }

    @Override
    public String toString() {
        return "The bonus for Project Manager is: " + bonus + "% percent.";
    }


}