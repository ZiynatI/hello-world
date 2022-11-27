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
        System.out.println(asList(1, 2, 3, 4, 5).groupBy(x -> x % 2));
        System.out.println(asList(1, 2, 3, 4, 5).reverse());
        System.out.println(squareEveryDigit(9119));
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

    public static int sumOfPositives(LList<Integer> list) {
        return sum(list.filter(y -> y > 0));
    }

    public static int product(LList<Integer> list) {
        return list.fold(1, (x, y) -> x * y);
    }

    public static int squareEveryDigit(int num) {
        String s = Integer.toString(num);
        char[] chars = s.toCharArray();
        Integer[] digits = new Integer[chars.length];
        for (int i = 0; i < chars.length; i++) {
            digits[i] = Character.getNumericValue(chars[i]);
        }
        String result = asList(digits).map(x -> x * x).fold("", (acc, nextNum) -> acc + String.valueOf(nextNum));
        return Integer.parseInt(result);

        //        int n = num;
        //        List<Integer> numsList = new ArrayList<>();
        //        while (n > 0) {
        //            numsList.add(n % 10);
        //            n = (n - n % 10) / 10;
        //        }
        //        Integer[] nums = new Integer[numsList.size()];
        //        for (int i = 0; i < numsList.size(); i++) {
        //            nums[i] = numsList.get(i);
        //        }
        //        LList<Integer> list = asList(nums);
        //        LList<Integer> list2 = list.map(x -> x * x);
        //        String result = list2.fold("", (acc, nextNum) -> acc + String.valueOf(nextNum));
        //        return Integer.parseInt(result);
    }
}
