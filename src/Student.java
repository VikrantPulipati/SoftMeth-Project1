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