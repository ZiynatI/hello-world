package codewars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WeightSort {
    //My friend John and I are members of the "Fat to Fit Club (FFC)". John is worried because each month
    //a list with the weights of members is published and each month he is the last on the list which means
    //he is the heaviest.
    //I am the one who establishes the list, so I told him: "Don't worry anymore, I will modify the order
    //of the list". It was decided to attribute a "weight" to numbers. The weight of a number will be
    //from now on the sum of its digits.
    //For example 99 will have "weight" 18, 100 will have "weight" 1 so in the list 100 will come before 99.
    //Given a string with the weights of FFC members in normal order can you give this string ordered by
    //"weights" of these numbers?
    //Example:
    //"56 65 74 100 99 68 86 180 90" ordered by numbers weights becomes:
    //"100 180 90 56 65 74 68 86 99"
    //When two numbers have the same "weight", let us class them as if they were strings (alphabetical ordering) and not numbers:
    //180 is before 90 since, having the same "weight" (9), it comes before as a string.
    //All numbers in the list are positive numbers and the list can be empty.
    //Notes
    //    it may happen that the input string have leading, trailing whitespaces and more than a unique whitespace between two consecutive numbers


    public static void main(String[] args) {
        System.out.println(orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
        System.out.println(orderWeight("59544965313"));
    }

    public static String orderWeight(String strng) {
        if (strng.equals("")) {
            return "";
        }
        String[] weight = strng.split(" ");
        if(weight.length==1){
            return strng;
        }
        int[] weightOfNumber = new int[weight.length];
        for (int i = 0; i < weight.length; i++) {
            int thisWeight = Integer.parseInt(weight[i]);
            int numbersWeight = 0;
            while (thisWeight > 0) {
                numbersWeight += thisWeight % 10;
                thisWeight = (thisWeight - thisWeight % 10) / 10;
            }
            weightOfNumber[i] = numbersWeight;

        }
         sortNumbers(weightOfNumber, weight);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < weight.length; i++) {
            if (i != 0) {
                result.append(" ");
            }
            result.append(weight[i]);
        }
        return result.toString();
    }

    public static String[] sortNumbers(int[] weight, String[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = numbers.length - 1; j > 0; j--) {
                if (weight[j - 1] > weight[j]) {
                    String thisSt = numbers[j - 1];
                    numbers[j - 1] = numbers[j];
                    numbers[j] = thisSt;
                    int a = weight[j - 1];
                    weight[j - 1] = weight[j];
                    weight[j] = a;
                } else if (weight[j - 1] == weight[j]) {
                    if (!isRightAlphabeticalOrder(numbers[j - 1], numbers[j])) {
                        String thisSt = numbers[j - 1];
                        numbers[j - 1] = numbers[j];
                        numbers[j] = thisSt;
                    }
                }
            }
        }
        return numbers;
    }

    public static boolean isRightAlphabeticalOrder(String a, String b) {
        List<String> list = new ArrayList();
        list.add(a);
        list.add(b);
        Collections.sort(list);
        if (!list.get(0).equals(a)) {
            return false;
        }
        return true;
    }
    public class NumbersWithWeight{
        int value;
        int weightOfValue;
    }
}
