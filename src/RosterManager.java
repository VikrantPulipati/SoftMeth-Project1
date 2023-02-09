import java.util.Scanner;
public class RosterManager {
    public void add(Roster roster, Scanner stringScanner) {
        Profile newProfile = new Profile();
        Student newStudent = new Student();

        // SET F,L NAME
        newProfile.setFname(stringScanner.next());
        newProfile.setLname(stringScanner.next());
        // SET DOB
        Date newDate = new Date(stringScanner.next());
        newProfile.setDOB(newDate);
        // SET MAJOR
        newStudent.setMajor(stringScanner.next());
        // SET CREDITS
        newStudent.setCredits(Integer.parseInt(stringScanner.next()));
        // SET PROFILE
        newStudent.setProfile(newProfile);
        roster.add(newStudent);
    }
    public void run() {
        Roster roster = new Roster();
        System.out.println("Roster Manager running...");
        Scanner stringScanner = new Scanner(System.in);
        String command = stringScanner.next();

        while (command.equals("Q") != true) {
            if (command.equals("A") == true) {
                // Error conditions:

                // add method:
                add(roster, stringScanner);
            } else if (command.equals("R") == true) {

            } else if (command.equals("P")) {
                roster.print();
            } else if (command.equals("PS")) {

            } else if (command.equals("PC")) {

            } else if (command.equals("L")) {

            } else if (command.equals("C")) {

            }
            command = stringScanner.next();
        }
        System.out.println("Roster Manager terminated.");
    }
}