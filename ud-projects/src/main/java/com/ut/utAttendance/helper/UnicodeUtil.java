package com.ut.utAttendance.helper;

import java.util.LinkedHashMap;
import java.util.Map;

public class UnicodeUtil {
    private static final String COENG = Character.toString(unicodeChar("0x17D2"));
    private static Map<String, String> subConsonant;
    private static Map<String, String> vowelBelow;
    private static Map<String, String> vowelAbove;
    private static Map<String, String> changeVowel;
    private static Map<String, String> consonantShifter;

    public UnicodeUtil() {
    }

    public static char unicodeChar(String strInput) {
        return (char)Integer.parseInt(strInput.substring(2, strInput.length()), 16);
    }

    private static String getSubConsonantKey(char charValue) {
        return COENG.concat(Character.toString(charValue));
    }

    private static String getKey(char charValue) {
        return Character.toString(charValue);
    }

    public static String getVowelBelow(String key) {
        if (vowelBelow == null) {
            loadVowelBelow();
        }

        return vowelBelow.containsKey(key) ? Character.toString(unicodeChar((String)vowelBelow.get(key))) : key;
    }

    public static String getVowelAbove(String key) {
        if (vowelAbove == null) {
            loadVowelAbove();
        }

        return vowelAbove.containsKey(key) ? Character.toString(unicodeChar((String)vowelAbove.get(key))) : key;
    }

    public static String change(String key) {
        if (changeVowel == null) {
            loadChangeVowel();
        }

        return changeVowel.containsKey(key) ? Character.toString(unicodeChar((String)changeVowel.get(key))) : key;
    }

    public static String getConsonantShifter(String key) {
        if (consonantShifter == null) {
            consonantShifter = new LinkedHashMap();
            consonantShifter.put(getKey(unicodeChar("0x17C9")), "0xF0D4");
            consonantShifter.put(getKey(unicodeChar("0x17CA")), "0xF0DB");
        }

        return consonantShifter.containsKey(key) ? Character.toString(unicodeChar((String)consonantShifter.get(key))) : key;
    }

    public static String getSubConsonant(String key) {
        if (subConsonant == null) {
            loadConsonant();
        }

        return subConsonant.containsKey(key) ? Character.toString(unicodeChar((String)subConsonant.get(key))) : key;
    }

    private static void loadConsonant() {
        subConsonant = new LinkedHashMap();
        subConsonant.put(getSubConsonantKey(unicodeChar("0x1780")), "0xF000");
        subConsonant.put(getSubConsonantKey(unicodeChar("0x1781")), "0xF001");
        subConsonant.put(getSubConsonantKey(unicodeChar("0x1782")), "0xF002");
        subConsonant.put(getSubConsonantKey(unicodeChar("0x1783")), "0xF003");
        subConsonant.put(getSubConsonantKey(unicodeChar("0x1784")), "0xF004");
        subConsonant.put(getSubConsonantKey(unicodeChar("0x1785")), "0xF005");
        subConsonant.put(getSubConsonantKey(unicodeChar("0x1786")), "0xF006");
        subConsonant.put(getSubConsonantKey(unicodeChar("0x1787")), "0xF007");
        subConsonant.put(getSubConsonantKey(unicodeChar("0x1788")), "0xF008");
        subConsonant.put(getSubConsonantKey(unicodeChar("0x1789")), "0xF009");
        subConsonant.put(getSubConsonantKey(unicodeChar("0x178A")), "0xF00A");
        subConsonant.put(getSubConsonantKey(unicodeChar("0x178B")), "0xF00B");
        subConsonant.put(getSubConsonantKey(unicodeChar("0x178C")), "0xF00C");
        subConsonant.put(getSubConsonantKey(unicodeChar("0x178D")), "0xF00D");
        subConsonant.put(getSubConsonantKey(unicodeChar("0x178E")), "0xF00E");
        subConsonant.put(getSubConsonantKey(unicodeChar("0x178F")), "0xF00F");
        subConsonant.put(getSubConsonantKey(unicodeChar("0x1790")), "0xF010");
        subConsonant.put(getSubConsonantKey(unicodeChar("0x1791")), "0xF011");
        subConsonant.put(getSubConsonantKey(unicodeChar("0x1792")), "0xF012");
        subConsonant.put(getSubConsonantKey(unicodeChar("0x1793")), "0xF013");
        subConsonant.put(getSubConsonantKey(unicodeChar("0x1794")), "0xF014");
        subConsonant.put(getSubConsonantKey(unicodeChar("0x1795")), "0xF015");
        subConsonant.put(getSubConsonantKey(unicodeChar("0x1796")), "0xF016");
        subConsonant.put(getSubConsonantKey(unicodeChar("0x1797")), "0xF017");
        subConsonant.put(getSubConsonantKey(unicodeChar("0x1798")), "0xF018");
        subConsonant.put(getSubConsonantKey(unicodeChar("0x1799")), "0xF019");
        subConsonant.put(getSubConsonantKey(unicodeChar("0x179A")), "0xF01A");
        subConsonant.put(getSubConsonantKey(unicodeChar("0x179B")), "0xF01B");
        subConsonant.put(getSubConsonantKey(unicodeChar("0x179C")), "0xF01C");
        subConsonant.put(getSubConsonantKey(unicodeChar("0x179F")), "0xF01F");
        subConsonant.put(getSubConsonantKey(unicodeChar("0x17A0")), "0xF0A0");
        subConsonant.put(getSubConsonantKey(unicodeChar("0x17A2")), "0xF0A2");
    }

