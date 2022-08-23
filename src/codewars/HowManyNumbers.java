package codewars;

import java.util.ArrayList;
import java.util.List;

public class HowManyNumbers {
    //We want to generate all the numbers of three digits where:
    //    the sum of their digits is equal to 10
    //    their digits are in increasing order (the numbers may have two or more equal contiguous digits)
    //The numbers that fulfill these constraints are: [118, 127, 136, 145, 226, 235, 244, 334].
    //There are 8 numbers in total with 118 being the lowest and 334 being the greatest.
    //Task:
    //Implement a function which receives two arguments:
    //    the sum of digits (sum)
    //    the number of digits (count)
    //This function should return three values:
    //    the total number of values which have count digits that add up to sum and are in increasing order
    //    the lowest such value
    //    the greatest such value
    //Note: if there are no values which satisfy these constants, you should return an empty value
    //(refer to the examples to see what exactly is expected).
    //Examples:
    //// The output type is List<Long>
    //HowManyNumbers.findAll(10, 3)  =>  [8, 118, 334]
    //HowManyNumbers.findAll(27, 3)  =>  [1, 999, 999]
    //HowManyNumbers.findAll(84, 4)  =>  []
    //Features of the random tests:
    //    Number of tests: 112
    //    Sum of digits value between 20 and 65
    //    Amount of digits between 2 and 17

    public static void main(String[] args) {
        System.out.println(findAll(10, 3));
        System.out.println(findLowestValue(35, 6));
        System.out.println(findGreatestValue(35, 6));
        System.out.println(redoString("900"));

    }

    public static List<Long> findAll(final int sumDigits, final int numDigits) {
        String lowestValue = Long.toString(findLowestValue(sumDigits, numDigits));
        String greatestValue = Long.toString(findGreatestValue(sumDigits, numDigits));
        // Your code here!!
        List<String> llist = recurse("", lowestValue, greatestValue, 1);
        List<Long> result = new ArrayList<>();
        result.add((long) llist.size());
        result.add(Long.parseLong(lowestValue));
        result.add(Long.parseLong(greatestValue));
        return result;
    }

    public static List<String> recurse(String value, String lowestValue, String greatestValue, int currentDigit) {
        if (lowestValue.length() == value.length()) {
            return List.of(value);
        } else {
            List<String> values = new ArrayList<>();
            while (!redoString(value).equals(values)) {
                values.addAll(recurse(value.substring(0, currentDigit - 1) + redoString(value.substring(currentDigit)), lowestValue, greatestValue, currentDigit));
                value = redoString(value);
            }
            return values;
        }

    }

    public static String redoString(String value) {
        StringBuilder thisValue = new StringBuilder(value);
        for (int i = thisValue.length() - 2; i >= 0; i--) {
            int previous = Character.getNumericValue(thisValue.charAt(i + 1));
            int current = Character.getNumericValue(thisValue.charAt(i));
            if (previous - current > 1) {
                String sbst = current + 1 + String.valueOf(previous - 1);
                thisValue.replace(i, i + 2, sbst);
                break;
            }
        }
        return thisValue.toString();
    }


    public static long findLowestValue(final int sumDigits, final int numDigits) {
        long lowestValue = 0;
        int minDigit = 1;
        int maxDigit = 9;
        int sum = sumDigits;
        int count = numDigits;
        while (sum > 0 && count != 0) {
            if ((count - 1) * minDigit <= sum - minDigit && (count - 1) * maxDigit >= sum - minDigit) {
                lowestValue = lowestValue * 10 + minDigit;
                count--;
                sum -= minDigit;
            } else {
                minDigit++;
            }
        }
        return lowestValue;
    }

    public static long findGreatestValue(final int sumDigits, final int numDigits) {
        int sum = sumDigits;
        long greatestValue = 0;
        int index = 0;
        int countDigits = numDigits;
        while (sum > 0) {
            double lastDigit = (double) sum / (double) countDigits;
            double ceiled = Math.ceil(lastDigit);
            greatestValue = (long) (ceiled * Math.pow(10, index) + greatestValue);
            sum -= ceiled;
            countDigits--;
            index++;
        }
        return greatestValue;
    }
    //    public static List<Long> findAll2(final int sumDigits, final int numDigits) {
    //        if (numDigits > sumDigits) {
    //            return new ArrayList<>();
    //        }
    //
    //        int[] digits = new int[numDigits];
    //        long lowestValue = findLowestValue(sumDigits, numDigits);
    //        List<Long> numbers = new ArrayList<>();
    //        numbers.add(lowestValue);
    //        for (int i = digits.length - 1; i >= 0; i--) {
    //            digits[i] = (int) (lowestValue % 10);
    //            lowestValue = (lowestValue - lowestValue % 10) / 10;
    //        }
    //        for (int i = 0; i < numDigits; i++) {
    //            for (int j = 0; j < numDigits; j++) {
    //                if (j < numDigits - 1) {
    //                    while (digits[j + 1] - 1 >= digits[j] + 1) {
    //                        digits[j + 1] -= 1;
    //                        digits[j] += 1;
    //                        long nextNum = 0;
    //                        for (int k = 0; k < numDigits; k++) {
    //                            nextNum = nextNum * 10 + digits[k];
    //                        }
    //                        numbers.add(nextNum);
    //                        if (j > 0 && digits[j] - digits[j - 1] > 1 && digits[j + 1] - digits[j] > 1) {
    //
    //                            //                            if (digits[j - 1] + 1 <= digits[j]) {
    //
    //                            numbers.add(checkAnotherTime(digits, j));
    //
    //                        }
    //                    }
    //                }
    //
    //
    //            }
    //        }
    //        return numbers;
    //    }
    //
    //    public static long checkAnotherTime(int[] digits, int j) {
    //        int[] copyArr = digits.clone();
    //        copyArr[j - 1] += 1;
    //        copyArr[j] -= 1;
    //        long nextNum = 0;
    //        for (int k = 0; k < copyArr.length; k++) {
    //            nextNum = nextNum * 10 + copyArr[k];
    //        }
    //        return nextNum;
    //    }
    //
    //    public static List<Long> findAll(final int sumDigits, final int numDigits) {
    //        if (numDigits > sumDigits) {
    //            return new ArrayList<>();
    //        }
    //        long lowestValue = findLowestValue(sumDigits, numDigits);
    //        List<Long> numbers = new ArrayList<>();
    //        for (long i = lowestValue; i < (long) Math.pow(10, numDigits); i++) {
    //            long num = i;
    //            int sum = 0;
    //            while (num > 0) {
    //                sum += num % 10;
    //                num = (num - num % 10) / 10;
    //            }
    //            if (sum == sumDigits && isInIncreasingOrder(i)) {
    //                numbers.add(i);
    //            }
    //        }
    //        List<Long> result = new ArrayList<>();
    //        result.add((long) numbers.size());
    //        result.add(numbers.get(0));
    //        result.add(numbers.get(numbers.size() - 1));
    //        return result;
    //    }
    //
    //
    //    public static boolean isInIncreasingOrder(long number) {
    //        long num = number;
    //        int tail = (int) (num % 10);
    //        num = (num - tail) / 10;
    //        while (num > 0) {
    //            if (num % 10 > tail) {
    //                return false;
    //            }
    //            tail = (int) (num % 10);
    //            num = (num - num % 10) / 10;
    //        }
    //        return true;
    //    }
}
