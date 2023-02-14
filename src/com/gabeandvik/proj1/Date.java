package com.gabeandvik.proj1;

import java.util.StringTokenizer;
import java.util.Calendar;
/**
 * The Date class contains information on valid calendar dates such as day, month, year.
 * Using this info, student birthdates can be checked for validity.
 * @author Vikrant Pulipati, Gabe Ruszala
 */

public class Date implements Comparable<Date> {

    public static final int MONTH_LENGTH_LONG = 31;
    public static final int MONTH_LENGTH_SHORT = 30;
    public static final int FEBRUARY_LENGTH_NORMAL = 28;
    public static final int FEBRUARY_LENGTH_LEAP = 29;
    public static final int QUADRENNIAL = 4;
    public static final int CENTENNIAL = 100;
    public static final int QUATERCENTENNIAL = 400;

    private int year;
    private final int month;
    private final int day;

    /**
     * Create a Date object with today's date.
     */
    public Date() {
        Calendar c = Calendar.getInstance();
        month = c.get(Calendar.MONTH) + 1; // months start at 0 so add 1 to be accurate
        day = c.get(Calendar.DAY_OF_MONTH);
        year = c.get(Calendar.YEAR);
    }

    /**
     * Take "mm/dd/yyyy" and create a Date object.
     * @param date the string containing "mm/dd/yyyy".
     */
    public Date(String date) {
        StringTokenizer st = new StringTokenizer(date, "/");
        month = Integer.parseInt((st.nextToken()));
        day = Integer.parseInt((st.nextToken()));
        year = Integer.parseInt((st.nextToken()));
    } // take "mm/dd/yyyy" and create a Date object

    /**
     * Get the Date object's year.
     * @return the year of the date object.
     */
    public int getYear() {
        return year;
    }

    /**
     * Get the Date object's month.
     * @return the month of the date object.
     */
    public int getMonth() {
        return month;
    }

    /**
     * Get the Date object's day.
     * @return the day of the date object.
     */
    public int getDay() {
        return day;
    }

    /**
     * Set the year of the Date object.
     * @param year the year you want the Date object to have.
     */
    public void setYear(int year) {
        this.year = year;
    }
    
    /**
     * Check if a date is a valid calendar date.
     * @return true if the given date is a valid calendar date.
     */
    public boolean isValid() {
        if (month < 1 || month > 12) return false;
        if (day < 1) return false;

        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> { return day <= MONTH_LENGTH_LONG; }
            case 2 -> {
                if (day > FEBRUARY_LENGTH_LEAP) return false;
                return this.isLeapYear() || day <= FEBRUARY_LENGTH_NORMAL;
            }
            case 4, 6, 9, 11 -> { return day <= MONTH_LENGTH_SHORT; }
            default -> { return false; }
        }
    }

    /**
     * Check if a date is a leap year
     * @return true if the given date's year is a leap year.
     */
    public boolean isLeapYear () {
        if (this.year%QUADRENNIAL != 0) return false;
        if (this.year%CENTENNIAL != 0) return true;
        return this.year % QUATERCENTENNIAL == 0;
    }

    /**
     * Convert a date into a String.
     * @return a String of the date in the format "mm/dd/yyyy".
     */
    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }

    /**
     * Check if two dates are the same.
     * @return true if the two dates contain the same year, month, and day.
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Date other)) return false;
        return this.year == other.getYear() &&
                this.month == other.getMonth() &&
                this.day == other.getDay();
    }

    /**
     * Compare two dates
     * @return 1 if Date1 is a more recent date, -1 if less recent, 0 if both Dates are the same
     */
    @Override
    public int compareTo(Date date) { 
        if (this.year > date.year) return 1;
        if (this.year < date.year) return -1;

        if (this.month > date.month) return 1;
        if (this.month < date.month) return -1;

        return Integer.compare(this.day, date.day);

    }

    /**
     * A method for testing the date class.
     * @param args is there only for building the main method.
     */
    public static void main (String[] args) {
        final String PASSED = "PASSED";
        final String FAILED = "FAILED";

        System.out.println("Test Case 1 - 12/31/2002:");
        Date testDate = new Date("12/31/2002");
        System.out.println((testDate.isValid()? PASSED: FAILED) + "\n");

        System.out.println("Test Case 2 - 2/29/2004:");
        testDate = new Date("2/29/2004");
        System.out.println((testDate.isValid()? PASSED: FAILED) + "\n");

        System.out.println("Test Case 3 - 2/29/2000:");
        testDate = new Date("2/29/2000");
        System.out.println((testDate.isValid()? PASSED: FAILED) + "\n");

        System.out.println("Test Case 4 - 2/29/2003:");
        testDate = new Date("2/29/2003");
        System.out.println((testDate.isValid()? FAILED: PASSED) + "\n");

        System.out.println("Test Case 5 - 4/31/2003:");
        testDate = new Date("4/31/2003");
        System.out.println((testDate.isValid()? FAILED: PASSED) + "\n");

        System.out.println("Test Case 6 - 13/31/2003:");
        testDate = new Date("13/31/2003");
        System.out.println((testDate.isValid()? FAILED: PASSED) + "\n");

        System.out.println("Test Case 7 - 3/32/2003:");
        testDate = new Date("3/32/2003");
        System.out.println((testDate.isValid()? FAILED: PASSED) + "\n");

        System.out.println("Test Case 8 - -1/31/2003:");
        testDate = new Date("-1/31/2003");
        System.out.println((testDate.isValid()? FAILED: PASSED) + "\n");
    }
}