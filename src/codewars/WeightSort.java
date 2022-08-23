package codewars;

import java.util.Objects;

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
        for (int i = 0; i < weight.length; i++) {
            int num = Integer.parseInt(weight[i]);

        }
        return "";
    }

    public static class NumbersWithWeight {
        public final int value;
        public final int weightOfValue;

        public NumbersWithWeight(int value, int weightOfValue) {
            this.value = value;
            this.weightOfValue = weightOfValue;
        }


        public int getWeightOfValue(int value) {
            int sum = 0;
            for (int n = value; n > 0; n /= 10) {
                sum += n % 10;
            }
            return sum;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            NumbersWithWeight that = (NumbersWithWeight) o;
            return value == that.value && weightOfValue == that.weightOfValue;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, weightOfValue);
        }
    }
}
