package codewars.streamapi;

import static org.helloworld.demo.linkedlist.LListDemo.asList;

import java.util.function.Predicate;

public class LambdaAsClass implements Predicate<Integer> {
    public static void main(String[] args) {
        System.out.println(asList(1, 2, 3, 4, 5, 6, 7, 8, 9).filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 3 == 0;
            }
        }));
    }

    @Override
    public boolean test(Integer i) {
        return i % 3 == 0;
    }
}
