package mishavprogram.com.ua.easy;

import java.util.HashMap;

public class RomanToInteger {

    private final HashMap<String, Integer> map = new HashMap<>();

    public RomanToInteger() {
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        map.put("IV", 4);
        map.put("IX", 9);

        map.put("XL", 40);
        map.put("XC", 90);

        map.put("CD", 400);
        map.put("CM", 900);

        map.put("II", 2);
    }

    public int romanToInt(String s) {

        if (s.length() == 1) {
            return map.get(s);
        }

        int sum = 0;

        var modifiedString = s;


        while (!modifiedString.isEmpty()) {
            char lastChar = modifiedString.charAt(modifiedString.length() - 1);
            int length = modifiedString.length();
            if (length == 1) {
                sum += map.get(String.valueOf(lastChar));
                break;
            }

            char prevChar = modifiedString.charAt(length - 2);

            String doubleNum = "" + prevChar + lastChar;

            if (map.containsKey(doubleNum)) {
                sum += map.get(doubleNum);
                modifiedString = modifiedString.substring(0, length - 2);

            } else {
                sum += map.get(String.valueOf(lastChar));
                modifiedString = modifiedString.substring(0, length - 1);
            }

        }

        return sum;
    }

    public static void main(String[] args) {
        var rti = new RomanToInteger();

        int xxvii = rti.romanToInt("XXVII");
        assert xxvii == 27 : "error 1";

        int iii = rti.romanToInt("III");
        assert iii == 3;

        int lviii = rti.romanToInt("LVIII");
        assert lviii == 58;

        int mcmxciv = rti.romanToInt("MCMXCIV");
        assert mcmxciv == 1994;

    }
}
