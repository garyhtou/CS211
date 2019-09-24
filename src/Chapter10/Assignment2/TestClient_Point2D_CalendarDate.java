package Chapter10.Assignment2;

/**
 * Gary Tou
 * 9/24/2019
 */

public class TestClient_Point2D_CalendarDate {

    public static void main (String[] args){

        System.out.println("*Test for Point2D*");
        testPoint2D();
        System.out.println("\n----------\n\n*Test for CalendarDate*");
        testCalendarDate();

        /*
        Results printed:
            *Test for Point2D*
            (2, 4) compared to (5, 10):   -1
            (5, 10) compared to (5, 10):  0
            (2, 5) compared to (2, 4):    1

            ----------

            *Test for CalendarDate*
            2000/11/27 compared to 2019/09/24:  -1
            2019/09/24 compared to 2000/11/27:  1
            2000/03/02 compared to 2000/11/27:  -1
            2000/03/04 compared to 2000/03/02:  1
            2000/03/04 compared to 2000/03/04:  0
         */
    }

    public static void testPoint2D(){

        //Creating points
        Point2D point1 = new Point2D(2, 4);
        Point2D point2 = new Point2D(5, 10);
        Point2D point3 = new Point2D(2,5);

        //Test cases
        System.out.println("(2, 4) compared to (5, 10):   " + point1.compareTo(point2)); //returns -1
        System.out.println("(5, 10) compared to (5, 10):  " + point2.compareTo(point2)); //returns 0
        System.out.println("(2, 5) compared to (2, 4):    " + point3.compareTo(point1)); //returns 1

    }

    public static void testCalendarDate(){

        //Creating dates
        CalendarDate date1 = new CalendarDate(2000, 11, 27);
        CalendarDate date2 = new CalendarDate(2019, 9, 24);
        CalendarDate date3 = new CalendarDate(2000, 3, 2);
        CalendarDate date4 = new CalendarDate(2000,3,4);

        //Test cases
        System.out.println("2000/11/27 compared to 2019/09/24:  " + date1.compareTo(date2));
        System.out.println("2019/09/24 compared to 2000/11/27:  " + date2.compareTo(date1));
        System.out.println("2000/03/02 compared to 2000/11/27:  " + date3.compareTo(date1));
        System.out.println("2000/03/04 compared to 2000/03/02:  " + date4.compareTo(date3));
        System.out.println("2000/03/04 compared to 2000/03/04:  " + date4.compareTo(date4));

    }
}
