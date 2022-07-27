package codewars;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FactorToPrimes {

    public static void main(String[] args) {
        System.out.println(factorToPrimes(25));
        System.out.println(factorToPrimes(35));
        System.out.println(factorToPrimes(2));
    }

    public static Map<Integer, Integer> factorToPrimes(int n) {
        Map<Integer, Integer> factorized = new LinkedHashMap<>();
        List<Integer> primeList = new LinkedList<>();
        primeList.add(2);
        int lastPrime = primeList.get(primeList.size() - 1);
        while (n != 1) {
            if (n % lastPrime == 0) {
                n = n / lastPrime;
                if (factorized.containsKey(lastPrime)) {
                    factorized.put(lastPrime, factorized.get(lastPrime) + 1);
                } else {
                    factorized.put(lastPrime, 1);
                }
            }
            if (n % lastPrime != 0) {
                lastPrime = getNextPrime(lastPrime, primeList);
                primeList.add(lastPrime);
            }
        }
        return factorized;
    }

    public static int getNextPrime(int lastPrime, List primeList) {
        int testing = lastPrime + 1;

        for (int i = 0; i < primeList.size(); i++) {
            if (testing % (int) primeList.get(i) == 0) {
                testing++;
                i = 0;
            }
            if (i == primeList.size() - 1) {
                return testing;
            }
        }
        return testing;
    }

}
