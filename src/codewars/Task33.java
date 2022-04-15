package codewars;

import java.util.HashMap;
import java.util.Map;

public class Task33 {
    public static void main(String[] args) {
        System.out.println(order("is2 Thi1s T4est 3a"));
    }

    //Your task is to sort a given string. Each word in the string will contain a single number. This number is the position the word should have in the result.
    //Note: Numbers can be from 1 to 9. So 1 will be the first word (not 0).
    //If the input string is empty, return an empty string. The words in the input String will only contain valid consecutive numbers.
    //"is2 Thi1s T4est 3a"  -->  "Thi1s is2 3a T4est"
    public static String order(String words) {
        String[] wordsWithoutOrder = words.split(" ");
        StringBuilder wordsWithOrder = new StringBuilder();
        Map<Integer, String> wordsMap = arrayToMap(wordsWithoutOrder);
        for (int i = 1; i <= wordsMap.size(); i++) {
            wordsWithOrder.append(wordsMap.get(i));
            if (i != wordsMap.size()) {
                wordsWithOrder.append(" ");
            }
        }
        return wordsWithOrder.toString();
    }

    public static Map<Integer, String> arrayToMap(String[] words) {
        Map<Integer, String> wordsMap = new HashMap<>();
        int wordsIndex;
        for (String word : words) {
            for (int j = 0; j < word.length(); j++) {
                if (Character.isDigit(word.charAt(j))) {
                    wordsIndex = Character.getNumericValue(word.charAt(j));
                    wordsMap.put(wordsIndex, word);
                    break;
                }
            }
        }
        return wordsMap;
    }
}
