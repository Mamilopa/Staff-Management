package postIt.Staff;

import postIt.Role;

public class Developer extends Role {

    private double bonus = 60;

    @Override
    public double calculateBonus(double salary) {

        return salary * ((bonus * 0.01));
    }

    @Override
    public String getRoleName() {
        return "Developer";
    }

    public double getBonus() {
        return bonus;
    }

    @Override
    public String toString() {
        return "The bonus for Developer is: " + bonus + "% percent.";
    }


}