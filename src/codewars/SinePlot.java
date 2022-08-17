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
        printSineSlotHorizontal(findValuesOfSin(15));
        printSineSlotVertical(findValuesOfSin(15));
    }

    public static List<Double> findValuesOfSin(int n) {
        List<Double> valuesOfSin = new ArrayList<>();
        for (double i = 0; i < n; i += 0.2) {
            valuesOfSin.add(Math.sin(i));
        }
        return valuesOfSin;
    }

    public static void printSineSlotVertical(List<Double> valuesOfSin) {
        String formatter = String.format("%19s", " ");
        for (Double valueOfSin : valuesOfSin) {
            int indexOfCell = (int) ((10 * valueOfSin) + 9);
            System.out.println(formatter.substring(0, indexOfCell) + "*" + formatter.substring(indexOfCell + 1));
        }
    }

    public static void printSineSlotHorizontal(List<Double> valuesOfSin) {
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < valuesOfSin.size(); j++) {
                int valueOfSin = (int) (10 * valuesOfSin.get(j));
                if(valueOfSin==i-9){
                    System.out.print(" * ");
                }else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }
}
