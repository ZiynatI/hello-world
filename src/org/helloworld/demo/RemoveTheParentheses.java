package org.helloworld.demo;

public class RemoveTheParentheses {
    //https://www.codewars.com/kata/5f7c38eb54307c002a2b8cc8
    //In this kata you are given a string for example:
    //"example(unwanted thing)example"
    //Your task is to remove everything inside the parentheses as well as the parentheses themselves.
    //The example above would return:
    //"exampleexample"
    //Notes
    //    Other than parentheses only letters and spaces can occur in the string.
    //    Don't worry about other brackets like "[]" and "{}" as these will never appear.
    //    There can be multiple parentheses.
    //    The parentheses can be nested.
    public static String removeParentheses(final String str) {
        StringBuilder sb = new StringBuilder();
        int openingParentheses = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                openingParentheses++;
            } else if (str.charAt(i) == ')') {
                openingParentheses--;
            } else {
                if (openingParentheses == 0) {
                    sb.append(str.charAt(i));
                }
            }
        }
        return sb.toString();
    }
}
