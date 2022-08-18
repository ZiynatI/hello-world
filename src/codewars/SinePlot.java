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
        plotSinHorSimple();
    }

    public static List<Double> findValuesOfSin(int n) {
        List<Double> valuesOfSin = new ArrayList<>();
        for (double i = 0; i < n; i += 0.2) {
            valuesOfSin.add(Math.sin(i));
        }
        return valuesOfSin;
    }

    public static void printSineSlotHorizontal(List<Double> valuesOfSin) {
        double plusY = 0.1;
        for (double y = 1.0; y > -1.0; y -= plusY) {
            for (Double valueOfSin : valuesOfSin) {
                if (y <= valueOfSin && valueOfSin < y + plusY) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void printSineSlotVertical(List<Double> valuesOfSin) {
        double plusY = 0.1;
        for (Double valueOfSin : valuesOfSin) {
            for (double y = -1.0; y < 1.0; y += plusY) {
                if (y <= valueOfSin && valueOfSin < y + plusY) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static void plotSinHorSimple() {
        int xIntervals = 200;
        int yIntervals = 20;

        double xMin = 0;
        double xMax = 4 * Math.PI;
        double xStep = (xMax - xMin) / xIntervals;

        List<Double> values = new ArrayList<>();
        for (double x = xMin; x <= xMax; x += xStep) {
            values.add(Math.sin(x));
        }

        double yMin = -1.0;
        double yMax = 1.0;
        double yStep = (yMax - yMin) / yIntervals;

        for (double y = yMax; y >= yMin; y -= yStep) {
            for (double value : values) {
                if (value <= y && value >= (y - yStep)) {
                    System.out.print("*");
                } else if (0 <= y && 0 >= (y - yStep)) {
                    System.out.print("-");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
