package com.ut.utAttendance.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class CountNumberDayOfWork {

    public static int getNumberOfMonth(String startDate) {
        DateTimeFormatter myFormatMonth = DateTimeFormatter.ofPattern("MM");
        DateTimeFormatter myFormatYear = DateTimeFormatter.ofPattern("yyyy");

        LocalDateTime dateOfEmployeeBeforeFormat = LocalDateTime.parse(startDate + "T10:15:30");

        String monthEmployeeWork = dateOfEmployeeBeforeFormat.format(myFormatMonth);
        String yearEmployeeWork = dateOfEmployeeBeforeFormat.format(myFormatYear);

        int dayIntMonth = CalculatorMonthYear.getNumberOfMonth(new Integer(yearEmployeeWork), new Integer(monthEmployeeWork));
        return dayIntMonth;
    }


    public static int countSaturdayAndSunday(String startDate, String endDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        int countSaturdayAndSunday = 0;
        try {
            Date startDateAfterFormat = formatter.parse(startDate + " 20:16:00");
            Date endDateAfterFormat = formatter.parse(endDate + " 20:16:00");

            countSaturdayAndSunday = CalculatorMonthYear.saturdaysundaycount(startDateAfterFormat, endDateAfterFormat);

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return countSaturdayAndSunday;
    }


}
