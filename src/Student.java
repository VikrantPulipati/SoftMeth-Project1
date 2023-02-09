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
    public void setMajor(String majorString) { // I don't think I wrote this method the way they want me to. I just didn't know how else to do it.
        if (majorString.equals("CS")) {
            major = Major.CS;
        } else if (majorString.equals("MATH")) {
            major = Major.MATH;
        } else if (majorString.equals("EE")) {
            major = Major.EE;
        } else if (majorString.equals("ITI")) {
            major = Major.ITI;
        } else if (majorString.equals("BAIT")) {
            major = Major.BAIT;
        }
    }
    public void setCredits(int creditsCompleted) {
        this.creditsCompleted = creditsCompleted;
    }
    @Override
    public int compareTo(Student student) {
        if (this.profile.getLname().compareTo(student.profile.getLname()) > 0) {
            return 1;
        }
        else if (this.profile.getLname().compareTo(student.profile.getLname()) < 0) {
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