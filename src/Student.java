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
    public String getStanding() {
        String standingString = "";
        if (creditsCompleted < 30) {
            standingString = "(Freshman)";
        } else if (creditsCompleted < 60) {
            standingString = "(Sophomore)";
        } else if (creditsCompleted < 90) {
            standingString = "(Junior)";
        } else {
            standingString = "(Senior)";
        }
        return standingString;
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
        String majorString = "";
        String standingString = "";
        if (major.getMajorName().equals("CS")) {
            majorString = "(01:198 CS SAS)";
        } else if (major.getMajorName().equals("MATH")) {
            majorString = "(01:640 MATH SAS)";
        } else if (major.getMajorName().equals("EE")) {
            majorString = "(14:332 EE SOE)";
        } else if (major.getMajorName().equals("ITI")) {
            majorString = "(04:547 ITI SC&I)";
        } else if (major.getMajorName().equals("BAIT")) {
            majorString = "(33:136 BAIT RBS)";
        }

        if (creditsCompleted < 30) {
            standingString = "(Freshman)";
        } else if (creditsCompleted < 60) {
            standingString = "(Sophomore)";
        } else if (creditsCompleted < 90) {
            standingString = "(Junior)";
        } else {
            standingString = "(Senior)";
        }
        return profile.toString() + " " + majorString + " credits completed: " + creditsCompleted + " " + standingString;
    }

    public int equals(Student student) {
        return 0;
    }
}