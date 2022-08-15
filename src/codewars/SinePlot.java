package codewars;

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
        System.out.println(Math.sin(Math.toRadians(45)));
        printStrings(sinePlot());
    }

    public static String[] sinePlot() {
        String[] strings = new String[]{"       ", "       ", "       ", "       ", "       ", "       ", "       ",
                "       ", "       ", "       ", "       ", "       ", "       "};
        int starsIndex = 2;
        for (int i = 0; i <= 360; i += 30) {
            double sin = Math.sin(Math.toRadians(i));
            if (sin > Math.sin(Math.toRadians(i - 1))) {
                starsIndex++;
            } else {
                starsIndex--;
            }
            strings[i / 30] = strings[i / 30].substring(0, starsIndex) + "*" + strings[i / 30].substring(starsIndex + 1);
        }
        return strings;
    }

    public static void printStrings(String[] strings) {
        for (String string : strings) {
            System.out.println(string + "\n");
        }
    }
}
