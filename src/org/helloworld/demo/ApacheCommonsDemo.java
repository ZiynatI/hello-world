package org.helloworld.demo;

import org.apache.commons.math3.primes.Primes;

public class ApacheCommonsDemo {
    public static void main(String[] args) {
        for (int i = 1; i < 20; ++i) {
            if (Primes.isPrime(i)) {
                System.out.println(i);
            }
        }
    }
}
