package codewars;

import java.util.ArrayList;
import java.util.List;

public class Task16 {
    public static void main(String[] args) {
        System.out.println(expandedForm(12));
        System.out.println(expandedForm(42));
        System.out.println(expandedForm(70304));
    }

    //    You will be given a number and you will need to return it as a string in Expanded Form. For example:
    //            Kata.expandedForm(12); # Should return "10 + 2"
    //            Kata.expandedForm(42); # Should return "40 + 2"
    //            Kata.expandedForm(70304); # Should return "70000 + 300 + 4"
    //    NOTE: All numbers will be whole numbers greater than 0.
    public static String expandedForm(int num) {
        StringBuilder expandedSB = new StringBuilder();
        List<Integer> expandedList = expandNum(num);
        for (int i = expandedList.size() - 1; i >= 0; i--) {
            expandedSB.append(expandedList.get(i));
            if (i != 0) {
                expandedSB.append(" + ");
            }
        }
        return expandedSB.toString();
    }

    public static List<Integer> expandNum(int num) {
        List<Integer> expanded = new ArrayList<>();
        int pow = 0;
        while (num > 0) {
            int thisDigit = num % 10;
            if (thisDigit != 0) {
                expanded.add((int) (thisDigit * Math.pow(10, pow++)));
            }
            num = (num - thisDigit) / 10;
        }
        return expanded;
    }
}
