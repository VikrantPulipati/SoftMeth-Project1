import java.util.StringTokenizer;
import java.util.Calendar;
public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;

    public Date() {
        Calendar c = Calendar.getInstance();
        month = c.get(c.MONTH) + 1; // months start at 0 so add 1 to be accurate
        day = c.get(c.DAY_OF_MONTH);
        year = c.get(c.YEAR);
    } // create an object with today's date (see Calendar class)
    public Date(String date) {
        StringTokenizer st = new StringTokenizer(date, "/");
        month = Integer.parseInt((st.nextToken()));
        day = Integer.parseInt((st.nextToken()));
        year = Integer.parseInt((st.nextToken()));
    } // take "mm/dd/yyyy" and create a Date object
    public int getYear() {
        return year;
    }
    public int getMonth() {
        return month;
    }
    public int getDay() {
        return day;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public boolean isValid() { // check if a date is a valid calendar date
        // THIS METHOD DOES NOT ACCOUNT FOR LEAP YEARS
        if (month < 1 || month > 12) {
            return false;
        }
        if (month == 1 && (day < 1 || day > 31)) {
            return false;
        } else if (month == 2 && (day < 1 || day > 28)) {
            return false;
        } else if (month == 3 && (day < 1 || day > 31)) {
            return false;
        } else if (month == 4 && (day < 1 || day > 30)) {
            return false;
        } else if (month == 5 && (day < 1 || day > 31)) {
            return false;
        } else if (month == 6 && (day < 1 || day > 30)) {
            return false;
        } else if (month == 7 && (day < 1 || day > 31)) {
            return false;
        } else if (month == 8 && (day < 1 || day > 31)) {
            return false;
        } else if (month == 9 && (day < 1 || day > 30)) {
            return false;
        } else if (month == 10 && (day < 1 || day > 31)) {
            return false;
        } else if (month == 11 && (day < 1 || day > 30)) {
            return false;
        } else if (month == 12 && (day < 1 || day > 31)) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }

    @Override
    public int compareTo(Date date) { 
        if (this.year > date.year) {
            return 1;
        }
        else if (this.year < date.year) {
            return -1;
        }
        else {
            if (this.month > date.month) {
                return 1;
            }
            else if (this.month < date.month) {
                return -1;
            }
            else {
                if (this.day > date.day) {
                    return 1;
                }
                else if (this.day < date.day) {
                    return -1;
                }
                else {
                    return 0;
                }
            }
        }
    }
}