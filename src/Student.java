public class Student implements Comparable<Student> {
    private Profile profile;
    private Major major;
    private int creditsCompleted;

    public Profile getProfile() {
        return this.profile;
    }
    public Major getMajor() {
        return this.major;
    }
    public int getCredits() {
        return this.creditsCompleted;
    }
    public void setProfile(Profile profile) {
        this.profile = profile;
    }
    public void setMajor(String majorString) {
        Major newMajor = Major.getMajorFromString(majorString);
        if (newMajor == null) {
            System.out.println("Major code invalid: " + majorString);
        } else {
            this.major = newMajor;
        }
    }
    public void setCredits(int creditsCompleted) {
        if (creditsCompleted < 0) {
            System.out.println("Credits completed invalid: cannot be negative!");
        }
        this.creditsCompleted = creditsCompleted;
    }
    @Override
    public int compareTo(Student student) {
        // student compareTo method needs to compare profiles
        // Profile compareTo method compares first name, last name, dob
        if (this.profile.compareTo(student.profile) > 0) {
            return 1;
        }
        else if (this.profile.compareTo(student.profile) < 0) {
            return -1;
        }
        else {
            return 0;
        }
    }
    @Override
    public String toString() {
        return "fuck u";
    }

    public int equals(Student student) {
        return 0;
    }
}