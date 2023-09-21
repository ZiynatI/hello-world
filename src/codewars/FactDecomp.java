package codewars;

import java.util.*;

public class FactDecomp {
    /*https://www.codewars.com/kata/5a045fee46d843effa000070*/
    /*The aim of the kata is to decompose n! (factorial n) into its prime factors.

    Examples:

    n = 12; decomp(12) -> "2^10 * 3^5 * 5^2 * 7 * 11"
    since 12! is divisible by 2 ten times, by 3 five times, by 5 two times and by 7 and 11 only once.

    n = 22; decomp(22) -> "2^19 * 3^9 * 5^4 * 7^3 * 11^2 * 13 * 17 * 19"

    n = 25; decomp(25) -> 2^22 * 3^10 * 5^6 * 7^3 * 11^2 * 13 * 17 * 19 * 23

    Prime numbers should be in increasing order. When the exponent of a prime is 1 don't put the exponent.

    Notes

        the function is decomp(n) and should return the decomposition of n! into its prime factors in increasing order of the primes,
        as a string.
        factorial can be a very big number (4000! has 12674 digits, n can go from 300 to 4000).
        In Fortran - as in any other language - the returned string is not permitted to contain any redundant trailing whitespace:
        you can use dynamically allocated character strings.
    * */

    public static void main(String[] args) {
        System.out.println(decomp(17));
    }

    public static String decomp(int n) {
        Map<Integer, Integer> result = new HashMap<>();
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            breakIntoPrimes(i, result, primes);
        }
        return collectString(result, primes);
    }

    public static void breakIntoPrimes(int number, Map<Integer, Integer> result, List<Integer> primes) {

        int n = number;
        for (int i : primes) {
            int power = 0;
            while (n % i == 0) {
                power++;
                n = n / i;
            }
            if (power > 0) {
                if (result.containsKey(i)) {
                    result.put(i, result.get(i) + power);
                } else {
                    result.put(i, 1);
                }
            }
        }
        if (n != 1 && isPrime(primes, n)) {
            primes.add(n);
            result.put(n, 1);
        }
    }

    public static boolean isPrime(List<Integer> primes, int number) {
        int sqrtNumber = (int) Math.sqrt(number);
        for (int i : primes) {
            if (i >= sqrtNumber) {
                break;
            } else {
                return number % i != 0;
            }
        }
        return true;
    }

    public static String collectString(Map<Integer, Integer> result, List<Integer> primes) {
        StringBuilder sb = new StringBuilder();
        boolean start = true;
        for (int prime : primes) {
            if (result.containsKey(prime)) {
                if (start) {
                    start = false;
                } else {
                    sb.append(" * ");
                }
                sb.append(prime);
                int power = result.get(prime);
                if (power != 1) {
                    sb.append('^').append(power);
                }
            }
        }
        return sb.toString();
    }
}
