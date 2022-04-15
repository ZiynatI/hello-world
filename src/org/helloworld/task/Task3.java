package org.helloworld.task;

public class Task3 {

    public static void main(String[] args) {
        System.out.println(getTriangleType(5, 5, 7.8));
        System.out.println(getTriangleType(5, 5, 5));
        System.out.println(getTriangleType(3, 5, 4));
    }

    public static String getTriangleType(double a, double b, double c) {
        // Make a <= b <= c
        if (a > b) {
            double temp = a;
            a = b;
            b = temp;
        }
        if (a > c) {
            double temp = a;
            a = c;
            c = temp;
        }
        if (b > c) {
            double temp = b;
            b = c;
            c = temp;
        }

        // v
        if (a == b && b == c) {
            return "Равносторонний";
        } else if (c > a + b) {
            return "Невозможный";
        } else {
            boolean isSimple = true;
            String s = "";
            if (a == b || b == c || a == c) {
                s = s + "Равнобедренный";
                isSimple = false;
            }

            if (a * a + b * b == c * c) {
                s = s + "Прямоугольный";
                isSimple = false;
            }

            if (isSimple) {
                s = s + "Простой";
            }

            return s;
        }
    }
}

