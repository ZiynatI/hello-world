package codewars;

import java.util.LinkedHashMap;
import java.util.Map;

public class FactorToPrimes {

    public static void main(String[] args) {
        System.out.println(factorToPrimes(25));
        System.out.println(factorToPrimes(35));
        System.out.println(factorToPrimes(17));
    }

    public static Map<Integer, Integer> factorToPrimes(int n) {
        Map<Integer, Integer> factorized = new LinkedHashMap<>();
        int lastPrime = 2;
        int sqrt = (int) Math.sqrt(n);
        while (n != 1) {
            while (n % lastPrime == 0) {
                n = n / lastPrime;
                if (factorized.containsKey(lastPrime)) {
                    factorized.put(lastPrime, factorized.get(lastPrime) + 1);
                } else {
                    factorized.put(lastPrime, 1);
                }
            }
            if (lastPrime>=sqrt){
                lastPrime=n;
            }else {
            lastPrime++;}
        }
        return factorized;
    }

}
