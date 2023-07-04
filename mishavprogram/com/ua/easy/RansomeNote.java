package mishavprogram.com.ua.easy;

import java.util.HashMap;
import java.util.Map;

public class RansomeNote {

    public boolean canConstruct(String ransomNote, String magazine) {

        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
                'v', 'w', 'x', 'y', 'z'};

        for (char c : alphabet) {
            map.put(c, 0);
        }

        for (char c : magazine.toCharArray()) {
            Integer value = map.get(c);
            map.put(c, ++value);
        }

        for (char c : ransomNote.toCharArray()) {
            Integer value = map.get(c);
            map.put(c, --value);
        }

        long count = map.values().stream().filter(x -> x < 0).count();

        return count == 0;
    }


    public static void main(String[] args) {
        RansomeNote ransomeNote = new RansomeNote();
        System.out.println(ransomeNote.canConstruct("aa", "aab"));
    }


}
