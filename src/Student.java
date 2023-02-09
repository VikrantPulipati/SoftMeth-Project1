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
    public int setMajor(String majorString) { // I don't think I wrote this method the way they want me to. I just didn't know how else to do it.
        if (majorString.equals("CS")) {
            major = Major.CS;
            return 1;
        } else if (majorString.equals("MATH")) {
            major = Major.MATH;
            return 1;
        } else if (majorString.equals("EE")) {
            major = Major.EE;
            return 1;
        } else if (majorString.equals("ITI")) {
            major = Major.ITI;
            return 1;
        } else if (majorString.equals("BAIT")) {
            major = Major.BAIT;
            return 1;
        } else {
            System.out.println("Major code invalid: " + majorString);
            return 0;
        }
    }
    public void setCredits(int creditsCompleted) {
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