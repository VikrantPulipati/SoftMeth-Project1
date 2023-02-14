/**
 * The Major enum contains a list of possible majors.
 * Includes the name of the major, the major code and the school with which the major is associated.
 * @author Vikrant Pulipati, Gabe Ruszala
 */
public enum Major {
    BAIT("BAIT", "33:136", "RBS"),
    CS("CS", "01:198", "SAS"),
    MATH("MATH", "01:640", "SAS"),
    ITI("ITI", "04:547", "SC&I"),
    EE("EE", "14:332", "SOE");

    private final String majorName;
    private final String majorCode;
    private final String school;

    /**
     *
     * @param name the name of the major.
     * @param code {School Code}:{Major Code}.
     * @param school the name of the school associated with the major.
     */
    Major (String name, String code, String school) {
        this.majorName = name;
        this.majorCode = code;
        this.school = school;
    }

    /**
     * Fetches the name of the major.
     * @return major name.
     */
    public String getMajorName () {
        return this.majorName;
    }

    /**
     * Fetches the name of the school associated with the major.
     * @return school name.
     */
    public String getSchool() {
        return school;
    }

    /**
     * Converts a major's name into its corresponding enum.
     * For example: getMajorFromString("CS") will return Major.CS.
     * @param name the name of the major as a String.
     * @return the Major enum corresponding to the String name.
     */
    public static Major getMajorFromString (String name) {
        name = name.toUpperCase();
        return switch (name) {
            case "CS" -> CS;
            case "MATH" -> MATH;
            case "EE" -> EE;
            case "ITI" -> ITI;
            case "BAIT" -> BAIT;
            default -> null;
        };
    }

    /**
     * A method which compares two Majors according to school name and major name.
     * Compares lexically in the following order: school name, major name.
     * @param other the other Major being compared.
     * @return -1 if this < other, 0 if this == other, 1 if this > other.
     */
    public int compare (Major other) {
        if (this.school.compareTo(other.getSchool()) < 0) return -1;
        if (this.school.compareTo(other.getSchool()) > 0) return 1;
        return Integer.compare(this.majorName.compareTo(other.getMajorName()), 0);
    }

    /**
     * Provides a String summary of the Major.
     * @return (majorCode majorName schoolName)
     */
    @Override
    public String toString() {
        return "(" + majorCode + " " + majorName + " " + school + ")";
    }
}