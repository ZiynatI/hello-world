package codewars;

import java.util.ArrayList;
import java.util.List;

public class Conversion {
    //Create a function taking a positive integer as its parameter and returning a string containing
    //the Roman Numeral representation of that integer.
    //Modern Roman numerals are written by expressing each digit separately starting with the left most digit
    //and skipping any digit with a value of zero. In Roman numerals 1990 is rendered:
    //1000=M, 900=CM, 90=XC; resulting in MCMXC. 2008 is written as 2000=MM, 8=VIII; or MMVIII.
    //1666 uses each Roman symbol in descending order: MDCLXVI.
    //Example:
    //conversion.solution(1000); //should return "M"
    //Help:
    //Symbol    Value
    //I          1
    //V          5
    //X          10
    //L          50
    //C          100
    //D          500
    //M          1,000
    //Remember that there can't be more than 3 identical symbols in a row.
    //More about roman numerals - http://en.wikipedia.org/wiki/Roman_numerals
    //Algorithms
    //Encoding
    public static void main(String[] args) {
        System.out.println(arabicToRoman(684));
    }

    public static String arabicToRoman(int arabic) {
        if (arabic <= 0 || arabic > 3999) {
            return "";
        }
        List<String> romanList = new ArrayList<>();
        List<Integer> arabicList = new ArrayList<>();
        arabicList.add(1);
        arabicList.add(4);
        arabicList.add(5);
        arabicList.add(9);
        arabicList.add(10);
        arabicList.add(40);
        arabicList.add(50);
        arabicList.add(90);
        arabicList.add(100);
        arabicList.add(400);
        arabicList.add(500);
        arabicList.add(900);
        arabicList.add(1000);
        romanList.add("I");
        romanList.add("IV");
        romanList.add("V");
        romanList.add("IX");
        romanList.add("X");
        romanList.add("XL");
        romanList.add("L");
        romanList.add("XC");
        romanList.add("C");
        romanList.add("CD");
        romanList.add("D");
        romanList.add("CM");
        romanList.add("M");
        int index = arabicList.size() - 1;
        StringBuilder roman = new StringBuilder();
            while (arabic > 0) {
                while (arabic - arabicList.get(index) >= 0) {
                    arabic -= arabicList.get(index);
                    roman.append(romanList.get(index));
                }
                index--;
            }

        return roman.toString();
    }
}
