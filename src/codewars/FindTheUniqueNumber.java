package codewars;

import java.util.HashMap;
import java.util.Map;

public class FindTheUniqueNumber {
    //https://www.codewars.com/kata/585d7d5adb20cf33cb000235
    //There is an array with some numbers. All numbers are equal except for one. Try to find it!
    //Kata.findUniq(new double[]{ 1, 1, 1, 2, 1, 1 }); // => 2
    //Kata.findUniq(new double[]{ 0, 0, 0.55, 0, 0 }); // => 0.55
    //It’s guaranteed that array contains at least 3 numbers.
    //The tests contain some very huge arrays, so think about performance.
    public static double findUnique(double[] arr) {
        Map<Double, Integer> map = new HashMap<>();
        for (double d : arr) {
            if (map.containsKey(d)) {
                map.put(d, map.get(d) + 1);
            } else {
                map.put(d, 1);
            }
        }
        for (Map.Entry<Double, Integer> num : map.entrySet()) {
            if (num.getValue() == 1) {
                return num.getKey();
            }
        }
        return 0;
    }

}
