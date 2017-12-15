package postIt.Staff;

import postIt.Role;

public class VicePresident extends Role {

    private double bonus = 20;

    @Override
    public double calculateBonus(double salary) {

        return salary * ((bonus * 0.01));
    }

    public double getBonus() {
        return bonus;
    }

    @Override
    public String getRoleName() {
        return "Vice President";
    }

    @Override
    public String toString() {
        return "The bonus for Vice President is: " + bonus + "% percent.";
    }


}
