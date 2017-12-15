package postIt;

public abstract class Role {

    /**
     * Calculate how much is the bonus for the specific role
     *
     * @param salary from Employee
     * @return a double with the value of only the bonus with out the salary.
     */
    public abstract double calculateBonus(double salary);

    /**
     *
     * @return the String of the specific role
     */
    public abstract String getRoleName();


}