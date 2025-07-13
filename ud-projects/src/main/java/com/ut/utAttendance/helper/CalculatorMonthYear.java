package com.ut.utAttendance.helper;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalculatorMonthYear {


    //  Find Saturday and Sunday
    public static int saturdaysundaycount(Date d1, Date d2) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(d1);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(d2);

        int sundays = 0;
        int saturday = 0;

        while (! c1.after(c2)) {
            if (c1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ){
                saturday++;
            }
            if(c1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
                sundays++;
            }

            c1.add(Calendar.DATE, 1);
        }

        return saturday + sundays;
    }

    public static int getNumberOfMonth(int year, int month) {
        int iYear = year;
        int iMonth = 0;  // 1 (months begin with 0)
        int iDay = 1;

        switch(month) {
            case 1:
                iMonth = Calendar.JANUARY;
                break;
            case 2:
                iMonth = Calendar.FEBRUARY;
                break;
            case 3:
                iMonth = Calendar.MARCH;
                break;
            case 4:
                iMonth = Calendar.APRIL;
                break;
            case 5:
                iMonth = Calendar.MAY;
                break;
            case 6:
                iMonth = Calendar.JUNE;
                break;
            case 7:
                iMonth = Calendar.JULY;
                break;
            case 8:
                iMonth = Calendar.AUGUST;
                break;
            case 9:
                iMonth = Calendar.SEPTEMBER;
                break;
            case 10:
                iMonth = Calendar.OCTOBER;
                break;
            case 11:
                iMonth = Calendar.NOVEMBER;
                break;
            case 12:
                iMonth = Calendar.DECEMBER;
                break;
            default:
                // code block
        }

// Create a calendar object and set year and month
        Calendar mycal = new GregorianCalendar(iYear, iMonth, iDay);

// Get the number of days in that month
        int daysInMonth = mycal.getActualMaximum(Calendar.DAY_OF_MONTH); // 28

        return daysInMonth;
    }

}
