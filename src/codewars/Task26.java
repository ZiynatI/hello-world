package codewars;

import java.util.Comparator;
import java.util.stream.Collectors;

public class Task26 {
    public static void main(String[] args) {
        System.out.println(findChildren("aAbaBb"));
    }

    //Place all people in alphabetical order where Mothers are followed by their children,
    //i.e. "aAbaBb" => "AaaBbb".
    static String findChildren(final String text) {
        Comparator<Character> cmp = Comparator.naturalOrder();
        return text.chars()
                .boxed()
                .sorted((Integer ci1, Integer ci2) -> {
                    char c1 = (char) ci1.intValue();
                    char c2 = (char) ci2.intValue();
                    char cl1 = Character.toLowerCase(c1);
                    char cl2 = Character.toLowerCase(c2);
                    int cmpResult = cmp.compare(cl1, cl2);
                    if (cmpResult != 0) {
                        return cmpResult;
                    }
                    return cmp.compare(c1, c2);
                })
                .map(el -> Character.valueOf((char) el.intValue()).toString())
                .collect(Collectors.joining());
    }
}