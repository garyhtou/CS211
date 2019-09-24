package Chapter10.Assignment2;

/**
 * Gary Tou
 * 9/24/2019
 */

public class CalendarDate implements Comparable<CalendarDate> {
    private int year;
    private int month;
    private int day;

    public CalendarDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String toString() {
        String result = year + "/";
        if (month < 10) {
            result += "0";
        }
        result += month + "/";
        if (day < 10) {
            result += "0";
        }
        result += day;
        return result;
    }

    /**
     * Compares dates with years taking precedence over months, which take
     * precedence over days.
     * Implements Comparable.
     * @param date Another CalendarDate to compare against.
     * @return -1, 0, or 1
     */
    public int compareTo(CalendarDate date) {
        if (this.getYear() < date.getYear()) { //Compares Years first
            return -1;
        } else if (this.getYear() > date.getYear()) {
            return 1;
        } else if (this.getMonth() < date.getMonth()) { //If Years the the same, compare months
            return -1;
        } else if (this.getMonth() > date.getMonth()) {
            return 1;
        } else if (this.getDay() < date.getDay()) { //If Years and Months are the same, compare days
            return -1;
        } else if (this.getDay() > date.getDay()) {
            return 1;
        }
        return 0; //if Year, Month, and Days are the same, return 0
    }

}
