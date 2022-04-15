package codewars;

import java.util.Arrays;

public class Task36 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dataReverse(new int[]{0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1})));
    }
    //A stream of data is received and needs to be reversed.
    //Each segment is 8 bits long, meaning the order of these segments needs to be reversed, for example:
    //11111111  00000000  00001111  10101010
    // (byte1)   (byte2)   (byte3)   (byte4)
    //should become:
    //10101010  00001111  00000000  11111111
    // (byte4)   (byte3)   (byte2)   (byte1)
    //The total number of bits will always be a multiple of 8.
    //The data is given in an array as such:
    //[1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,1,0,1,0,1,0]

    public static int[] dataReverse(int[] data) {
        int[] newData = new int[data.length];
        int end = data.length;
        int start = end - 8;
        int index = 0;
        while (start >= 0) {
            for (int i = start; i < end; i++) {
                newData[index] = data[i];
                index++;
            }
            end -= 8;
            start -= 8;
        }
        return newData;
    }
}
