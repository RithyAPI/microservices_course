package com.ut.utAttendance.helper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PreviousDate {

    public static String previousDate(String currentDate){
        LocalDateTime dateOfCurrentBeforeFormat = LocalDateTime.parse(currentDate + "T10:15:30");

        DateTimeFormatter myFormatYear = DateTimeFormatter.ofPattern("yyyy");
        DateTimeFormatter myFormatMonth = DateTimeFormatter.ofPattern("MM");
        String myFormatOfCurrentYear = dateOfCurrentBeforeFormat.format(myFormatYear);
        String myFormatOfCurrentMonth = dateOfCurrentBeforeFormat.format(myFormatMonth);

        int calYear = Integer.parseInt(myFormatOfCurrentYear);
        int calMonth = Integer.parseInt(myFormatOfCurrentMonth);

        String previousDate;

        calMonth = calMonth - 1;
        if(calMonth == 0 ){
            calMonth = 12;
            calYear = calYear - 1;
        }
        if(calMonth<10){
            /*Previous date*/
            previousDate = calYear+"-0"+calMonth+"-01";
        }else {

            /*Previous date*/
            previousDate = calYear+"-"+calMonth+"-01";
        }

        return previousDate;
    }
}
