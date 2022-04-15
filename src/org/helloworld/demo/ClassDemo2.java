package org.helloworld.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClassDemo2 {
    public static void main(String[] args) {
        Wrapper<Integer> wr1 = new Wrapper<>(123);
        Wrapper<Double> wr2 = new Wrapper<>(12.34);

        System.out.println(wr1);
        System.out.println(wr2);

        Object o = ClassDemo2.<Object>getSelf("qweqew");
    }


    public static <T> T getSelf(T t) {
        return t;
    }

    public static class Wrapper<T extends Number> {
        private final T t;

        public Wrapper(T t) {
            this.t = t;
        }

        public T getValue() {
            return t;
        }

        public double getDouble() {
            return t.doubleValue();
        }

        @Override
        public String toString() {
            return "Wrapper{" +
                    "t=" + t +
                    ", double=" + this.getDouble() +
                    '}';
        }
    }
}
