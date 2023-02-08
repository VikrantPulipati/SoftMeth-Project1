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
    public int returnCredits() {
        return this.creditsCompleted;
    }
    public void setProfile(Profile profile) {
        this.profile = profile;
    }
    public void setMajor(String majorString) {
        //Major major = new Major(majorString);
        this.major = major;
    }
    public void setCredits(int creditsCompleted) {
        this.creditsCompleted = creditsCompleted;
    }
    @Override
    public int compareTo(Student student) {
        return 0;
    }
    @Override
    public String toString() {
        return "fuck u";
    }

    public int equals(Student student) {
        return 0;
    }
}