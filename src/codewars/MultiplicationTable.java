package codewars;

import java.util.Arrays;

public class MultiplicationTable {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(multiplicationTable(3)));
    }
    //https://www.codewars.com/kata/534d2f5b5371ecf8d2000a08
    //Your task, is to create N×N multiplication table, of size provided in parameter.
    //For example, when given size is 3:
    //1 2 3
    //2 4 6
    //3 6 9
    //For the given example, the return value should be:
    //[[1,2,3],[2,4,6],[3,6,9]]

    public static int[][] multiplicationTable(int n) {
        int[][] mul = new int[n][n];
        int num = 1;
        for (int i = 0; i < n; i++) {
            mul[0][i] = num;
            mul[i][0]=num;
            num++;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                mul[i][j] = mul[j][0] * (i+1);
            }
        }
        return mul;
    }
}
