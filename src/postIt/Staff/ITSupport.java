package postIt.Staff;

import postIt.Role;

public class ITSupport extends Role {

    private double bonus = 20;

    @Override
    public double calculateBonus(double salary) {

        return salary * ((bonus * 0.01));
    }

    @Override
    public String getRoleName() {
        return "IT Support";
    }

    public double getBonus() {
        return bonus;
    }

    @Override
    public String toString() {
        return "The bonus for It Suport is: " + bonus + "% percent.";
    }

}
    