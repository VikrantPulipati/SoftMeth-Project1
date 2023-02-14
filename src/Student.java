/**
 * This class holds biographical and academic data for every student in the Roster.
 * @author Vikrant Pulipati, Gabe Ruszala
 */
public class Student implements Comparable<Student> {

    public static final String FRESHMAN = "(Freshman)";
    public static final String SOPHOMORE = "(Sophomore)";
    public static final String JUNIOR = "(Junior)";
    public static final String SENIOR = "(Senior)";

    private final Profile profile;
    private Major major;
    private int creditCompleted;

    /**
     * Create a complete Student object with all biographical and academic information included.
     * @param profile holds Student's first name, last name and date of birth.
     * @param major holds the Student's major, major code and school.
     * @param creditCompleted the number of credits the Student has completed thus far.
     */
    public Student (Profile profile, Major major, int creditCompleted) {
        this.profile = profile;
        this.major = major;
        this.creditCompleted = creditCompleted;
    }

    /**
     * Create a partial Student object with only biographical information.
     * Primarily used to create a dummy Student object to pass as a parameter to methods that only use Student's Profile.
     * @param profile holds the Student's first name, last name and date of birth.
     */
    public Student (Profile profile) {
        this.profile = profile;
    }

    /**
     * Fetches the Student's profile.
     * @return profile.
     */
    public Profile getProfile() {
        return this.profile;
    }

    /**
     * Fetches the Student's Major.
     * @return major.
     */
    public Major getMajor() {
        return this.major;
    }

    /**
     * Returns the class level of the Student based on their completed credits.
     * FRESHMAN if under 30 credits completed, SOPHOMORE if under 60, JUNIOR if under 90, and SENIOR otherwise.
     * @return an enum value corresponding to the Student's standing.
     */
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

    /**
     * Sets the Student's major.
     * @param major the new major to be set.
     */
    public void setMajor(Major major) {
        this.major = major;
    }

    /**
     * Compares two students by Last Name, First Name and Date of Birth.
     * @param student the other Student to be compared.
     * @return -1 if this < other, 0 if this == other, 1 if this > other.
     */
    @Override
    public int compareTo(Student student) {
        return Integer.compare(this.profile.compareTo(student.profile), 0);
    }

    /**
     * Provides a String summary of a Student: Profile, Major, Credits Completed and Standing.
     * @return the String described above.
     */
    @Override
    public String toString() {
        return profile + " " + major + " credits completed: "
                + creditCompleted + " " + getStanding();
    }

    /**
     * Two Students are equal if they have the same name and date of birth.
     * @param obj the other Student being compared.
     * @return true if the Students are the same person, false if not.
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Student other)) return false;
        return this.profile.equals(other.getProfile());
    }

    /**
     * Several test cases to test compareTo() method.
     * @param args command line arguments.
     */
    public static void main (String[] args) {
        final String PASSED = "PASSED";
        final String FAILED = "FAILED";

        Student student1 = new Student(new Profile("Roy", "Brooks", new Date("8/8/1999")));
        Student student2 = new Student(new Profile("Roy", "Brooks", new Date("9/9/1999")));
        System.out.println("Test Case 1:\nStudent 1: " + student1.getProfile()
                + "\nStudent 2: " + student2.getProfile());
        System.out.println((student1.compareTo(student2) < 0 ? PASSED: FAILED) + "\n");

        student1 = new Student(new Profile("Roy", "Brooks", new Date("8/8/1999")));
        student2 = new Student(new Profile("Jane", "Doe", new Date("5/1/1996")));
        System.out.println("Test Case 2:\nStudent 1: " + student1.getProfile()
                + "\nStudent 2: " + student2.getProfile());
        System.out.println((student1.compareTo(student2) < 0 ? PASSED: FAILED) + "\n");

        student1 = new Student(new Profile("Kate", "Lindsey", new Date("7/15/2002")));
        student2 = new Student(new Profile("Mary", "Lindsey", new Date("12/1/2001")));
        System.out.println("Test Case 3:\nStudent 1: " + student1.getProfile()
                + "\nStudent 2: " + student2.getProfile());
        System.out.println((student1.compareTo(student2) < 0 ? PASSED: FAILED) + "\n");

        student1 = new Student(new Profile("Roy", "Brooks", new Date("8/8/1999")));
        student2 = new Student(new Profile("Roy", "Brooks", new Date("8/8/1999")));
        System.out.println("Test Case 4:\nStudent 1: " + student1.getProfile()
                + "\nStudent 2: " + student2.getProfile());
        System.out.println((student1.compareTo(student2) == 0 ? PASSED: FAILED) + "\n");
    }
}