package org.helloworld.demo.linkedlist;

public class LListDemo {

    public static void main(String[] args) {
        //        LList<Integer> list1 = asList(10, 5, 8, 2);
        //        Function<Integer, Integer> fn =
        //                x -> x + x * 2;
        //        System.out.println(list1.getTail());
        //        System.out.println(list1.map(fn));
        //        System.out.println(fn.apply(123));
        //        Function<LList<Integer>, Integer> fn2 = LListDemo::sum;
        System.out.println(product(asList(10, 5, 8, 2)));
        System.out.println(asList(10, 5, 8, 2).reduce((x, y) -> x + y));
        System.out.println(asList(10, 5, 8, 2).fold(0, (x, y) -> x + y));
        System.out.println(sum(asList(10, 5, 8, 2)));
        System.out.println(listToString(asList(10, 5, 8, 2)));
        System.out.println(asList(10, 5, 8, 2).reverse());
    }

    public static <T> LList<T> asList(T... elements) {
        LList<T> list2 = Nil.nil();
        for (int i = elements.length - 1; i >= 0; i--) {
            list2 = LList.prepend(elements[i], list2);
        }
        return list2;
    }

    public static int sum(LList<Integer> list) {
        return list.fold(0, (x, y) -> x + y);
    }

    public static <T> String listToString(LList<T> llist) {
        StringBuilder result = llist.fold(new StringBuilder("("), (x, y) -> x.append(y.toString()).append(", "));
        return result.delete(result.length() - 2, result.length()).append(")").toString();
    }

    public static int product(LList<Integer> list) {
        return list.fold(1, (x, y) -> x * y);
    }
}
