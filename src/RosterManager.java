import java.util.Scanner;
public class RosterManager {
    public static void validInput(Roster newRoster, Student newStudent, Profile newProfile, Date newDate) {
        // check major
        if (newStudent.getMajor() == null) {
            return;
        }
        // check credits
        if (newStudent.getCredits() < 0) {
            return;
        }
    }
    public void add(Roster roster, String[] inputs) {
        // CHECK FOR ERROR CONDITIONS:
            // non-calendar date of birth
            // dob is today or a future date
            // student is less than 16 years old
                // invalid major FINISHED
            // student is in the roster already
                // negative number of credits completed FINISHED

        Profile newProfile = new Profile();
        Student newStudent = new Student();

        // SET F,L NAME
        newProfile.setFname(inputs[1]);
        newProfile.setLname(inputs[2]);
        // SET DOB
        Date newDate = new Date(inputs[3]);
        newProfile.setDOB(newDate);
        // SET MAJOR
        // put these few lines of code in the inValid() method
        newStudent.setMajor(inputs[4]);
        // SET CREDITS
        newStudent.setCredits(Integer.parseInt(inputs[5]));
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
        while (true) {
            String input = stringScanner.nextLine();
            String[] inputs = input.split("\s+");
            String opCode = inputs[0];

            if (opCode.equals("Q")) {
                break;
            } else if (opCode.equals("A")) {
                // Error conditions:

                // add method:
                add(roster, inputs);
            } else if (opCode.equals("R")) {

            } else if (opCode.equals("P")) {
                roster.print();
            } else if (opCode.equals("PS")) {

            } else if (opCode.equals("PC")) {

            } else if (opCode.equals("L")) {

            } else if (opCode.equals("C")) {

            } else {
                System.out.println(opCode + " is an invalid command!");
            }
        }
        stringScanner.close();
        System.out.println("Roster Manager terminated.");
    }
}