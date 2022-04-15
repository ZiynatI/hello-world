package codewars;

public class Task9 {
    public static void main(String[] args) {
        int example = 50;
        System.out.println(summation(example));
    }
//    public static int summation(int n) {
//        int sum = 0;
//        for (int i = 0; i <= n; i++) {
//            sum = sum + i;
//        }
//        return sum;
//    }
    public static int summation(int n) {
        if(n == 1)
            return 1;
        return summation(n-1)+n;
    }
}
