import java.util.Scanner;
public class RosterManager {
    public void run() {
        System.out.println("Roster Manager running...");
        Scanner stringScanner = new Scanner(System.in);
        String command = stringScanner.next();
        while (command.equals("Q") != true) {
            if (command.equals("A") == true) {

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