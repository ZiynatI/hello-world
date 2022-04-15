package org.helloworld.task;

public class Task18 {
    /*
     * сделай интерфейс фигуры с методом подсчёта площади, и два класса-реализации -
     * квадрат и равносторонний треугольник
     */
    public static void main(String[] args) {
        Figure square   = new Square(10);
        Figure triangle = new Triangle(4, 5);
        double sum = square.getArea() + triangle.getArea();
        System.out.println(sum);
    }
}

interface Figure {
    double getArea();
}

class Square implements Figure {
    double a;

    public Square(double a) {
        this.a = a;
    }

    public double getArea() {
        return a * a;
    }
}

class Triangle implements Figure {
    double cathetus1;
    double cathetus2;

    public Triangle(double cathetus1, double cathetus2) {
        this.cathetus1 = cathetus1;
        this.cathetus2 = cathetus2;
    }

    public double getArea() {
        return (cathetus1 * cathetus2) / 2;
    }
}
