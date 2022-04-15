package org.helloworld.demo;

import java.util.Objects;

public class EqualityDemo {
    public static void main(String[] args) {
        Long a = null;
        Long b = 123123123123123L;
        System.out.println(Objects.equals(a, b));
    }
}
