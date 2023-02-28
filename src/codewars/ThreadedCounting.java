package codewars;

import java.util.function.Function;

public class ThreadedCounting {
    //https://www.codewars.com/kata/549e70e994e517ed8b00043e
    //Your task is simple. You have to call counter.count(int) with the numbers 1 to 100 inclusive.
    //So a simple solution might look like this:
    //for (int i = 1; i <= 100; i++) {
    //  counter.count(i);
    //}
    //But there's a catch. Your solution also has to satisfy the following conditions:
    //    Three different threads must be used
    //    Numbers of the form 3n (multiples of 3) must be called in one thread
    //    Numbers of the form 3n + 1 must be called in a second
    //    Numbers of the form 3n + 2 must be called in a third
    //    The numbers have to be called in sequence 1 to 100
    //Also, make sure your method doesn't return until all three threads have completed.
    //Otherwise, the tests may not work even if your solution is correct.

    public static void countInThreads2(int i, Function f) {
        Thread one = new Thread(()-> f(i));
        Thread two = new Thread(() -> {
            for (int i = 2; i <= 100; i = i + 3) {
                counter.count(i);
            }
        });
        Thread three = new Thread(() -> {
            for (int i = 3; i <= 100; i = i + 3) {
                counter.count(i);
            }
        });

    }

    static class Counter {
        public int count(int i) {
            return 0;
        }
    }
}
