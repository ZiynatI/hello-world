package codewars;

import java.util.ArrayList;
import java.util.Arrays;
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
        printSineSlotHorizontal(findValuesOfSin(10));
        printSineSlotVertical(findValuesOfSin(15));
    }

    public static List<Double> findValuesOfSin(int n) {
        List<Double> valuesOfSin = new ArrayList<>();
        for (double i = 0; i < n; i += 0.2) {
            valuesOfSin.add(Math.sin(i));
        }
        return valuesOfSin;
    }

    public static void printSineSlotHorizontal(List<Double> valuesOfSin) {
        StringBuilder[] yLines = new StringBuilder[valuesOfSin.size()];
        char[] spaceArray = new char[19];
        Arrays.fill(spaceArray, ' ');
        for (int i = 0; i < valuesOfSin.size(); i++) {
            yLines[i] = new StringBuilder();
            yLines[i].append(spaceArray);
        }

        for (int i = 0; i < valuesOfSin.size(); i++) {
            int indexOfCell = (int) ((10 * valuesOfSin.get(i)) + 9);
            yLines[i].replace(indexOfCell, indexOfCell + 1, "*");
            System.out.println(yLines[i]);
        }
    }

    public static void printSineSlotVertical(List<Double> valuesOfSin) {
        StringBuilder[] xLines = new StringBuilder[19];
        char[] spaceArray = new char[valuesOfSin.size()];
        Arrays.fill(spaceArray, ' ');
        for (int i = 0; i < 19; i++) {
            xLines[i] = new StringBuilder();
            xLines[i].append(spaceArray);
        }
        for (int i = 0; i < valuesOfSin.size(); i++) {
            int indexOfCell = (int) (10 * valuesOfSin.get(i));
            xLines[9 - indexOfCell].replace(i, i + 1, "*");
        }
        for (int i = 0; i < xLines.length; i++) {
            System.out.println(xLines[i]);
        }
    }
}
