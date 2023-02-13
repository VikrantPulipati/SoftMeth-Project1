public class Student implements Comparable<Student> {

    private Profile profile;
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

    public int getCredits() {
        return this.creditCompleted;
    }

    public String getStanding() {
        String standingString;
        if (creditCompleted < 30) {
            standingString = "(Freshman)";
        } else if (creditCompleted < 60) {
            standingString = "(Sophomore)";
        } else if (creditCompleted < 90) {
            standingString = "(Junior)";
        } else {
            standingString = "(Senior)";
        }
        return standingString;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public void setCredits(int creditsCompleted) {
        this.creditCompleted = creditsCompleted;
    }

    @Override
    public int compareTo(Student student) {
        // student compareTo method needs to compare profiles
        // Profile compareTo method compares first name, last name, dob
        return Integer.compare(this.profile.compareTo(student.profile), 0);
    }

    @Override
    public String toString() {
        String majorString = null;
        String standingString;
        switch (major.getMajorName()) {
            case "CS" -> majorString = "(01:198 CS SAS)";
            case "MATH" -> majorString = "(01:640 MATH SAS)";
            case "EE" -> majorString = "(14:332 EE SOE)";
            case "ITI" -> majorString = "(04:547 ITI SC&I)";
            case "BAIT" -> majorString = "(33:136 BAIT RBS)";
        }

        if (creditCompleted < 30) {
            standingString = "(Freshman)";
        } else if (creditCompleted < 60) {
            standingString = "(Sophomore)";
        } else if (creditCompleted < 90) {
            standingString = "(Junior)";
        } else {
            standingString = "(Senior)";
        }
        return profile.toString() + " " + majorString + " credits completed: "
                + creditCompleted + " " + standingString;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Student other)) return false;
        return this.profile.equals(other.getProfile());
    }
}