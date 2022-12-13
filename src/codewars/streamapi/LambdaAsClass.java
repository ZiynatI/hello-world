package codewars.streamapi;

import java.util.List;

public class LambdaAsClass {
    // .filter(x -> x % 3 == 0)
    public static List<Integer> filter(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 3 != 0) {
                list.remove(i);
            }
        }
        return list;
    }
}
