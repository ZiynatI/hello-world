package codewars;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(validParentheses2("()"));
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
    public static boolean validParentheses2(String parenStr) {
        int sum = 0;
        for(int i = 0; i<parenStr.length();i++){
            if(parenStr.charAt(i)=='('){
                sum++;
            }else if(parenStr.charAt(i)==')'){
                sum--;
            }if(sum<0){
                return false;
            }
        }
        return sum==0;
    }
}