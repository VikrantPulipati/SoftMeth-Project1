public class Roster {
    private Student[] roster = new Student[4];
    private int size = 0;

    public int getSize() {
        return this.size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    private int find(Student student) {
        return 1;
    } // search the given student in roster
    private void grow() { // do we have to copy the old array into a new one that's 4 cells bigger? Kind of inefficient though.

    } // increase the array capacity by 4
    public boolean add(Student student) {
        roster[size] = student;
        size++;
        return true;
    } // add student to end of array
    public boolean remove(Student student) {
        return true;
    } // maintain the order after remove
    public boolean contains(Student student) {
        return true;
    } // if the student is in roster
    public void print() {
        // Sort by last name
        for (int i = 0; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (roster[j].compareTo(roster[j-1]) < 0) {
                    Student temp = new Student();
                    temp = roster[j-1];
                    roster[j-1] = roster[j];
                    roster[j] = temp;
                }
            }
        }
        // if same last name, sort by first name
        // if same fname lname, sort by dob
        // print the whole roster
        for (int i = 0; i < size; i ++) {
            System.out.print(roster[i].getProfile().getFname() + " ");
            System.out.print(roster[i].getProfile().getLname() + " ");
            System.out.print(roster[i].getProfile().getDOB().getMonth() + "/");
            System.out.print(roster[i].getProfile().getDOB().getDay() + "/");
            System.out.print(roster[i].getProfile().getDOB().getYear() + " ");
            System.out.print(roster[i].getMajor() + " ");
            System.out.print(roster[i].getCredits());
            // print statement for class (fresh, soph, jun, sen)
            System.out.println();
        }
    } // print roster sorted by profiles
    public void printBySchoolMajor() {} // print roster sorted by school major
    public void printByStanding() {} // print roster sorted by standing
}