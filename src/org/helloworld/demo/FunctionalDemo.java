package org.helloworld.demo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionalDemo {
    public static void main(String[] args) {
        {
            Function<Integer, String> fn = FunctionalDemo::myStaticFunc;
            System.out.println(fn.apply(10));
        }

        {
            FunctionalDemo instance = new FunctionalDemo();
            Function<Integer, String> fn = instance::myFunc;
            System.out.println(fn.apply(10));
        }

        {
            Consumer<Integer> c = FunctionalDemo::myConsumer;
            Supplier<Integer> s = FunctionalDemo::mySupplier;
            c.accept(s.get());
        }

        chainCall(
                () -> 123,
                (i) -> i * i,
                System.out::println);

        System.out.println(sumOfSquares(Arrays.asList(5, 1, 10, 13, 7, 5)));

    }

    public static String myStaticFunc(int i) {
        return "Called myStaticFunc(" + i + ")";
    }

    public String myFunc(int i) {
        return "Called myFunc(" + i + ")";
    }


    public static void myConsumer(int i) {
        System.out.println("myConsumer(" + i + ")");
    }

    public static int mySupplier() {
        return 123;
    }

    public static int sumOfSquares(List<Integer> list) {
        return list.stream()
                .map((i) -> i * i)
                .reduce(0, Integer::sum);
    }

    public static void chainCall(Supplier<Integer> supplier,
                                 Function<Integer, Integer> transform,
                                 Consumer<Integer> consumer) {
        consumer.accept(transform.apply(supplier.get()));
    }
}