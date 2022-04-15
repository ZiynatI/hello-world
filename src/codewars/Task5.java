package codewars;

import java.util.ArrayList;
import java.util.List;

public class Task5 {
    //Write a function to split a string and convert it into an array of words.
    //"Robin Singh" ==> ["Robin", "Singh"]
    //"I" ==> ["I", "love", "arrays", "they", "are", "my", "favorite"]
    public static void main(String[] args) {
        String s = "I love arrays they are my favorite";
        System.out.println(stringToArrayList(s));

    }

    public static String[] stringToArray(String s) {
        int countOfWords = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                countOfWords++;
            }
        }
        String[] stringsArray = new String[countOfWords];
        int wordsIndex = 0;
        StringBuilder nextWord = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                nextWord.append(s.charAt(i));
                if (i == s.length() - 1) {
                    stringsArray[wordsIndex] = new String(nextWord);
                }
            } else {
                stringsArray[wordsIndex] = new String(nextWord);
                wordsIndex++;
                stringsArray[wordsIndex] = "";
                nextWord = new StringBuilder(stringsArray[wordsIndex]);
            }
        }
        return stringsArray;
    }

    public static List<String> stringToArrayList(String s) {
        List<String> stringList = new ArrayList<>();
        StringBuilder nextWord = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                nextWord.append(s.charAt(i));
            } else {
                stringList.add(nextWord.toString());
                nextWord.setLength(0);
            }
        }
        if (nextWord.length() != 0) {
            stringList.add(nextWord.toString());
        }

        Object x = new Object();
        Object y = new Object();
        if (x == y) {
            //
        }

        return stringList;
    }
}
