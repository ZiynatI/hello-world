package codewars.streamapi;

import java.util.stream.IntStream;

public class FibonacciFunctional {
    public static void main(String[] args) {
        System.out.println(stream(0, 1));
    }

    //Write a function stream(int a, int b) -> IntStream that produces the Fibonacci sequence
    //where the first two elements are a and b. Here's the catch: you only get one semicolon!
    public static IntStream stream(int a, int b) {
        //FIXME Too many semicolons!
        return IntStream.concat(
                IntStream.of(a, b),
                IntStream.generate(() -> {
                    return a + b;
                })
        );
    }
}


