package codewars;

public class Task14 {
    public static void main(String[] args) {
        System.out.println(sum(new int[]{1, -4, 7, 12}));
    }

    //You get an array of numbers, return the sum of all of the positives ones.
    //Example [1,-4,7,12] => 1 + 7 + 12 = 20
    //Note: if there is nothing to sum, the sum is default to 0.
    public static int sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                sum = sum + arr[i];
            }
        }
        return sum;
    }
}
