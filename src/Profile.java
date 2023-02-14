public class Profile implements Comparable<Profile> {

    private final String fname;
    private final String lname;
    private final Date dob;

    public Profile (String fname, String lname, Date dob) {
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
    }

    public String getFname() {
        return this.fname;
    }

    public String getLname() {
        return this.lname;
    }

    public Date getDOB() {
        return this.dob;
    }

    @Override
    public int compareTo(Profile profile) {
        if (this.lname.compareTo(profile.lname) > 0) {
            return 1;
        }
        if (this.lname.compareTo(profile.lname) < 0) {
            return -1;
        }
        if (this.fname.compareTo(profile.fname) > 0) {
            return 1;
        }
        if (this.fname.compareTo(profile.fname) < 0) {
            return -1;
        }
        return Integer.compare(this.dob.compareTo(profile.dob), 0);
    }
    @Override
    public String toString() {
        return fname + " " + lname + " " + dob.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Profile other)) return false;
        return (this.fname.equalsIgnoreCase(other.getFname())) &&
                (this.lname.equalsIgnoreCase(other.getLname())) &&
                (this.dob.equals(other.getDOB()));
    }
}