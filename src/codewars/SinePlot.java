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
        sinePlot(7);
    }

    public static void sinePlot(int n) {
        String example = "              ";
        int starsIndex = 2;
        for (int i = 0; i <= n; i++) {
            double sin = Math.sin(i);
            if (sin > Math.sin(i - 1)) {
                starsIndex++;
            } else {
                starsIndex--;
            }

            System.out.println(example.substring(0, starsIndex * 2) + "*" + example.substring(starsIndex * 2 + 1));
        }
    }
}
