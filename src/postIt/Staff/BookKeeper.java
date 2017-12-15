package postIt.Staff;

import postIt.Role;

/**
 *
 */
public class BookKeeper extends Role {

    private double bonus = 20;

    @Override
    public double calculateBonus(double salary) {

        return salary * ((bonus * 0.01));
    }

    @Override
     public String getRoleName(){
         return "Book Keeper";
     }

    public double getBonus() {
        return bonus;
    }

    @Override
    public String toString() {
        return "The bonus for Book Keeper is: " + bonus + "% percent.";
    }
}