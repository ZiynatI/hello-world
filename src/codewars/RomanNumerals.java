package codewars;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumerals {
    //Create a RomanNumerals class that can convert a roman numeral to and from an integer value.
    //It should follow the API demonstrated in the examples below.
    //Multiple roman numeral values will be tested for each helper method.
    //Modern Roman numerals are written by expressing each digit separately starting with the left most digit
    //and skipping any digit with a value of zero.
    //In Roman numerals 1990 is rendered: 1000=M, 900=CM, 90=XC; resulting in MCMXC.
    //2008 is written as 2000=MM, 8=VIII; or MMVIII. 1666 uses each Roman symbol in descending order: MDCLXVI.
    //Input range : 1 <= n < 4000
    //In this kata 4 should be represented as IV, NOT as IIII (the "watchmaker's four").
    //Examples
    //RomanNumerals.toRoman(1000) // should return 'M'
    //RomanNumerals.fromRoman("M") // should return 1000
    //Help
    //Symbol 	Value
    //I 	    1
    //IV 	    4
    //V 	    5
    //X 	    10
    //L 	    50
    //C 	    100
    //D 	    500
    //M 	    1000

    public static void main(String[] args) {
        System.out.println(toRoman(546));
        System.out.println(fromRoman("MMVIII"));
        System.out.println(fromRoman("MCMXC"));
        System.out.println(fromRoman("MDCLXVI"));

    }

    public static Map<Integer, String> numbers() {
        Map<Integer, String> numbers = new LinkedHashMap<>();
        numbers.put(1000, "M");
        numbers.put(900, "CM");
        numbers.put(500, "D");
        numbers.put(400, "CD");
        numbers.put(100, "C");
        numbers.put(90, "XC");
        numbers.put(50, "L");
        numbers.put(40, "XL");
        numbers.put(10, "X");
        numbers.put(9, "IX");
        numbers.put(5, "V");
        numbers.put(4, "IV");
        numbers.put(1, "I");

        return numbers;
    }


    public static String toRoman(int arabic) {
        Map<Integer, String> numbers = numbers();
        StringBuilder roman = new StringBuilder();
        for (Map.Entry<Integer, String> num : numbers.entrySet()) {
            while (arabic >= num.getKey()) {
                roman.append(num.getValue());
                arabic = arabic - num.getKey();
            }
        }
        return roman.toString();
    }

    public static int fromRoman(String roman) {
        Map<Integer, String> numbers = numbers();
        int arabic = 0;
        int index = 0;
        for (Map.Entry<Integer, String> num : numbers.entrySet()) {
            while (index < roman.length() && (roman.startsWith(num.getValue(), index))) {
                arabic += num.getKey();
                index += num.getValue().length();
            }
        }
        return arabic;
    }
}
