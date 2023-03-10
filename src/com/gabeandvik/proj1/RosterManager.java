package com.gabeandvik.proj1;

import java.util.Scanner;

/**
 * The RosterManager class acts as the interface between user and program.
 * RosterManager takes in user input, and performs operations on the student roster accordingly.
 * @author Vikrant Pulipati, Gabe Ruszala
 */
public class RosterManager {
    /**
     * Takes in the user's input date and checks if it is a valid date for the roster.
     * @param date the date which the user inputs.
     * @return true if the date is a valid calendar date and occurred no less than 16 years ago.
     */
    public boolean isValidDate (Date date) {
        // checking if date is a valid calendar date
        if (!(date.isValid())) {
            System.out.println("DOB invalid: " + date
                    + " not a valid calendar date!");
            return false;
        }
        // checking if dob is today or a future date
        if (date.compareTo(new Date()) >= 0) {
            System.out.println("DOB invalid: " + date
                    + " is either today or a future date.");
            return false;
        }
        // checking if student is under 16
        int yearOfBirth = date.getYear();
        date.setYear(yearOfBirth + 16);
        if (date.compareTo(new Date()) > 0) {
            date.setYear(yearOfBirth);
            System.out.println("DOB invalid: " + date
                    + " younger than 16 years old.");
            return false;
        }
        date.setYear(yearOfBirth);
        return true;
    }

    /**
     * Create and add a new student to the roster.
     * @param roster the Student roster.
     * @param inputs String array containing all user input on the new student to be made.
     */
    public void add(Roster roster, String[] inputs) {
        //VALIDATE DATE
        Date newDate = new Date(inputs[3]);
        if (!isValidDate(newDate)) return;

        Profile newProfile = new Profile(inputs[1], inputs[2], newDate);

        // VALIDATE MAJOR
        Major newMajor = Major.getMajorFromString(inputs[4]);
        if (newMajor == null) {
            System.out.println("Major code invalid: " + inputs[4]);
            return;
        }
        // VALIDATE CREDITS
        int credits;
        try {
            credits = Integer.parseInt(inputs[5]);
        } catch (NumberFormatException e) {
            System.out.println("Credits completed invalid: not an integer!");
            return;
        }
        if (credits < 0) {
            System.out.println("Credits completed invalid: cannot be negative!");
            return;
        }
        // CREATE NEW STUDENT
        Student student = new Student(newProfile, newMajor, credits);
        if (roster.contains(student)) {
            System.out.println(student.getProfile() + " is already in the roster.");
            return;
        }
        roster.add(student);
        roster.sortByProfile();
        System.out.println(newProfile + " added to the roster.");
    }

    /**
     * Remove a student from the roster.
     * @param roster the Student roster.
     * @param inputs String array containing all user input on the student to be removed.
     */
    public void remove(Roster roster, String[] inputs) {
        // make a copy of the student in question, search for the student, remove the student.
        Profile newProfile = new Profile(inputs[1], inputs[2], new Date(inputs[3]));
        Student newStudent = new Student(newProfile);

        if (!roster.contains(newStudent)) {
            System.out.println(newProfile + " is not in the roster.");
            return;
        }
        if (roster.remove(newStudent)) {
            System.out.println(newProfile + " removed from the roster.");
        }
    }

    /**
     * Change a student's major.
     * @param roster the Student roster.
     * @param inputs String array containing all user input on the student who's major will be changed.
     */
    public void changeMajor(Roster roster, String[] inputs) {
        // make a copy of the student in question, search for the student, change that student's major.
        Profile newProfile = new Profile(inputs[1], inputs[2], new Date(inputs[3]));
        Student newStudent = new Student(newProfile);

        if (!roster.contains(newStudent)) {
            System.out.println(newProfile + " is not in the roster.");
            return;
        }

        Major newMajor = Major.getMajorFromString(inputs[4]);
        if (newMajor == null) {
            System.out.println("Major code invalid: " + inputs[4]);
            return;
        }
        roster.changeMajor(newStudent, newMajor);
        System.out.println(newProfile + " major changed to " + newMajor.getMajorName());
    }

    /**
     * List all of the students in a specified school.
     * @param roster the Student roster.
     * @param school the school you would like to list.
     */
    public void list(Roster roster, String school) {
        roster.sortByProfile();
        switch (school.toUpperCase()) {
            case "RBS" -> {
                System.out.println("* Students in " + school + " *");
                for (Student student : roster.getRoster()) {
                    if (student == null) break;
                    if (student.getMajor().getSchool().equals("RBS")) System.out.println(student);
                }
                System.out.println("* end of list **");
            }
            case "SAS" -> {
                System.out.println("* Students in " + school + " *");
                for (Student student : roster.getRoster()) {
                    if (student == null) break;
                    if (student.getMajor().getSchool().equals("SAS")) System.out.println(student);
                }
                System.out.println("* end of list **");
            }
            case "SC&I" -> {
                System.out.println("* Students in " + school + " *");
                for (Student student : roster.getRoster()) {
                    if (student == null) break;
                    if (student.getMajor().getSchool().equals("SC&I")) System.out.println(student);
                }
                System.out.println("* end of list **");
            }
            case "SOE" -> {
                System.out.println("* Students in " + school + " *");
                for (Student student : roster.getRoster()) {
                    if (student == null) break;
                    if (student.getMajor().getSchool().equals("SOE")) System.out.println(student);
                }
                System.out.println("* end of list **");
            }
            default -> System.out.println("School doesn't exist: " + school);
        }
    }

    /**
     * Take in user input and run the program!
     */
    public void run() {
        Roster roster = new Roster();
        System.out.println("Roster Manager running...");

        Scanner stringScanner = new Scanner(System.in);
        label: while (true) {
            String[] inputs = stringScanner.nextLine().split(" +");
            String opCode = inputs[0];
            switch (opCode) {
                case "" -> {}
                case "Q" -> { break label; }
                case "A" -> add(roster, inputs);
                case "R" -> remove(roster, inputs);
                case "P" -> roster.print();
                case "PS" -> roster.printByStanding();
                case "PC" -> roster.printBySchoolMajor();
                case "L" -> list(roster, inputs[1]);
                case "C" -> changeMajor(roster, inputs);
                default -> System.out.println(opCode + " is an invalid command!");
            }
        }
        stringScanner.close();
        System.out.println("Roster Manager terminated.");
    }
}