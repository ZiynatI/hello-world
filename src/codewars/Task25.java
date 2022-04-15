package codewars;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Task25 {
    //The goal of this exercise is to convert a string to a new string where each character in the new
    //string is "(" if that character appears only once in the original string, or ")" if that character
    //appears more than once in the original string. Ignore capitalization when determining if a character
    //is a duplicate.
    public static String encode(String word) {
        word = word.toLowerCase(Locale.ROOT);
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            if (!map.containsKey(word.charAt(i))) {
                map.put(word.charAt(i), 1);
            } else {
                map.put(word.charAt(i), map.get(word.charAt(i)) + 1);
            }
        }
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (map.get(word.charAt(i)) == 1) {
                newString.append('(');
            } else if (map.get(word.charAt(i)) > 1) {
                newString.append(')');
            }
        }
        return newString.toString();
    }
}
