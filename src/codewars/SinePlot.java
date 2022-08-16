package codewars;

import java.util.ArrayList;
import java.util.List;

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
        printSineSlot(findValuesOfSin(10));
    }

    public static List<Double> findValuesOfSin(int n) {
        List<Double> valuesOfSin = new ArrayList<>();
        for (double i = 0; i < n; i += 0.2) {
            valuesOfSin.add(Math.sin(i));
        }
        return valuesOfSin;
    }

    public static void printSineSlot(List<Double> valuesOfSin) {
        for (Double valueOfSin : valuesOfSin) {
            StringBuilder sb = new StringBuilder();
            while (sb.length() != ((int) (10 * valueOfSin) + 9)) {
                sb.append(" ");
            }
            sb.append("*");
            while (sb.length() != 19) {
                sb.append(" ");
            }
            System.out.println(sb);
        }
    }
}
