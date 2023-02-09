import java.util.Scanner;
public class RosterManager {
    public static void validInput(Roster newRoster, Student newStudent, Profile newProfile, Date newDate) {

    }
    public void add(Roster roster, Scanner stringScanner) {
        // CHECK FOR ERROR CONDITIONS:
            // non-calendar date of birth
            // dob is today or a future date
            // student is less than 16 years old
            
            // student is in the roster already
            // negative number of credits completed

        Profile newProfile = new Profile();
        Student newStudent = new Student();

        // SET F,L NAME
        newProfile.setFname(stringScanner.next());
        newProfile.setLname(stringScanner.next());
        // SET DOB
        Date newDate = new Date(stringScanner.next());
        newProfile.setDOB(newDate);
        // SET MAJOR
        // put these few lines of code in the inValid() method
        int success = newStudent.setMajor(stringScanner.next());
        if (success != 1) {
            return;
        }
        // SET CREDITS
        newStudent.setCredits(Integer.parseInt(stringScanner.next()));
        // SET PROFILE
        newStudent.setProfile(newProfile);
        // CHECK IF INPUT IS VALID
        validInput(roster, newStudent, newProfile, newDate);
        roster.add(newStudent);
    }
    public void run() {
        Roster roster = new Roster();
        System.out.println("Roster Manager running...");
        Scanner stringScanner = new Scanner(System.in);
        String input = stringScanner.next();

        while (!input.equals("Q")) {
            if (input.equals("A")) {
                // Error conditions:

                // add method:
                add(roster, stringScanner);
            } else if (input.equals("R")) {

            } else if (input.equals("P")) {
                roster.print();
            } else if (input.equals("PS")) {

            } else if (input.equals("PC")) {

            } else if (input.equals("L")) {

            } else if (input.equals("C")) {

            }
            System.out.println("Roster Manager terminated.");
        }
    }
}