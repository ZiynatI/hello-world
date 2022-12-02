package org.helloworld.demo.linkedlist;

public class LListDemo {

    public static void main(String[] args) throws Exception {
        //        LList<Integer> list1 = asList(10, 5, 8, 2);
        //        Function<Integer, Integer> fn =
        //                x -> x + x * 2;
        //        System.out.println(list1.getTail());
        //        System.out.println(list1.map(fn));
        //        System.out.println(fn.apply(123));
        //        Function<LList<Integer>, Integer> fn2 = LListDemo::sum;
        //        System.out.println(asList(10, 5, -8, 2).filter(x -> x > 0));
        //        System.out.println(product(asList(10, 5, 8, 2)));
        //        System.out.println(asList(10, 5, 8, 2).reduce((x, y) -> x + y));
        //        System.out.println(asList(10, 5, 8, 2).fold(0, (x, y) -> x + y));
        //        System.out.println(sum(asList(10, 5, 8, 2)));
        //        System.out.println(listToString(asList(10, 5, 8, 2)));
        //        LList<Integer> testLlist = Nil.nil();
        //                System.out.println(asList("hi", "hello", "oh").groupBy(x -> x.length()));
        //        System.out.println(asList(10, 5, 8, 2).foldRight(5, (x, y) -> x + y));
        //        System.out.println(asList(10, 5, 8, 2).mkString("_"));
        //        System.out.println(sumOfPositives(asList(1, 3, -5, 6 - 2)));
        //
        //        System.out.println(asList("George Raymond Richard Martin".split(" ")).map(x -> x.substring(0, 1)).mkString(""));
        //        System.out.println(asList(1, 2, 3, 4, 5).groupBy(x -> x % 2));
        //        System.out.println(asList(1, 2, 3, 4, 5).reverse());
        //        System.out.println(squareEveryDigit(9119));
        //        System.out.println(toCamelCase("the-stealth-warrior"));
        System.out.println(asList(1, 2, 3, 4, 5, 6, 7, 8, 9).drop(2));
        System.out.println(asList(2, 4, 6, 8, 10, 11, 12, 14, 16, 18, 20).dropWhile(x -> x % 2 == 0));
//        System.out.println(asList(1, 2, 3, 4, 5).concat(asList(5.0,6.2,7.4)));
        System.out.println(asList(1, 2, 3, 4, 5));
        System.out.println(LList.rangleInclusive(5,1));
    }

    public static <T> LList<T> asList(T... elements) {
        LList<T> list = Nil.nil();
        for (int i = elements.length - 1; i >= 0; i--) {
            list = LList.prepend(elements[i], list);
        }
        return list;
    }

    public static LList<Character> asList(char[] arr) {
        LList<Character> list = Nil.nil();
        for (int i = arr.length - 1; i >= 0; i--) {
            list = LList.prepend(arr[i], list);
        }
        return list;
    }

    //    public static LList<String> asList(String[] arr) {
    //        LList<Character> list = Nil.nil();
    //        for (int i = arr.length - 1; i >= 0; i--) {
    //            list = LList.prepend(arr[i], list);
    //        }
    //        return list;
    //    }
    public static int sum(LList<Integer> list) {
        return list.fold(0, (x, y) -> x + y);
    }

    public static <T> String listToString(LList<T> llist) {
        StringBuilder result = llist.fold(new StringBuilder("("), (x, y) -> x.append(y.toString()).append(", "));
        return result.delete(result.length() - 2, result.length()).append(")").toString();
    }

    public static int sumOfPositives(LList<Integer> list) {
        return sum(list.filter(y -> y > 0));
    }

    public static int product(LList<Integer> list) {
        return list.fold(1, (x, y) -> x * y);
    }

    public static int squareEveryDigit(int num) {
        String s = Integer.toString(num);
        Character[] charsArray = s.chars()
                .mapToObj(i -> (char) i)
                .toArray(Character[]::new);
        String st = asList(charsArray)
                .map(x -> Character.getNumericValue(x))
                .map(x -> x * x)
                .mkString("");
        return Integer.parseInt(st);
    }

    public static String toCamelCase(String s) {
        String[] arr = s.split("(\\-|_)+");
        LList<String> list = asList(arr);
        LList<String> list2 = LList.prepend(list.getHead(), list.getTail().map(x -> Character.toUpperCase(x.charAt(0)) + x.substring(1)));
        return list2.mkString("");
    }
}
