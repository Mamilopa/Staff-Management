package postIt;

/**
 * Class enum in which there are only three valid values
 */
public enum Gender {
    MALE, FEMALE, OTHER;

    /**
     * @return a String with the name of the option
     */
    public static String genderMale(){
        return "Male";
    }

    /**
     * @return a String with the name of the option
     */

    public static String genderFemale(){
        return "Female";
    }

    /**
     * @return a String with the name of the option
     */

    public static String genderOther(){
        return "Other";
    }
}