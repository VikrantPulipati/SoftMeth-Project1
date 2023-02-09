import java.util.Scanner;
public class RosterManager {

    public void add(Roster roster, Scanner stringScanner) {
        Profile newProfile = new Profile();
        Student newStudent = new Student();

        newProfile.setFname(stringScanner.next());
        newProfile.setLname(stringScanner.next());

        newStudent.setProfile(newProfile);
        Date newDate = new Date(stringScanner.next());
        //newStudent.setDOB(newDate);
        newStudent.setMajor(stringScanner.next());
        // set credits with Date class

        roster.add(newStudent);
    }
    public void run() {
        Roster roster = new Roster();
        System.out.println("Roster Manager running...");
        Scanner stringScanner = new Scanner(System.in);
        String input = stringScanner.next();

        while (input.charAt(0) != 'Q') {
            if (input.equals("A")) {
                add(roster, stringScanner);
            } else if (input.equals("R") == true) {

            } else if (input.equals("P")) {

            } else if (input.equals("PS")) {

            } else if (input.equals("PC")) {

            } else if (input.equals("L")) {

            } else if (input.equals("C")) {

            } else {
                System.out.println("You fucked up");
                break;
            }
            System.out.println("Roster Manager terminated.");
        }
    }
}