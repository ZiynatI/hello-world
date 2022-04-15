package codewars;

public class Task21 {
    public static void main(String[] args) {
        System.out.println(validParentheses("r(D)U(((6f8D)wm(J"));
    }
    //Write a function that takes a string of parentheses, and determines if the order of the parentheses is valid.
    //The function should return true if the string is valid, and false if it's invalid.

    public static boolean validParentheses(String parens) {
        int nestingLevel = 0;
        for (int i = 0; i < parens.length(); i++) {
            if (parens.charAt(i) == '(') {
                nestingLevel++;
            } else if (parens.charAt(i) == ')') {
                nestingLevel--;
            }
            if (nestingLevel < 0) {
                return false;
            }
        }
        return nestingLevel == 0;
    }
}