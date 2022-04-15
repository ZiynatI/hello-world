package codewars;

import java.util.ArrayList;
import java.util.List;

public class Task27 {
    public static void main(String[] args) {
        System.out.println(tribonacci(new double[]{1, 1, 1}, 10));
    }

    //
    public static double[] tribonacci(double[] s, int n) {
        if(n==0){
            return new double[0];
        }
        if(n==1){
            return new double[]{s[0]};
        }
        if(n==2){
            return new double[]{s[0],s[1]};
        }else if (n==3){
            return s;
        }
        List<Double> bonacciList = new ArrayList<Double>();
        bonacciList.add(s[0]);
        bonacciList.add(s[1]);
        bonacciList.add(s[2]);
        for (int i = 3;i<=n-1; i++) {
            double nextElement = bonacciList.get(i - 1) + bonacciList.get(i - 2) + bonacciList.get(i - 3);
                bonacciList.add(i, nextElement);
        }
        double[] xbonacci = new double[bonacciList.size()];
        for (int i = 0; i <=n-1; i++) {
            xbonacci[i] = bonacciList.get(i);
        }
        return xbonacci;
    }
}
