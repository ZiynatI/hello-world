package org.helloworld.task;

import java.util.ArrayList;
import java.util.List;

public class QRCodeGenerator {
    public static String generateQR(String input) {
        char[] inputArray = input.toCharArray();

        return "";
    }

    public static List<Integer> storage(String s) {
        char[] inputArray = s.toCharArray();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < inputArray.length; ) {
            String num;
            if (i + 1 == inputArray.length - 1) {
                num = Integer.toBinaryString(inputArray[i]);
                i++;
            } else {
                num = Integer.toBinaryString(inputArray[i] * 45 + inputArray[i + 1]);
                i = i + 2;
            }
            for (int j = 0; j < num.length(); j++) {
                list.add(Character.getNumericValue(num.charAt(j)));
            }
        }
        return list;
    }
}