public class Roster {
    private Student[] roster = new Student[10];
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
            // Printing out major
            if (roster[i].getMajor() == Major.CS) {
                System.out.print("(01:198 CS SAS) ");
            } else if (roster[i].getMajor() == Major.MATH) {
                System.out.print("(01:640 MATH SAS) ");
            } else if (roster[i].getMajor() == Major.EE) {
                System.out.print("(14:332 EE SOE) ");
            } else if (roster[i].getMajor() == Major.ITI) {
                System.out.print("(04:547 ITI SC&I) ");
            } else if (roster[i].getMajor() == Major.BAIT) {
                System.out.print("(33:136 BAIT RBS) ");
            } 
            System.out.print("credits completed: " + roster[i].getCredits() + " ");
            // number of credits determines class
            if (roster[i].getCredits() < 30) {
                System.out.print("(Freshman)");
            } else if (roster[i].getCredits() < 60) {
                System.out.print("(Sophomore)");
            } else if (roster[i].getCredits() < 90) {
                System.out.print("(Junior)");
            } else {
                System.out.print("(Senior)");
            }
            System.out.println();
        }
    } // print roster sorted by profiles
    public void printBySchoolMajor() {} // print roster sorted by school major
    public void printByStanding() {} // print roster sorted by standing
}