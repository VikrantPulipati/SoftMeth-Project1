public class Student implements Comparable<Student> {

    public static final String FRESHMAN = "(Freshman)";
    public static final String SOPHOMORE = "(Sophomore)";
    public static final String JUNIOR = "(Junior)";
    public static final String SENIOR = "(Senior)";

    private final Profile profile;
    private Major major;
    private int creditCompleted;

    public Student (Profile profile, Major major, int creditCompleted) {
        this.profile = profile;
        this.major = major;
        this.creditCompleted = creditCompleted;
    }

    public Student (Profile profile) {
        this.profile = profile;
    }

    public Profile getProfile() {
        return this.profile;
    }

    public Major getMajor() {
        return this.major;
    }

    public String getStanding() {
        if (creditCompleted < 30) {
            return FRESHMAN;
        } else if (creditCompleted < 60) {
            return SOPHOMORE;
        } else if (creditCompleted < 90) {
            return JUNIOR;
        } else {
            return SENIOR;
        }
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    @Override
    public int compareTo(Student student) {
        // student compareTo method needs to compare profiles
        // Profile compareTo method compares first name, last name, dob
        return Integer.compare(this.profile.compareTo(student.profile), 0);
    }

    @Override
    public String toString() {
        return profile + " " + major + " credits completed: "
                + creditCompleted + " " + getStanding();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Student other)) return false;
        return this.profile.equals(other.getProfile());
    }
}