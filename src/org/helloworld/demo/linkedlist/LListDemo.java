package org.helloworld.demo.linkedlist;

import java.util.function.Function;

public class LListDemo {

    public static void main(String[] args) {
        LList<Integer> list1 = asList(10, 5, 8, 2);
        Function<Integer, Integer> fn =
                x -> x + x * 2;
        System.out.println(list1.getTail());
        System.out.println(list1.map(fn));
        System.out.println(fn.apply(123));
        Function<LList<Integer>, Integer> fn2 = LListDemo::sum;

//        Predicate<LList> pred = x -> (x % 2 == 0);
    }

    public static <T> LList<T> asList(T... elements) {
        LList<T> list2 = Nil.nil();
        for (int i = elements.length - 1; i >= 0; i--) {
            list2 = LList.prepend(elements[i], list2);
        }
        return list2;
    }

    public static int sum(LList<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        } else {
            return sum(list.getTail()) + list.getHead();
        }
    }

    public static int product(LList<Integer> list) {
        if (list.isEmpty()) {
            return 1;
        } else {
            return product(list.getTail()) * list.getHead();
        }
    }

}
