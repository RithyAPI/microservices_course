package com.ut.utAttendance.helper;

public class Prorate {

    public static Float calProrate(Float amount, Long numberOfDays) {
        return (Float) (float) (Math.round(Float.parseFloat(String.format("%.2f", ((amount / 22) * numberOfDays)))));
//        return Float.parseFloat(String.format("%.2f", ((amount / 22) * numberOfDays)));
    }

}
