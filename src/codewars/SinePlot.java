package codewars;

import java.util.LinkedList;

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

    public static LinkedList<Integer> findValuesOfSin(int n) {
        LinkedList<Integer> valuesOfSin = new LinkedList<>();
        for (double i = 0; i < n; i += 0.2) {
            valuesOfSin.add((int) (10 * Math.sin(i)));
        }
        return valuesOfSin;
    }

    public static void printSineSlot(LinkedList<Integer> valuesOfSin) {
        for (Integer valueOfSin : valuesOfSin) {
            StringBuilder sb = new StringBuilder();
            while (sb.length() != (valueOfSin + 9)) {
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
