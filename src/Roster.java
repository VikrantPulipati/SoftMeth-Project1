public class Roster {
    private Student[] roster = new Student[4];
    private int size = 0;

    public int getSize() {
        return this.size;
    }
    public Student[] getRoster() {
        return this.roster;
    }
    public void setSize(int size) {
        this.size = size;
    }
    private int find(Student student) {
        for (int i = 0; i < size; i++) {
            if (student.compareTo(roster[i]) == 0) {
                return i;
            }
        }
        // must define a constand identifier "NOT_FOUND" for the value -1.
        return -1;
    } // search the given student in roster
    private void grow() { // do we have to copy the old array into a new one that's 4 cells bigger? Kind of inefficient though.
        Student[] newRoster = new Student[roster.length + 4];
        for (int i = 0; i < roster.length; i++) {
            newRoster[i] = roster[i];
        }
        roster = newRoster;

    } // increase the array capacity by 4
    public boolean add(Student student) {
        roster[size] = student;
        size++;
        if (size == roster.length) {
            grow();
        }
        return true;
    } // add student to end of array
    public boolean remove(Student student) {
        return true;
    } // maintain the order after remove
    public boolean contains(Student student) {
        for (int i = 0; i < size; i++) {
            if (student.compareTo(roster[i]) == 0) {
                return true;
            }
        }
        return false;
    } // if the student is in roster
    public void changeMajor(Student student, Major newMajor) {
        int index = find(student);
        roster[index].setMajor(student.getMajor().getMajorName());
    }
    public void sortByProfile() {
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
    }
    public void print() {
        sortByProfile();
        // sorts by profile
            // for (int i = 0; i < size; i++) {
            //     for (int j = i; j > 0; j--) {
            //         if (roster[j].compareTo(roster[j-1]) < 0) {
            //             Student temp = new Student();
            //             temp = roster[j-1];
            //             roster[j-1] = roster[j];
            //             roster[j] = temp;
            //         }
            //     }
            // }
        // print the whole roster
        for (int i = 0; i < size; i ++) {
            System.out.println(roster[i]);
        }
    } // print roster sorted by profiles
    public void printBySchoolMajor() {
        for (int i = 0; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (roster[j].getMajor().compareTo(roster[j-1].getMajor()) < 0) {
                    Student temp = new Student();
                    temp = roster[j-1];
                    roster[j-1] = roster[j];
                    roster[j] = temp;
                }
            }
        }
        for (int i = 0; i < size; i ++) {
            System.out.println(roster[i]);
        }
    } // print roster sorted by school major
    public void printByStanding() {
        for (int i = 0; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (roster[j].getStanding().compareTo(roster[j-1].getStanding()) < 0) {
                    Student temp = new Student();
                    temp = roster[j-1];
                    roster[j-1] = roster[j];
                    roster[j] = temp;
                }
            }
        }
        for (int i = 0; i < size; i ++) {
            System.out.println(roster[i]);
        }
    } // print roster sorted by standing
}