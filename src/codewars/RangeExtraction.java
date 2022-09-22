package codewars;

public class RangeExtraction {
    //https://www.codewars.com/kata/51ba717bb08c1cd60f00002f
    //A format for expressing an ordered list of integers is to use a comma separated list of either
    //    individual integers
    //    or a range of integers denoted by the starting integer separated from the end integer in the range by a dash, '-'. The range includes all integers in the interval including both endpoints. It is not considered a range unless it spans at least 3 numbers. For example "12,13,15-17"
    //Complete the solution so that it takes a list of integers in increasing order and returns a correctly formatted string in the range format.
    //Example:
    //Solution.rangeExtraction(new int[] {-10, -9, -8, -6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20})
    //# returns "-10--8,-6,-3-1,3-5,7-11,14,15,17-20"
    //Courtesy of rosettacode.org
    public static void main(String[] args) {
        System.out.println(rangeExtraction(new int[]{-10, -9, -8, -6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20}));
        System.out.println(rangeExtraction(new int[]{-3, -2, -1, 2, 10, 15, 16, 18, 19, 20}));
        System.out.println(rangeExtraction(new int[]{-10, -9, -6, -3, 0, 2 - 4, 6, 7, 8, 10}));
    }

    public static String rangeExtraction(int[] arr) {
        StringBuilder numbers = new StringBuilder();
        for (int i = 0; i < arr.length - 1; i++) {
            numbers.append(arr[i]);
            if (i < arr.length - 2) {
                if (arr[i + 1] - arr[i] == 1 && arr[i + 2] - arr[i + 1] == 1) {
                    while (arr[i + 1] - arr[i] == 1) {
                        if (i + 1 == arr.length - 1) {
                            numbers.append("-").append(arr[i + 1]);
                            break;
                        }
                        i++;
                    }
                    if (i + 1 != arr.length - 1) {
                        numbers.append("-").append(arr[i]);
                    }
                }
            }
            if (i + 1 != arr.length - 1) {
                numbers.append(",");
            }
        }
        return numbers.toString();
    }
}
