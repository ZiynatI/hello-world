package codewars.oop;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Leetspeak extends Encoder {
    //https://www.codewars.com/kata/543bfbecdef6345f52000e4d
    //General Objective
    //The objective of this Kata is to provide some way to encode a string into its leetspeak version.
    //Specific Instructions
    //    The code must contain a Leetspeak "133tSp34k" class inherited from an Encoder abstract class and containing an encode(String) method returning itself the encoded String.
    //    The encode method should return an empty String if a null parameter is passed.
    //    If any uppercase character is given, it should be compared also with the dictionary, 'a' gives '4' but 'A' gives also '4'.
    //    If any character outside the dictionary is given, it should be output as is.
    //Dictionary to reproduce
    //
    //The following dictionary has to be used :
    //a -> 4
    //e -> 3
    //l -> 1
    //m -> /^^\
    //o -> 0
    //u -> (_)

    public String encode(String source) {
        Map<Character, String> dictionary = new HashMap<>();
        dictionary.put('a', "4");
        dictionary.put('e', "3");
        dictionary.put('l', "1");
        dictionary.put('m', "/^^\\");
        dictionary.put('o', "0");
        dictionary.put('u', "(_)");
        // TODO - Encode the source string into a 133tSp34k string
        if (source == null) {
            return "";
        }
        String lc = source.toLowerCase(Locale.ROOT);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (dictionary.containsKey(lc.charAt(i))) {
                result.append(dictionary.get(lc.charAt(i)));
            } else {
                result.append(source.charAt(i));
            }
        }
        return result.toString();
    }

}

abstract class Encoder {
    public abstract String encode(String source);
}
