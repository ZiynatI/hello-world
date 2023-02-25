package codewars;

import java.util.ArrayList;
import java.util.List;

public class ConvertNumberToReversedArrayOfDigits {
    //https://www.codewars.com/kata/5583090cbe83f4fd8c000051
    //Convert number to reversed array of digits
    //Given a random non-negative number, you have to return the digits of this number within an array in reverse order.
    //Example(Input => Output):
    //35231 => [1,3,2,5,3]
    //0 => [0]
    public static int[] digitize(long n) {
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            int tail = (int) (n % 10);
            list.add(tail);
            n = (n - tail) / 10;
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
