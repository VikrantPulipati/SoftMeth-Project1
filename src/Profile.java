/**
 * This class holds biographical information associated with each Student.
 * Contains first name, last name and date of birth.
 * @author Vikrant Pulipati. Gabe Ruszala
 */
public class Profile implements Comparable<Profile> {

    private final String fname;
    private final String lname;
    private final Date dob;

    /**
     * Creates a Profile object with the provided biographical details.
     * @param fname the Student's first name.
     * @param lname the Student's last name.
     * @param dob the Student's date of birth.
     */
    public Profile (String fname, String lname, Date dob) {
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
    }

    /**
     * Fetches the Student's first name.
     * @return first name.
     */
    public String getFname() {
        return this.fname;
    }

    /**
     * Fetches the Student's last name.
     * @return last name.
     */
    public String getLname() {
        return this.lname;
    }

    /**
     * Fetches the Student's date of birth.
     * @return date of birth.
     */
    public Date getDOB() {
        return this.dob;
    }

    /**
     * Compares two Profiles by Last Name, First Name and Date of Birth.
     * @param profile the other Profile to be compared.
     * @return -1 if this < other, 0 if this == other, and 1  if this > other.
     */
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

    /**
     * Provides a String summary of the Profile.
     * @return a String containing first name, last name and date of birth.
     */
    @Override
    public String toString() {
        return fname + " " + lname + " " + dob.toString();
    }

    /**
     * Two Profiles are equal if they have the same name and date of birth.
     * @param obj the other Profile to be compared.
     * @return true if the Profiles are the same, false if not.
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Profile other)) return false;
        return (this.fname.equalsIgnoreCase(other.getFname())) &&
                (this.lname.equalsIgnoreCase(other.getLname())) &&
                (this.dob.equals(other.getDOB()));
    }
}