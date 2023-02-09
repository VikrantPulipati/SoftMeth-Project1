import java.util.Scanner;
public class RosterManager {
    public static boolean validInput(Roster roster, Student newStudent, Profile newProfile, Date newDate) {
        // check if student is already in the roster
        if (roster.contains(newStudent)) {
            System.out.print(newStudent.getProfile());
            System.out.print(" is already in the roster.");
            System.out.println();
            return false;
        }

        // check major
        if (newStudent.getMajor() == null) {
            return false;
        }
        // check credits
        if (newStudent.getCredits() < 0) {
            return false;
        }
        Date todayDate = new Date();
        Date newStudentDOB = newStudent.getProfile().getDOB();
        int newStudentYear = newStudentDOB.getYear();

        // checking if date is a valid calendar date
        if (!(newStudentDOB.isValid())) {
            System.out.print("DOB invalid: ");
            System.out.print(newStudentDOB);
            System.out.print(" not a valid calendar date!");
            System.out.println();
            return false;
        }
        // checking if dob is today or a future date
        if (newStudentDOB.compareTo(todayDate) >= 0) {
            System.out.print("DOB invalid: ");
            System.out.print(newStudentDOB);
            System.out.print(" is either today or a future date.");
            System.out.println();
            return false;
        }
        // checking if student is under 16
        newStudentDOB.setYear(newStudentYear + 16);
        if (newStudentDOB.compareTo(todayDate) > 0) {
            newStudentDOB.setYear(newStudentYear);
            System.out.print("DOB invalid: ");
            System.out.print(newStudentDOB);
            System.out.print(" younger than 16 years old.");
            System.out.println();
            return false;
        }
        newStudentDOB.setYear(newStudentYear);
        // Student passed all checks - displaying success message.
        System.out.print(newStudent.getProfile());
        System.out.print(" added to the roster.");
        System.out.println();
        return true;
    }
    public void add(Roster roster, String[] inputs) {
        // CHECK FOR ERROR CONDITIONS:
                // non-calendar date of birth FINISHED
                // dob is today or a future date FINISHED
                // student is less than 16 years old FINISHED
                // invalid major FINISHED
                // student is in the roster already FINISHED
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
        if(validInput(roster, newStudent, newProfile, newDate)) {
            roster.add(newStudent); 
        }
    }
    public void changeMajor(Roster roster, String[] inputs) {
        // make a copy of the student in question, search for the student, change that student's major.
        Profile newProfile = new Profile();
        Student newStudent = new Student();
        // SET F,L NAME, DOB
        newProfile.setFname(inputs[1]);
        newProfile.setLname(inputs[2]);
        Date newDate = new Date(inputs[3]);
        newProfile.setDOB(newDate);
        newStudent.setProfile(newProfile);
        newStudent.setMajor(inputs[4]);
        if (newStudent.getMajor() == null) {
            System.out.println("Major code invalid: " + inputs[4]);
            return;
        }
        roster.changeMajor(newStudent, newStudent.getMajor());
    }
    public void list(Roster roster, String[] inputs) {
        if (inputs[1].equals("RBS")) {
            System.out.println("* Students in RBS *");
            roster.sortByProfile();
            Student[] students = roster.getRoster();
            for (int i = 0; i < roster.getSize(); i++) {
                if (students[i].getMajor().equals(Major.BAIT)) {
                    System.out.println(students[i]);
                }
            }
        } else if (inputs[1].equals("SAS")) {
            System.out.println("* Students in SAS *");
            roster.sortByProfile();
            Student[] students = roster.getRoster();
            for (int i = 0; i < roster.getSize(); i++) {
                if (students[i].getMajor().equals(Major.CS) || students[i].getMajor().equals(Major.MATH)) {
                    System.out.println(students[i]);
                }
            }
        } else if (inputs[1].equals("SC&I")) {
            System.out.println("* Students in SC&I *");
            roster.sortByProfile();
            Student[] students = roster.getRoster();
            for (int i = 0; i < roster.getSize(); i++) {
                if (students[i].getMajor().equals(Major.ITI)) {
                    System.out.println(students[i]);
                }
            }
        } else if (inputs[1].equals("SOE")) {
            System.out.println("* Students in SOE *");
            roster.sortByProfile();
            Student[] students = roster.getRoster();
            for (int i = 0; i < roster.getSize(); i++) {
                if (students[i].getMajor().equals(Major.EE)) {
                    System.out.println(students[i]);
                }
            }
        }
        else {
            System.out.println("School doesn't exist: " + inputs[1]);
        }
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
                roster.printByStanding();
            } else if (opCode.equals("PC")) {
                roster.printBySchoolMajor();
            } else if (opCode.equals("L")) {
                list(roster, inputs);
            } else if (opCode.equals("C")) {
                changeMajor(roster, inputs);
            } else {
                System.out.println(opCode + " is an invalid command!");
            }
        }
        stringScanner.close();
        System.out.println("Roster Manager terminated.");
    }
}