    private static void loadVowelBelow() {
        vowelBelow = new LinkedHashMap();
        vowelBelow.put(getKey(unicodeChar("0x17BB")), "0xF0A3");
        vowelBelow.put(getKey(unicodeChar("0x17BC")), "0xF0A4");
        vowelBelow.put(getKey(unicodeChar("0x17BD")), "0xF0A5");
    }

    private static void loadVowelAbove() {
        vowelAbove = new LinkedHashMap();
        vowelAbove.put(getKey(unicodeChar("0x17B7")), "0xF0A6");
        vowelAbove.put(getKey(unicodeChar("0x17B8")), "0xF0A7");
        vowelAbove.put(getKey(unicodeChar("0x17B9")), "0xF0A8");
        vowelAbove.put(getKey(unicodeChar("0x17BA")), "0xF0A9");
    }

    private static void loadChangeVowel() {
        changeVowel = new LinkedHashMap();
        changeVowel.put(getKey(unicodeChar("0x17B7")), "0xF0CD");
        changeVowel.put(getKey(unicodeChar("0x17B8")), "0xF0CE");
        changeVowel.put(getKey(unicodeChar("0x17B9")), "0xF0CF");
        changeVowel.put(getKey(unicodeChar("0x17BA")), "0xF0D0");
        changeVowel.put(getKey(unicodeChar("0x17BB")), "0xF0DC");
        changeVowel.put(getKey(unicodeChar("0x17BC")), "0xF0DD");
        changeVowel.put(getKey(unicodeChar("0x17BD")), "0xF0DE");
        changeVowel.put(getKey(unicodeChar("0x17C5")), "0xF0CC");
        changeVowel.put(getKey(unicodeChar("0x17C6")), "0xF0D3");
        changeVowel.put(getKey(unicodeChar("0x17BF")), "0xF0D1");
        changeVowel.put(getKey(unicodeChar("0x17C0")), "0xF0D2");
        changeVowel.put(getKey(unicodeChar("0x17C9")), "0xF0D4");
        changeVowel.put(getKey(unicodeChar("0x17CB")), "0xF0D5");
        changeVowel.put(getKey(unicodeChar("0x17CC")), "0xF0D6");
        changeVowel.put(getKey(unicodeChar("0x17CD")), "0xF0D7");
        changeVowel.put(getKey(unicodeChar("0x17CE")), "0xF0D8");
        changeVowel.put(getKey(unicodeChar("0x17CF")), "0xF0D9");
        changeVowel.put(getKey(unicodeChar("0x17D0")), "0xF0DA");
        changeVowel.put(getKey(unicodeChar("0x17CA")), "0xF0DB");
    }
}