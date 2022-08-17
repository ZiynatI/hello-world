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
        printSineSlotVertical(findValuesOfSin(15));
        printSineSlotHorizontal(findValuesOfSin(15));
    }

    public static List<Double> findValuesOfSin(int n) {
        List<Double> valuesOfSin = new ArrayList<>();
        for (double i = 0; i < n; i += 0.2) {
            valuesOfSin.add(Math.sin(i));
        }
        return valuesOfSin;
    }

    public static void printSineSlotHorizontal(List<Double> valuesOfSin) {
        for (double y = -1.0; y < 1.0; y += 0.1) {
            for (Double valueOfSin : valuesOfSin) {
                if (y <= valueOfSin && valueOfSin < y + 0.1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void printSineSlotVertical(List<Double> valuesOfSin) {
        for (Double valueOfSin : valuesOfSin) {
            for (double y = -1.0; y < 1.0; y += 0.1) {
                if (y <= valueOfSin && valueOfSin < y + 0.1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
