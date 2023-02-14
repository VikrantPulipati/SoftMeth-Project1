/**
 * The Major class contains m getters, setters, compares, and toString.
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

    Major (String name, String code, String school) {
        this.majorName = name;
        this.majorCode = code;
        this.school = school;
    }

    public String getMajorName () {
        return this.majorName;
    }

    public String getSchool() {
        return school;
    }

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

    public int compare (Major other) {
        if (this.school.compareTo(other.getSchool()) < 0) return -1;
        if (this.school.compareTo(other.getSchool()) > 0) return 1;
        return Integer.compare(this.majorName.compareTo(other.getMajorName()), 0);
    }

    @Override
    public String toString() {
        return "(" + majorCode + " " + majorName + " " + school + ")";
    }
}