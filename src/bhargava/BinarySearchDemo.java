package bhargava;

public class BinarySearchDemo {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1, 3, 5, 7, 9}, 3));
    }

    public static int binarySearch(int[] numbers, int n) {
        int low = 0;
        int high = numbers.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = numbers[mid];
            if (guess == n) {
                return mid;
            } else if (guess > n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return 0;
    }
}
