import java.util.Scanner;
public class RosterManager {
    public void run() {
        Roster roster = new Roster();
        System.out.println("Roster Manager running...");
        Scanner stringScanner = new Scanner(System.in);
        String command = stringScanner.next();
        while (!command.equals("Q")) {
            if (command.equals("A")) {

            } else if (command.equals("R")) {

            } else if (command.equals("P")) {

            } else if (command.equals("PS")) {

            } else if (command.equals("PC")) {

            } else if (command.equals("L")) {

            } else if (command.equals("C")) {

            } else {
                System.out.println("You fucked up");
                break;
            }
            command = stringScanner.next();
        }
        System.out.println("Roster Manager terminated.");
    }
}