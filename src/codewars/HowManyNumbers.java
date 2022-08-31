package codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HowManyNumbers {
    //    We want to generate all the numbers of three digits where:
    //        the sum of their digits is equal to 10
    //        their digits are in increasing order (the numbers may have two or more equal contiguous digits)
    //    The numbers that fulfill these constraints are: [118, 127, 136, 145, 226, 235, 244, 334].
    //    There are 8 numbers in total with 118 being the lowest and 334 being the greatest.
    //    Task:
    //    Implement a function which receives two arguments:
    //        the sum of digits (sum)
    //        the number of digits (count)
    //    This function should return three values:
    //        the total number of values which have count digits that add up to sum and are in increasing order
    //        the lowest such value
    //        the greatest such value
    //    Note: if there are no values which satisfy these constants, you should return an empty value
    //    (refer to the examples to see what exactly is expected).
    //    Examples:
    //    // The output type is List<Long>
    //    HowManyNumbers.findAll(10, 3)  =>  [8, 118, 334]
    //    HowManyNumbers.findAll(27, 3)  =>  [1, 999, 999]
    //    HowManyNumbers.findAll(84, 4)  =>  []
    //    Features of the random tests:
    //        Number of tests: 112
    //        Sum of digits value between 20 and 65
    //        Amount of digits between 2 and 17

    public static void main(String[] args) {
                System.out.println(anotherSolution(35, 6));
        System.out.println(findAll(35, 6));
        //        System.out.println(findAll(10, 3));
        //        System.out.println(Arrays.toString(shareOne(new int[]{7, 8, 8, 9})));
        //        System.out.println(findAll(35, 6));
//        System.out.println(isRightNumber(123, 6));
    }

//    public static List<Long> findAll(final int sumDigits, final int numDigits) {
//        Long min = (long) Math.pow(10, numDigits - 1);
//        Long max = (long) Math.pow(10, numDigits);
//        List<Long> numbers = new ArrayList<>();
//
//        return recurse(min,max,sumDigits,numbers);
//    }
//
//    public static List<Long> recurse(long min, long max, int sumDigit, List<Long> numbers) {
//        if (min >= max) {
//            return numbers;
//        } else if (isRightNumber(min, sumDigit)) {
//            numbers.add(min);
//        }
//        recurse(min + 1, max, sumDigit, numbers);
//        return numbers;
//    }
//
//    public static boolean isRightNumber(long number, int sumDigits) {
//        while (number > 0) {
//            int digit = (int) (number % 10);
//            sumDigits -= digit;
//            number = (number - digit) / 10;
//            if (number % 10 > digit || sumDigits < 0) {
//                return false;
//            }
//        }
//        return sumDigits == 0;
//    }
        public static List<Long> findAll(final int sumDigits, final int numDigits) {
            if (numDigits * 9 < sumDigits) {
                return new ArrayList<>();
            }
            int[] digits = new int[numDigits];
            int sum = sumDigits;
            for (int numDigit = numDigits - 1; numDigit >= 0; numDigit--) {
                digits[numDigit] = Math.min(sum - numDigit, 9);
                sum -= Math.min(sum - numDigit, 9);
            }
            List<Long> numbers = new ArrayList<>();
            numbers.add(1L);
            numbers.add(arrayToLong(digits));
            int[] subArray = new int[0];
            if (digits[digits.length - 1] - digits[0] <= 1) {
                numbers.add(arrayToLong(digits));
                return numbers;
            } else {
                for (int i = digits.length - 2; i >= 0; i--) {
                    if (digits[i] < digits[i + 1]) {
                        subArray = Arrays.copyOfRange(digits, i, numDigits);
                        break;
                    }
                }
            }

            return recurse(numbers, subArray, digits);

        }

        public static List<Long> recurse(List<Long> numbers, int[] subArray, int[] digits) {
            if (subArray.length == digits.length && subArray[subArray.length - 1] - subArray[0] <= 1) {
                numbers.add(arrayToLong(subArray));
                return numbers;
            } else {
                if (subArray[subArray.length - 1] - subArray[0] <= 1 && subArray.length != digits.length) {
                    subArray = editArrayForNewLength(Arrays.copyOfRange(digits, digits.length - subArray.length - 1, digits.length));
                } else {
                    int[] copyOfSubArray = Arrays.copyOfRange(subArray, 0, subArray.length);
                    if (!Arrays.equals(subArray, shareOne(copyOfSubArray))) {
                        shareOne(subArray);
                    } else {
                        if (!Arrays.equals(subArray, shareOneAnotherTime(copyOfSubArray))) {
                            shareOneAnotherTime(subArray);
                        }
                    }
                }
                numbers.add(arrayToLong(subArray));
                numbers.set(0, numbers.get(0) + 1);
                recurse(numbers, subArray, digits);
            }
            return numbers;
        }

        public static int[] shareOne(int[] subArray) {
            for (int digit = subArray.length - 2; digit >= 0; digit--) {
                if (subArray[digit + 1] - subArray[digit] > 1) {
                    subArray[digit + 1] -= 1;
                    subArray[digit] += 1;
                    break;
                }
            }
            return subArray;
        }

        public static int[] shareOneAnotherTime(int[] subArray) {
            for (int i = subArray.length - 1; i > 0; i--) {
                for (int j = i - 1; j >= 0; j--) {
                    if (subArray[i] - subArray[j] > 1 && subArray[i] - subArray[i - 1] >= 1) {
                        subArray[i] -= 1;
                        subArray[j] += 1;
                        break;
                    }
                }
            }
            return subArray;
        }

        public static Long arrayToLong(int[] digits) {
            long number = 0L;
            for (int digit : digits) {
                number = number * 10 + digit;
            }
            return number;
        }

        public static int[] editArrayForNewLength(int[] subArray) {
            int temp = subArray[0];
            while (subArray[0] != temp + 1) {
                for (int digit = 1; digit <= subArray.length-1; digit++) {
                    if (subArray[digit] - subArray[digit-1] > 1) {
                        subArray[digit] -= 1;
                        subArray[digit-1] += 1;
                        break;
                    }
                }
            }
            return subArray;
        }
    //
    //
    //    //________________________________________________________________________________________________________________________
        public static List<Long> anotherSolution(final int sumDigits, final int numDigits) {
            if (numDigits * 9 < sumDigits) {
                return new ArrayList<>();
            }
            int[] digits = new int[numDigits];
            int sum = sumDigits;
            for (int numDigit = numDigits - 1; numDigit >= 0; numDigit--) {
                digits[numDigit] = Math.min(sum - numDigit, 9);
                sum -= Math.min(sum - numDigit, 9);
            }
            List<Long> numbers = new ArrayList<>();
            numbers.add(1L);
            numbers.add(arrayToLong(digits));
            Long firstNumber = arrayToLong(digits);
            for (Long i = firstNumber + 1; ; i++) {
                if (isInIncreasingOrder(i, sumDigits)) {
                    numbers.add(i);
                    numbers.set(0, numbers.get(0) + 1);
                }
                if (i > 9 * Math.pow(10, numDigits - 1)) {
                    break;
                }
            }
            System.out.println(numbers);
            List<Long> result = new ArrayList<>();
            result.add(numbers.get(0));
            result.add(numbers.get(1));
            result.add(numbers.get(numbers.size() - 1));
            return result;
        }

        public static boolean isInIncreasingOrder(Long number, int sumDigits) {
            int sum = sumDigits;
            while (number > 0) {
                long digit = number % 10;
                number = (number - digit) / 10;
                sum -= digit;
                if (number % 10 > digit || sum < 0) {
                    return false;
                }
            }
            return sum == 0;
        }
    //    public static List<Long> findAll(final int sumDigits, final int numDigits) {
    //        if (numDigits * 9 < sumDigits) {
    //            return new ArrayList<>();
    //        }
    //
    //        int[] digits = new int[numDigits];
    //        int sum = sumDigits;
    //        for (int numDigit = numDigits - 1; numDigit >= 0; numDigit--) {
    //            digits[numDigit] = Math.min(sum - numDigit, 9);
    //            sum -= Math.min(sum - numDigit, 9);
    //        }
    //
    //        List<Long> numbers = new ArrayList<>();
    //        numbers.add(1L);
    //        numbers.add(arrayToLong(digits));
    //        int[] subArray = new int[0];
    //        if (digits[digits.length - 1] - digits[0] <= 1) {
    //            numbers.add(arrayToLong(digits));
    //            return numbers;
    //        } else {
    //            for (int i = digits.length - 2; i >= 0; i--) {
    //                if (digits[i] < digits[i + 1]) {
    //                    subArray = Arrays.copyOfRange(digits, i, numDigits);
    //                    break;
    //                }
    //            }
    //        }
    //
    //        return recurse(numbers, subArray, digits);
    //
    //    }
    //
    //
    //    public static List<Long> recurse(List<Long> numbers, int[] subArray, int[] digits) {
    //        if (subArray.length == digits.length && subArray[subArray.length - 1] - subArray[0] <= 1) {
    //            numbers.add(arrayToLong(subArray));
    //            return numbers;
    //        } else {
    //            if (subArray[subArray.length - 1] - subArray[0] <= 1 && subArray.length != digits.length) {
    //                subArray = Arrays.copyOfRange(digits, digits.length - subArray.length - 1, digits.length);
    //                if (subArray[subArray.length - 1] - subArray[0] <= 1) {
    //                    recurse(numbers, subArray, digits);
    //                } else {
    //                    subArray = editArrayForNewLength(subArray);
    //                }
    //            } else {
    //                shareOne(subArray);
    //            }
    //            numbers.set(0, numbers.get(0) + 1);
    //            recurse(numbers, subArray, digits);
    //        }
    //        return numbers;
    //    }
    //
    //    public static int[] editArrayForNewLength(int[] subArray) {
    //        int temp = subArray[0];
    //        while (subArray[0] != temp + 1) {
    //            for (int digit = subArray.length - 2; digit >= 0; digit--) {
    //                if (subArray[digit + 1] - subArray[digit] > 1) {
    //                    subArray[digit + 1] -= 1;
    //                    subArray[digit] += 1;
    //                }
    //            }
    //        }
    //        return subArray;
    //    }
    //
    //    public static void shareOne(int[] subArray) {
    //        for (int digit = subArray.length - 2; digit >= 0; digit--) {
    //            if (subArray.length > 2 && digit > 0) {
    //                if (subArray[digit + 1] - subArray[digit] == 1 && subArray[digit] - subArray[digit - 1] == 1) {
    //                    subArray[digit + 1] -= 1;
    //                    subArray[digit - 1] += 1;
    //                    break;
    //                }
    //            }
    //            if (subArray[digit + 1] - subArray[digit] > 1) {
    //                subArray[digit + 1] -= 1;
    //                subArray[digit] += 1;
    //                break;
    //            }
    //        }
    //    }
    //
    //    public static Long arrayToLong(int[] digits) {
    //        long number = 0L;
    //        for (int digit : digits) {
    //            number = number * 10 + digit;
    //        }
    //        return number;
    //    }
}
