package codewars;

public class Task15 {
    public static void main(String[] args) {
        System.out.println(abbrevName("patrick feeney"));
    }

    //Write a function to convert a name into initials.
    //This kata strictly takes two words with one space in between them.
    //The output should be two capital letters with a dot separating them.
    //It should look like this:
    //Sam Harris => S.H
    //patrick feeney => P.F
    public static String abbrevName(String name) {
        StringBuilder initialsSB = new StringBuilder();
        initialsSB.append(name.charAt(0));
        initialsSB.append('.');
        initialsSB.append(name.charAt(name.indexOf(' ', 1) + 1));
        return initialsSB.toString().toUpperCase();
    }
}
