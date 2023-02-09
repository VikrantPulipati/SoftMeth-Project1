import java.util.StringTokenizer;
import java.util.Calendar;
public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;

    public Date() {
        Calendar c = Calendar.getInstance();
        month = c.get(c.MONTH);
        day = c.get(c.DATE);
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
    public boolean isValid() {
        return true;
    } // check if a date is a valid calendar date

    public int compareTo(Date date) { return 0; }
}