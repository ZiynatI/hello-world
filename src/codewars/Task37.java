package codewars;

import java.util.ArrayList;
import java.util.List;

public class Task37 {
    //In this kata you will create a function that takes a list of non-negative integers and strings and
    //returns a new list with the strings filtered out.
    public static List<Object> filterList(final List<Object> list) {
        List<Object> filtered = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getClass() == Integer.class) {
                filtered.add(list.get(i));
            }
        }
        return filtered;
    }
}
