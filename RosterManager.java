import java.util.Scanner;
public class RosterManager {
    public void add(Roster roster, Scanner stringScanner) {
        Profile newProfile = new Profile();
        Student newStudent = new Student();

        newProfile.setFname(stringScanner.next());
        newProfile.setLname(stringScanner.next());

        newStudent.setProfile(newProfile);
        Date newDate = new Date(stringScanner.next());
        newStudent.setDOB(newDate);
        newStudent.setMajor(stringScanner.next());
        // set credits with Date class

        roster.add(newStudent);
    }
    public void run() {
        Roster roster = new Roster();
        System.out.println("Roster Manager running...");
        Scanner stringScanner = new Scanner(System.in);
        String command = stringScanner.next();
        while (command.equals("Q") != true) {
            if (command.equals("A") == true) {
                add(roster, stringScanner);
            } else if (command.equals("R") == true) {

            } else if (command.equals("P") == true) {

            } else if (command.equals("PS") == true) {

            } else if (command.equals("PC") == true) {

            } else if (command.equals("L") == true) {

            } else if (command.equals("C") == true) {

            } else {
                System.out.println("You fucked up");
                break;
            }
            command = stringScanner.next();
        }
        System.out.println("Roster Manager terminated.");
    }
}