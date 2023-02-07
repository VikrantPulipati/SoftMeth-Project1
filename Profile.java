public class Profile implements Comparable<Profile> {
    private String fname;
    private String lname;
    private Date dob; // use the Date class described in (f)
    public String getFname() {
        return this.fname;
    }
    public String getLname() {
        return this.lname;
    }
    public Date getDOB() {
        return this.dob;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setDOB(Date dob) {
        this.dob = dob;
    }
    @Override
    public int compareTo(Profile profile) {
        return 0;
    }
    @Override
    public String toString() {
        return "fuck u";
    }
    public int equals(Profile profile) {
        return 0;
    }
}