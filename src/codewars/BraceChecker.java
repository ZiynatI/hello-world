package codewars;

import java.util.HashMap;
import java.util.Map;

public class BraceChecker {
    //Write a function that takes a string of braces, and determines if the order of the braces is valid.
    //It should return true if the string is valid, and false if it's invalid.
    //This Kata is similar to the Valid Parentheses Kata, but introduces new characters: brackets [], and curly braces {}.
    //All input strings will be nonempty, and will only consist of parentheses, brackets and curly braces: ()[]{}.
    //What is considered Valid?
    //A string of braces is considered valid if all braces are matched with the correct brace.
    //Examples:
    //"(){}[]"   =>  True
    //"([{}])"   =>  True
    //"(}"       =>  False
    //"[(])"     =>  False
    //"[({})](]" =>  False
    public static void main(String[] args) {
        System.out.println(isValid("(){}[]"));
    }

    public static boolean isValid(String braces) {
        Map<Character, Character> bracesMap = new HashMap<>();
        bracesMap.put('(', ')');
        bracesMap.put('[', ']');
        bracesMap.put('{', '}');
        StringBuilder solver = new StringBuilder();
        for (int i = 0; i < braces.length(); i++) {
            if(!bracesMap.containsKey(braces.charAt(i))&&solver.length()==0){
                return false;
            }
            if (bracesMap.containsKey(braces.charAt(i))) {
                solver.append(braces.charAt(i));
            } else if (braces.charAt(i) == bracesMap.get(solver.charAt(solver.length() - 1))) {
                solver.deleteCharAt(solver.length() - 1);
            } else {
                return false;
            }
        }
        return solver.length()==0;
    }
}