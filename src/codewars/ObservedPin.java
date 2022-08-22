package codewars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObservedPin {
    //Alright, detective, one of our colleagues successfully observed our target person, Robby the robber.
    //We followed him to a secret warehouse, where we assume to find all the stolen stuff.
    //The door to this warehouse is secured by an electronic combination lock.
    //Unfortunately our spy isn't sure about the PIN he saw, when Robby entered it.
    //The keypad has the following layout:
    //┌───┬───┬───┐
    //│ 1 │ 2 │ 3 │
    //├───┼───┼───┤
    //│ 4 │ 5 │ 6 │
    //├───┼───┼───┤
    //│ 7 │ 8 │ 9 │
    //└───┼───┼───┘
    //    │ 0 │
    //    └───┘
    //He noted the PIN 1357, but he also said, it is possible that each of the digits he saw could actually
    //be another adjacent digit (horizontally or vertically, but not diagonally).
    //E.g. instead of the 1 it could also be the 2 or 4. And instead of the 5 it could also be the 2, 4, 6 or 8.
    //He also mentioned, he knows this kind of locks. You can enter an unlimited amount of wrong PINs,
    //they never finally lock the system or sound the alarm. That's why we can try out all possible (*) variations.
    //* possible in sense of: the observed PIN itself and all variations considering the adjacent digits
    //Can you help us find all those variations? It would be nice to have a function, that returns an array
    //of all variations for an observed PIN with a length of 1 to 8 digits. We could name the function getPINs.
    //But please note that all PINs, the observed one and also the results, must be strings,
    //because of potentially leading '0's. We already prepared some test cases for you.
    //Detective, we are counting on you!

    public static void main(String[] args) {
        System.out.println(getPINs("369"));
    }

    public static List<String> getPINs(String observed) {
        Map<Integer, int[]> pinDigits = new HashMap<>();
        pinDigits.put(0, new int[]{0, 8});
        pinDigits.put(1, new int[]{1, 2, 4});
        pinDigits.put(2, new int[]{1, 2, 3, 5});
        pinDigits.put(3, new int[]{2, 3, 6});
        pinDigits.put(4, new int[]{1, 4, 5, 7});
        pinDigits.put(5, new int[]{2, 4, 5, 6, 8});
        pinDigits.put(6, new int[]{3, 5, 6, 9});
        pinDigits.put(7, new int[]{4, 7, 8});
        pinDigits.put(8, new int[]{0, 5, 7, 8, 9});
        pinDigits.put(9, new int[]{6, 8, 9});
        List<String> resultNotYet = new ArrayList<>();
        List<String> result = new ArrayList<>();
        result.add("");
        for (int k = 0; k < observed.length(); k++) {
            int digit = Character.digit(observed.charAt(k), 10);
            for (int j = 0; j < result.size(); j++) {
                for (int i = 0; i < pinDigits.get(digit).length; i++) {
                    resultNotYet.add(result.get(j) + pinDigits.get(digit)[i]);
                }
            }
            result = resultNotYet;
            resultNotYet = new ArrayList<>();
        }
        return result;
    }
}
