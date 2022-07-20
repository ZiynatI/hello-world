package codewars;

import java.util.HashMap;
import java.util.Map;

public class Task39 {
    //In this kata we want to convert a string into an integer. The strings simply represent the numbers in words.
    //Examples:
    //    "one" => 1
    //    "twenty" => 20
    //    "two hundred forty-six" => 246
    //    "seven hundred eighty-three thousand nine hundred and nineteen" => 783919
    //Additional Notes:
    //    The minimum number is "zero" (inclusively)
    //    The maximum number, which must be supported is 1 million (inclusively)
    //    The "and" in e.g. "one hundred and twenty-four" is optional, in some cases it's present and in others it's not
    //    All tested numbers are valid, you don't need to validate them
    public static int parseInt(String numStr) {
        Map<String, Integer> numbers = new HashMap<>();
        numbers.put("zero", 0);
        numbers.put("one", 1);
        numbers.put("two", 2);
        numbers.put("three", 3);
        numbers.put("four", 4);
        numbers.put("five", 5);
        numbers.put("six", 6);
        numbers.put("seven", 7);
        numbers.put("eight", 8);
        numbers.put("nine", 9);
        numbers.put("ten", 10);
        numbers.put("eleven", 11);
        numbers.put("twelve", 12);
        numbers.put("thirteen", 13);
        numbers.put("fourteen", 14);
        numbers.put("fifteen", 15);
        numbers.put("sixteen", 16);
        numbers.put("seventeen", 17);
        numbers.put("eighteen", 18);
        numbers.put("nineteen", 19);
        numbers.put("twenty", 20);
        numbers.put("thirty", 30);
        numbers.put("zero", 0);
        numbers.put("zero", 0);
        numbers.put("zero", 0);
        numbers.put("zero", 0);
        numbers.put("zero", 0);
        numbers.put("zero", 0);
        numbers.put("zero", 0);
        numbers.put("zero", 0);
        numbers.put("zero", 0);
        numbers.put("zero", 0);

        return -1;
    }

    }

