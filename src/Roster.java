/**
 * The Roster class contains an array of Students (simulating a roster) and Student array operations.
 * @author Vikrant Pulipati, Gabe Ruszala
 */

public class Roster {

    public static final int NOT_FOUND = -1;

    private Student[] roster = new Student[4];
    private int size = 0;

    /**
     * Get the Student roster
     * @return the Student[] roster
     */
    public Student[] getRoster() {
        return this.roster;
    }

    /**
     * find the index in the roster where a specific student is located.
     * @param student the student you're looking for.
     * @return the index of the array which holds the student you're looking for. Return -1 if not found.
     */
    private int find(Student student) {
        for (int i = 0; i < size; i++) {
            if (student.equals(roster[i])) {
                return i;
            }
        }
        return NOT_FOUND;
    } // search the given student in roster

    /**
     * Grow the size of the student array by 4.
     */
    private void grow() { 
        Student[] newRoster = new Student[roster.length + 4];
        for (int i = 0; i < roster.length; i++) {
            newRoster[i] = roster[i];
        }
        roster = newRoster;

    }

    /**
     * Add a student to the end of the roster.
     * @param student the student object you want to add.
     * @return true when the student has been successfully added.
     */
    public boolean add(Student student) {
        roster[size] = student;
        size++;
        if (size == roster.length) {
            grow();
        }
        return true;
    } 

    /**
     * Remove a student from the roster.
     * @param student the student you want to remove.
     * @return true when the student has been removed.
     */
    public boolean remove(Student student) {
        int index = find(student);
        roster[index] = null;
        for (int i = index; i < size-1; i++) {
            roster[i] = roster[i+1];
            roster[i+1] = null;
        }
        size--;
        return true;
    } // maintain the order after remove

    /**
     * Check if the student roster contains a speciic Student.
     * @param target the Student you are looking for.
     * @return true if the Student is contained in the roster, false otherwise.
     */
    public boolean contains(Student target) {
        for (Student student : roster) {
            if (target.equals(student)) {
                return true;
            }
        }
        return false;
    } // if the student is in roster

    /**
     * Change a Student's major.
     * @param student The student who is major you want to change.
     * @param newMajor the new major you wish the student to have.
     */
    public void changeMajor(Student student, Major newMajor) {
        roster[find(student)].setMajor(newMajor);
    }

    /**
     * Print the roster of students from index 0 to the last index.
     */
    public void printRoster () {
        for (Student student : roster) {
            if (student == null) return;
            System.out.println(student);
        }
    }

    /**
     * Sort the Student roster by profile (last name, first name, date of birth).
     */
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

    /**
     * Print the roster sorted by profile (last name, first name, date of birth).
     */
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
    
    /**
     * Print the roster sorted by school major (BAIT, CS, MATH, ITI, EE)
     */
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
    } 

    /**
     * Print the roster by standing (standings are in alphabetical order).
     * Sorted order: Freshmen, Juniors, Seniors, Sophomores.
     */
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
    }
}