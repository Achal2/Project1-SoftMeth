
import java.util.StringTokenizer;
import java.util.Calendar;

/**
 * The Date class is used to change the dates into numbers in order to compare them
 *
 * The Date class holds methods in order to check the validity of the dates as well
 * as check the order of different dates within the album collection to help compare with
 * different dates
 * @author  Achal Mukkapati, Moses Devanesan
 */
public class Date implements Comparable<Date> {
    Calendar c;
    private int year;
    private int month;
    private int day;
    public static final int quadrennial = 4;
    public static final int centennial = 100;
    public static final int quartercentennial = 400;

    StringTokenizer splitter = null;
    int[] datearray = new int[3];

    /**
     * Allows us to retrieve the dates from Artist and Release Dates
     *
     * @return The year of artists birth/album release
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the year
     * @param year
     */

    public void setYear(int year) {
        this.year = year;
    }

    /**
     *  Allows us to retrieve the dates from Artist and Release Dates
     *
     * @return The month
     */

    public int getMonth() {
        return month;
    }

    /**
     * Sets the month
     *
     *
     * @param month
     */

    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * Gets the day of Artists birthday/Album release date
     *
     * @return day
     */

    public int getDay() {
        return day;
    }

    /**
     * Sets the day
     *
     *
     * @param day
     */

    public void setDay(int day) {
        this.day = day;
    }

    /**
     * Creates a date object from the user given date
     *
     * @param date
     * @return Date object
     */


    public Date(String date) {
        splitter = new StringTokenizer(date);

        for (int i = 0; i < datearray.length; i++) {
            datearray[i] = Integer.parseInt(splitter.nextToken("/"));
        }

        month = datearray[0];
        day = datearray[1];
        year = datearray[2];
    }
    public Date() {
        year = Calendar.getInstance().get(Calendar.YEAR);
        month = Calendar.getInstance().get(Calendar.MONTH);
        day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    }

    /**
     * Determines if a date is valid based on the number of days, what year, and leap year exceptions,
     * invalid months, etc.
     * @return true or false
     *
     */
    public boolean isValid() {



        if (year<=2024 && year>=1900)
            switch (month) {

                case 1 : if (day>0 && day<31)
                    return true;
                    break;

                case 2 : boolean leap = false;
                    if (year%quadrennial==0)
                        if (year%centennial==0){
                            if (year%quartercentennial==0)
                                leap = true;
                        }
                        else leap = true;

                    if (leap==true) {
                        if (day>0 && day<30)
                            return true;
                    }
                    else {if (day>0 && day<29)
                        return true;
                    else return false;}
                    break;


                case 3 : if (day>0 && day<=30)
                    return true;
                    break;
                case 4 : if (day>0 && day<=31)
                    return true;
                    break;
                case 5 : if (day>0 && day<=30)
                    return true;
                    break;
                case 6: if (day>0 && day<=31)
                    return true;
                    break;

                case 7: if (day>0 && day<=31)
                    return true;
                    break;
                case 8: if (day>0 && day<=30)
                    return true;
                    break;
                case 9: if (day>0 && day<=31)
                    return true;
                    break;
                case 10: if (day>0 && day<=30)
                    return true;
                    break;
                case 11: if (day>0 && day<=31)
                    return true;
                    break;
                case 12: if (day>0 && day<=31)
                    return true;
                    break;

                default :  System.out.println("Invalid Date!");
                    return false;


            }

        else return false;
        return false;
    }

    @Override
    public int compareTo(Date date) {
        if (date.year>year)
            return -1;
        if (date.year<year)
            return 1;
        if (date.year==year){
            if (date.month>month)
                return -1;
            if (date.month<month)
                return 1;
            if (date.month==month){
                if (date.day>day)
                    return -1;
                if (date.day<day)
                    return 1;
            }
        }
        return 0;
    }

    public String toString() {
        return getMonth()+ "/" + getDay() +"/" + getYear();
    }

   /*
      public class DateTest {
        public void main(String[] args) { // Tests the isValid() method
          Date date1 = new Date("1/1/1900");
          System.out.println(date1.isValid()); // prints true
         Date date2 = new Date("2/30/2023");
         System.out.println(date2.isValid()); // prints false
         Date date3 = new Date("2/29/2021");
         System.out.println(date3.isValid()); // prints false
       }
     }
     */

}