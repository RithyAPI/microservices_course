package com.ut.utAttendance.helper;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.Inet4Address;
import java.util.Random;

public class GeneratePasswordPDF {

    public static String generatePasswordPDF(HttpServletRequest httpServletRequest) throws IOException {
        String rechaptcha;
        String hostName = Inet4Address.getLocalHost().getHostName();
        String hostAddress = httpServletRequest.getRemoteAddr();

        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 6) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        rechaptcha = salt.toString();

        return rechaptcha;
    }
}
