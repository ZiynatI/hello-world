package codewars;

import java.util.*;

public class CountingDuplicates {
    public static void main(String[] args) {
        System.out.println(duplicateCount("aa"));
        System.out.println(duplicateCount("indivisibility"));
    }

    //Write a function that will return the count of distinct case-insensitive alphabetic characters and
    //numeric digits that occur more than once in the input string. The input string can be assumed to contain
    //only alphabets (both uppercase and lowercase) and numeric digits
    public enum SymbolsPresence {
        ONETIME,
        TWOTIMES,
        MORETHANTWO
    }

    public static int duplicateCount(String text) {
        text = text.toLowerCase(Locale.ROOT);
        Map<Character, SymbolsPresence> symbols = new HashMap<>();
        int duplicates = 0;
        for (int i = 0; i < text.length(); i++) {
            char thisChar = text.charAt(i);
            if (symbols.containsKey(thisChar)) {
                switch (symbols.get(thisChar)) {
                    case TWOTIMES:
                        symbols.put(thisChar, SymbolsPresence.MORETHANTWO);
                        break;
                    case ONETIME:
                        duplicates++;
                        symbols.put(thisChar, SymbolsPresence.TWOTIMES);
                        break;
                }
            } else {
                symbols.put(thisChar, SymbolsPresence.ONETIME);
            }
        }
        return duplicates;
    }
}
