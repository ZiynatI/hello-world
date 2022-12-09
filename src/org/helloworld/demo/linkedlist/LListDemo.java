package org.helloworld.demo.linkedlist;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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
        //        System.out.println(asList(1, 2, 3, 4, 5, 6, 7, 8, 9).drop(2));
        //        System.out.println(asList(2, 4, 6, 8, 10, 11, 12, 14, 16, 18, 20).dropWhile(x -> x % 2 == 0));
        //        System.out.println(LList.concat(asList(1, 2, 3, 4, 5), asList(5.0, 6.2, 7.4)));
        //        System.out.println(asList(1, 2, 3, 4, 5));
        //        System.out.println(LList.rangeInclusive(5, 1));
        //        System.out.println(asList(1, 2, 3, 4, 5).maxBy(s -> s));
        //        System.out.println(repeat("hello", 5));
        //        System.out.println(towerBuilder(6).mkString("\n"));
        //        System.out.println(asList(1, 2, null, 4, 5));
        //        System.out.println(isValid("([{}])"));
        //        System.out.println(isValid("(){}[]"));
        //        System.out.println(isValid("({)}"));
        System.out.println(isValid(new char[]{'n', 'n', 'n', 's', 'n', 's', 'n', 's', 'n', 's'}));
        System.out.println(isValid(new char[]{'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's'}));
        System.out.println(Arrays.asList(1, 3, 5, 8)
                .stream()
                .map(x -> x.toString())
                .collect(Collectors.joining(" + ")));
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

    public static String repeat(String s, int n) {
        if (n == 0) {
            return "";
        }
        LList<Integer> intList = LList.rangeInclusive(1, n);
        return intList.map(x -> s).mkString("");
    }

    public static LList<String> towerBuilder(int nFloors) {
        LList<Integer> list = LList.rangeInclusive(1, nFloors);
        return list.map(x -> {
            String spaces = repeat(" ", nFloors - x);
            return spaces + repeat("*", x * 2 - 1) + spaces;
        });
    }

    //Write a function that takes a string of braces, and determines if the order of the braces is valid.
    //It should return true if the string is valid, and false if it's invalid.
    //This Kata is similar to the Valid Parentheses Kata, but introduces new characters: brackets [], and curly braces {}.
    //All input strings will be nonempty, and will only consist of parentheses, brackets and curly braces: ()[]{}.
    //What is considered Valid?
    //A string of braces is considered valid if all braces are matched with the correct brace.
    public static boolean isValid(String braces) {
        Map<Character, Character> bracesMap = new HashMap<>();
        bracesMap.put('(', ')');
        bracesMap.put('[', ']');
        bracesMap.put('{', '}');
        LList<Character> charsList = asList(braces.toCharArray());
        LList<Character> accList = charsList.fold(Nil.nil(), (list, nextBrace) -> {
            if (list.isEmpty()) {
                return LList.prepend(nextBrace, list);
            }
            if (nextBrace.equals(bracesMap.get(list.getHead()))) {
                return list.getTail();
            }
            return LList.prepend(nextBrace, list);
        });
        return accList.isEmpty();
    }

    //You will be given a number and you will need to return it as a string in Expanded Form.
    //For example:
    //Kata.expandedForm(12); # Should return "10 + 2"
    //Kata.expandedForm(42); # Should return "40 + 2"
    //Kata.expandedForm(70304); # Should return "70000 + 300 + 4"
    public static String expandedForm(int num) {
        String intSt = String.valueOf(num);
        return asList(Integer.toString(num).toCharArray())
                .zip(LList.rangeInclusive(intSt.length() - 1, 0))
                .filter(x -> x.getLeft() != '0')
                .map(x -> x.getLeft() + repeat("0", x.getRight()))
                .mkString(" + ");
    }

    public static boolean isValid(char[] route) {
        Pair<Integer, Integer> start = new Pair<>(0, 0);
        return asList(route)
                .fold(start, (pair, direction) -> {
                    switch (direction) {
                        case 'n':
                            return pair.withLeft(pair.left + 1);
                        case 's':
                            return pair.withLeft(pair.left - 1);
                        case 'e':
                            return pair.withRight(pair.right + 1);
                        case 'w':
                            return pair.withRight(pair.right - 1);
                    }
                    return pair;
                }).equals(start);
    }
}
