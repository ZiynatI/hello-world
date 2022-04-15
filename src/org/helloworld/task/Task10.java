package org.helloworld.task;

public class Task10 {
    public static void main(String[] args) {
        System.out.println(" = " + checkRoute(new char[]{'n', 's'}));
        System.out.println("nns = " + checkRoute(new char[]{'n', 'n', 's'}));
        System.out.println("nnss = " + checkRoute(new char[]{'n', 'n', 's', 's'}));
        System.out.println("nne = " + checkRoute(new char[]{'n', 'n', 'e'}));
        System.out.println("nnesws = " + checkRoute(new char[]{'n', 'n', 'e', 's', 'w', 's'}));
        System.out.println("... = " + checkRoute(new char[]{'s', 's', 's', 's', 's', 's', 'w', 'w', 'w', 'w', 'w', 'w'}));
        System.out.println("wessw=" + checkRoute(new char[]{'w', 'e', 's', 's', 'w'}));

    }

    /* n, s - да, мы вернулись за 2 минуты
    n, n. e - нет, мы не вернулись в начальную точку
    n, n, e, s, w, s - да, мы вернулись за 6 минут
    s, s, s, s, s, s, w, w, w, w, w, w - нет, слишком долго */
    public static boolean checkRoute(char[] arg1) {
        if (arg1.length > 10) {
            return false;
        }
        int northSteps = 0;
        int eastSteps = 0;
        for (int i = 0; i < arg1.length; i++) {
            switch (arg1[i]) {
                case 'n':
                    northSteps = northSteps + 1;
                    break;
                case 's':
                    northSteps = northSteps - 1;
                    break;
                case 'e':
                    eastSteps = eastSteps + 1;
                    break;
                case 'w':
                    eastSteps = eastSteps - 1;
                    break;
            }
        }
        if (northSteps == 0 && eastSteps == 0) {
            return true;
        } else {
            return false;
        }
    }
}
