package codewars;

import java.math.BigInteger;

public class Padovan {
    //The Padovan sequence is the sequence of integers P(n) defined by the initial values
    //P(0)=P(1)=P(2)=1
    //and the recurrence relation
    //P(n)=P(n-2)+P(n-3)
    //The first few values of P(n) are
    //1, 1, 1, 2, 2, 3, 4, 5, 7, 9, 12, 16, 21, 28, 37, 49, 65, 86, 114, 151, 200, 265, ...
    //Task
    //The task is to write a method that returns i-th Padovan number for i around 1,000,000
    //Examples
    //    Padovan.Get(0) == 1
    //    Padovan.Get(1) == 1
    //    Padovan.Get(2) == 1
    //    Padovan.Get(n) == Padovan.Get(n-2) + Padovan.Get(n-3)
    //Hint: use matrices

    public static void main(String[] args) {
        System.out.println(get(1000000));
    }

    public static BigInteger get(long power) {
        BigInteger k = BigInteger.valueOf(1);
        BigInteger l = BigInteger.valueOf(1);
        BigInteger m = BigInteger.valueOf(1);
        BigInteger n;
        int index = 2;
        do {
            n = l.add(k);
            k = l;
            l = m;
            m = n;
            index++;
        } while (index != power);
        return n;
    }
}
