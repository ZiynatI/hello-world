package codewars;

import java.util.HashMap;
import java.util.Map;

public class SinePlot {
    //вот тебе другая любопытная задача, не связанная с этой
    //нарисуй график синуса в консоли)
    //типа такого
    //        ********
    //      **        ***
    //    **             **              *
    //                     **          **
    //                       ***    ***
    //                          ****
    public static void main(String[] args) {
        System.out.println("         *\n" +
                "      *      *\n" +
                "    *           *              *\n" +
                "                   *         *\n" +
                "                     *    *\n" +
                "                       *      ");
        System.out.println(Math.sin(Math.toRadians(45)));
        printStrings(sinePlot());
    }

    public static String[] sinePlot() {
        Map<Integer, Integer> stringsOfValues = new HashMap<>();
        stringsOfValues.put(0, 3);
        stringsOfValues.put(30, 2);
        stringsOfValues.put(60, 1);
        stringsOfValues.put(90, 0);
        stringsOfValues.put(120, 1);
        stringsOfValues.put(150, 2);
        stringsOfValues.put(180, 3);
        stringsOfValues.put(210, 4);
        stringsOfValues.put(240, 5);
        stringsOfValues.put(270, 6);
        stringsOfValues.put(300, 5);
        stringsOfValues.put(330, 4);
        stringsOfValues.put(360, 3);
        String[] arrays = new String[]{"             ", "             ", "             ", "             ",
                                       "             ", "             ", "             "};

        int starsIndex = 0;
        for (int i = 0; i <= 360; i += 30) {
            arrays[stringsOfValues.get(i)] = arrays[stringsOfValues.get(i)].substring(0, starsIndex) + "*" + arrays[stringsOfValues.get(i)].substring(starsIndex + 1);
            starsIndex++;
        }
        return arrays;
    }

    public static void printStrings(String[] strings) {
        for (String string : strings) {
            System.out.println(string + "\n");
        }
    }
}
