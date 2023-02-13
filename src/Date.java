import java.util.StringTokenizer;
import java.util.Calendar;
public class Date implements Comparable<Date> {

    private int year;
    private int month;
    private int day;

    public Date() {
        Calendar c = Calendar.getInstance();
        month = c.get(Calendar.MONTH) + 1; // months start at 0 so add 1 to be accurate
        day = c.get(Calendar.DAY_OF_MONTH);
        year = c.get(Calendar.YEAR);
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
        if (month < 1 || month > 12) return false;
        if (day < 1) return false;

        int MONTH_LENGTH_LONG = 31;
        int MONTH_LENGTH_SHORT = 30;

        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> { return day <= MONTH_LENGTH_LONG; }
            case 2 -> {
                if (day > 29) return false;
                return this.isLeapYear() || day <= 28;
            }
            case 4, 6, 9, 11 -> { return day <= MONTH_LENGTH_SHORT; }
            default -> { return false; }
        }
    }

    public boolean isLeapYear () {
        if (this.year%4 != 0) return false;
        if (this.year%100 != 0) return true;
        return this.year % 400 == 0;
    }

    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Date other)) return false;
        return this.year == other.getYear() &&
                this.month == other.getMonth() &&
                this.day == other.getDay();
    }

    @Override
    public int compareTo(Date date) { 
        if (this.year > date.year) return 1;
        if (this.year < date.year) return -1;

        if (this.month > date.month) return 1;
        if (this.month < date.month) return -1;

        return Integer.compare(this.day, date.day);

    }
}