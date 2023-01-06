package org.helloworld.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QRCodeGenerator {
    public static void main(String[] args) {
        System.out.println(storage("HELLO"));
    }

    public static String generateQR(String input) {
        char[] inputArray = input.toCharArray();

        return "";
    }

    public static List<Integer> storage(String s) {
        char[] inputArray = s.toCharArray();
        ArrayList<Integer> list = new ArrayList<>();
        char[] elevenBits = new char[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        char[] sixBits = new char[]{0, 0, 0, 0, 0, 0};
        for (int i = 0; i < inputArray.length; ) {
            String num;
            char[] bits;
            if (i == inputArray.length - 1) {
                num = "000000";
                num = num.substring(0,num.length()) +Integer.toBinaryString(alphanumericMap().get(inputArray[i]));
                i++;
            } else {
                bits = new char[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                num = Integer.toBinaryString(alphanumericMap().get(inputArray[i]) * 45 + alphanumericMap().get(inputArray[i + 1]));
                i = i + 2;
            }
            for (int j = 0; j < num.length(); j++) {
                list.add(Character.getNumericValue(num.charAt(j)));
            }
        }
        return list;
    }

    public static Map<Character, Integer> alphanumericMap() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('0', 0);
        map.put('1', 1);
        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5', 5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);
        map.put('A', 10);
        map.put('B', 11);
        map.put('C', 12);
        map.put('D', 13);
        map.put('E', 14);
        map.put('F', 15);
        map.put('G', 16);
        map.put('H', 17);
        map.put('I', 18);
        map.put('J', 19);
        map.put('K', 20);
        map.put('L', 21);
        map.put('M', 22);
        map.put('N', 23);
        map.put('O', 24);
        map.put('P', 25);
        map.put('Q', 26);
        map.put('R', 27);
        map.put('S', 28);
        map.put('T', 29);
        map.put('U', 30);
        map.put('V', 31);
        map.put('W', 32);
        map.put('X', 33);
        map.put('Y', 34);
        map.put('Z', 35);
        map.put(' ', 36);
        map.put('$', 37);
        map.put('%', 38);
        map.put('*', 39);
        map.put('+', 40);
        map.put('-', 41);
        map.put('.', 42);
        map.put('/', 43);
        map.put(':', 44);
        return map;
    }
}