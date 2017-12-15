package postIt.Staff;

import postIt.Role;

public class BuildingTechnician extends Role{
    
    private double bonus = 0; //Or no variable at all?

    
    public double calculateBonus(double salary) {
       return salary * ((bonus * 0.01));
    }

     @Override
     public String getRoleName(){
         return "Building Technician";
     }
     
    public double getBonus() {
        return bonus;
    }



}