public class Roster {

    public static final int NOT_IN_ROSTER = -1;

    private Student[] roster = new Student[4];
    private int size = 0;

    public Student[] getRoster() {
        return this.roster;
    }

    private int find(Student student) {
        for (int i = 0; i < size; i++) {
            if (student.equals(roster[i])) {
                return i;
            }
        }
        return NOT_IN_ROSTER;
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
        int index = find(student);
        roster[index] = roster[size-1];
        roster[size-1] = null;
        size--;
        return true;
    } // maintain the order after remove

    public boolean contains(Student target) {
        for (Student student : roster) {
            if (target.equals(student)) {
                return true;
            }
        }
        return false;
    } // if the student is in roster

    public void changeMajor(Student student, Major newMajor) {
        roster[find(student)].setMajor(newMajor);
    }

    public void printRoster () {
        for (Student student : roster) {
            if (student == null) return;
            System.out.println(student);
        }
    }

    public void sortByProfile () {
        for (int i = 0; i < size; i++) {
            int min_idx = i;
            for (int j = i+1; j < size; j++) {
                if (roster[j].compareTo(roster[min_idx]) < 0) {
                    min_idx = j;
                }
            }
            Student temp = roster[min_idx];
            roster[min_idx] = roster[i];
            roster[i] = temp;
        }
    }

    public void print () { // print roster sorted by profiles
        if (size <= 0) {
            System.out.println("Student roster is empty!");
            return;
        }
        this.sortByProfile();
        System.out.println("* Student roster sorted by last name, first name, DOB **");
        this.printRoster();
        System.out.println("* end of roster **");
    }

    public void printBySchoolMajor () {
        if (size <= 0) {
            System.out.println("Student roster is empty!");
            return;
        }
        for (int i = 0; i < size; i++) {
            int min_idx = i;
            for (int j = i+1; j < size; j++) {
                if (roster[j].getMajor().compare(roster[min_idx].getMajor()) < 0) {
                    min_idx = j;
                }
            }
            Student temp = roster[min_idx];
            roster[min_idx] = roster[i];
            roster[i] = temp;
        }

        System.out.println("* Student roster sorted by school, major **");
        this.printRoster();
        System.out.println("* end of roster **");
    } // print roster sorted by school major

    public void printByStanding () {
        if (size <= 0) {
            System.out.println("Student roster is empty!");
            return;
        }
        for (int i = 0; i < size; i++) {
            int min_idx = i;
            for (int j = i+1; j < size; j++) {
                if (roster[j].getStanding().compareTo(roster[min_idx].getStanding()) < 0) {
                    min_idx = j;
                }
            }
            Student temp = roster[min_idx];
            roster[min_idx] = roster[i];
            roster[i] = temp;
        }

        System.out.println("* Student roster sorted by standing **");
        this.printRoster();
        System.out.println("* end of roster **");
    } // print roster sorted by standing
}