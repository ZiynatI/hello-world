package codewars.streamapi;

import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;

public class Functional {
    /*Part1*/
    //Write a Function (with the appropriate types) that returns true if a given student
    //is "John Smith" with a student number of "js123" (otherwise return false).

    public static Function<Student, Boolean> f = x -> (x.getFullName().equals("John Smith")) && (x.studentNumber.equals("js123"));

    /*Part2*/
    //Write a function that sets the area of the given Triangle and returns the area as a double.
    //Do not use the function type Function; there is a function type for converting an arbitrary class into a double, use that.
    //The formula for triangle area is: 1/2 * base * height
    //Assume valid input (base and height are both greater than 0).
    //A full listing of the default function types can be found at
    public static ToDoubleFunction<Triangle> fn = x -> {
        double area = x.base * x.height * 0.5;
        x.setArea(area);
        return x.getArea();
    };

    /*Part3*/
    //Write a factory that creates adder functions.
    //Depending on what is passed to the create method, the function will, when called,
    //add that amount to another amount given to the function. In other words:
    //f = AdderFactory.create(1); //Adds 1 to everything
    //f.applyAsInt(4) == 5;
    //f.applyAsInt(10) == 11;
    //f.applyAsInt(-5) == -4;

    public static ToIntFunction<Integer> create(int addTo) {
        ToIntFunction<Integer> fn  = x->x+addTo;
        return fn;
    }
}

class Student {
    private final String firstName;
    private final String lastName;
    public final String studentNumber;

    public Student(String firstName, String lastName, String studentNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getCommaName() {
        return lastName + ", " + firstName;
    }
}

class Triangle {
    public final int height;
    public final int base;
    private double area;

    Triangle(int height, int base) {
        this.height = height;
        this.base = base;
    }

    public void setArea(double a) {
        area = a;
    }

    public double getArea() {
        return area;
    }
}