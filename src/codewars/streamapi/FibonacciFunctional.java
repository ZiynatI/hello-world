package codewars.streamapi;

public class FibonacciFunctional {
    //https://www.codewars.com/kata/59e625bf3d09a7471d00020e
    //Write a function stream(int a, int b) -> IntStream that produces the Fibonacci sequence
    //where the first two elements are a and b. Here's the catch: you only get one semicolon!
    public static java.util.stream.IntStream stream(int a, int b) {
        return java.util.stream.Stream
                .iterate(new int[]{a, b}, c -> new int[]{c[1], c[0] + c[1]})
                .mapToInt(x -> x[0]);
    }
}

