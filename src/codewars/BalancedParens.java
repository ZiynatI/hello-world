package codewars;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BalancedParens {
    //Write a function which makes a list of strings representing all of the ways you can balance n pairs of parentheses
    //Examples:
    //balancedParens(0) returns ArrayList<String> with element:  ""
    //balancedParens(1) returns ArrayList<String> with element:  "()"
    //balancedParens(2) returns ArrayList<String> with elements: "()()","(())"
    //balancedParens(3) returns ArrayList<String> with elements: "()()()","(())()","()(())","(()())","((()))"

    public static void main(String[] args) {
        System.out.println(balancedParens(3));
    }

    public static List<String> doList(int n) {
        if (n == 0) {
            return List.of(new String[]{""});
        } else if (n == 1) {
            return List.of(new String[]{"()", "(("});
        } else {
            Iterator<String> iter = doList(n - 1).iterator();
            char leftParenthesis = '(';
            char rightParenthesis = ')';
            List<String> balanced = new ArrayList<>();
            while (iter.hasNext()) {
                String thisString = iter.next();
                balanced.add(thisString + leftParenthesis + leftParenthesis);
                balanced.add(thisString + leftParenthesis + rightParenthesis);
                if (checkString(thisString) >= 2) {
                    balanced.add(thisString + rightParenthesis + rightParenthesis);
                }
                if (checkString(thisString) > 0) {
                    balanced.add(thisString + rightParenthesis + leftParenthesis);
                }
            }
            return balanced;
        }
    }

    public static List<String> balancedParens(int n) {
        List<String> balancedNotAtAll = doList(n);
        for (int i = balancedNotAtAll.size() - 1; i >= 0; i--) {
            if (checkString(balancedNotAtAll.get(i)) != 0) {
                balancedNotAtAll.remove(balancedNotAtAll.get(i));
            }
        }
        return balancedNotAtAll;
    }

    public static int checkString(String s) {
        int nestingLevel = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                nestingLevel++;
            } else {
                nestingLevel--;
            }
        }
        return nestingLevel;
    }

    //    public static List<String> balancedParens(int n) {
    //        if (n == 0) {
    //            return List.of(new String[]{""});
    //        }
    //        List<String> balanced = new ArrayList<>();
    //        balanced.add("(");
    //        for (int i = 1; i < n * 2; i++) {
    //            int index = balanced.size();
    //            for (int j = 0; j < index; j++) {
    //                String thisString = balanced.get(j);
    //                if (isBalanced(thisString, '(') < n) {
    //                    balanced.add(thisString + "(");
    //                }
    //                if (isBalanced(thisString, ')') > 0) {
    //                    balanced.add(thisString + ")");
    //                }
    //            }
    //            for (int j = 0; j < index; j++) {
    //                balanced.remove(0);
    //            }
    //        }
    //        return balanced;
    //    }
    //
    //
    //    public static int isBalanced(String s, char parenthes) {
    //        if (parenthes == ')') {
    //            int balance = 0;
    //            for (int i = 0; i < s.length(); i++) {
    //                if (s.charAt(i) == '(') {
    //                    balance++;
    //                } else if (s.charAt(i) == ')') {
    //                    balance--;
    //                }
    //            }
    //            return balance;
    //        } else {
    //            int opening = 0;
    //            for (int i = 0; i < s.length(); i++) {
    //                if (s.charAt(i) == '(') {
    //                    opening++;
    //                }
    //            }
    //            return opening;
    //        }
    //    }
}

