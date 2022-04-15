package codewars;

public class Task1 {
    //Your task is to write a function which returns the sum of following series upto nth term(parameter).
    //Series: 1 + 1/4 + 1/7 + 1/10 + 1/13 + 1/16 +...
    public static void main(String[] args) {
        System.out.println(seriesSum(10));
    }

    public static String seriesSum(int n) {
        double numerator = 1;
        double denominator = 4;
        double summ = 1;
        for (int i = 1; i < n; i++) {
            summ = summ + (numerator / (denominator + 3));
            denominator = denominator + 3;
        }
        String sumString = Double.toString(summ);
        return sumString;

    }
}


