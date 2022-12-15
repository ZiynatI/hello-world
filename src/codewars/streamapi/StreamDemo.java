package codewars.streamapi;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        List<Integer> list = Stream.of(1,2,3,4,5,6,7,8,9).map(x->x*3).filter(x->x%3==0).collect(Collectors.toList());
        System.out.println(list); }
}
