package codewars;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Task24 {
    public static void main(String[] args) {
        System.out.println(check("h yubgjile ptkqr z dfwocnm xsva"));
        System.out.println(check("zzz z z zzzz"));
    }
    //A pangram is a sentence that contains every single letter of the alphabet at least once. For example, the sentence
    //"The quick brown fox jumps over the lazy dog" is a pangram, because it uses the letters A-Z at least once
    // (case is irrelevant).Given a string, detect whether or not it is a pangram. Return True if it is, False if not. Ignore numbers and punctuation.
    public static boolean check(String sentence) {
        sentence = sentence.toLowerCase(Locale.ROOT);
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 0);
        map.put("b", 0);
        map.put("c", 0);
        map.put("d", 0);
        map.put("e", 0);
        map.put("f", 0);
        map.put("g", 0);
        map.put("h", 0);
        map.put("i", 0);
        map.put("j", 0);
        map.put("k", 0);
        map.put("l", 0);
        map.put("m", 0);
        map.put("n", 0);
        map.put("o", 0);
        map.put("p", 0);
        map.put("q", 0);
        map.put("r", 0);
        map.put("s", 0);
        map.put("t", 0);
        map.put("u", 0);
        map.put("v", 0);
        map.put("w", 0);
        map.put("x", 0);
        map.put("y", 0);
        map.put("z", 0);
        for (int i = 0; i < sentence.length(); i++) {
            String key = String.valueOf(sentence.charAt(i));
            if (map.containsKey(key)) {
                map.put(String.valueOf(key), map.get(key) + 1);
            }
        }
        if (map.containsValue(0)) {
            return false;
        } else {
            return true;
        }
    }
}