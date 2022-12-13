package codewars.streamapi;

import java.util.function.*;

public class Functional {
    /*Part1*/
    //Write a Function (with the appropriate types) that returns true if a given student
    //is "John Smith" with a student number of "js123" (otherwise return false).
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

    public static Function<Student, Boolean> f = x -> (x.getFullName().equals("John Smith")) && (x.studentNumber.equals("js123"));

    /*Part2*/
    //Write a function that sets the area of the given Triangle and returns the area as a double.
    //Do not use the function type Function; there is a function type for converting an arbitrary class into a double, use that.
    //The formula for triangle area is: 1/2 * base * height
    //Assume valid input (base and height are both greater than 0).
    //A full listing of the default function types can be found at
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

    public static IntUnaryOperator create(int addTo) {
        IntUnaryOperator fn = x -> x + addTo;
        return fn;
    }

    /*Part4*/

    class DragonsCurve {
        public IntFunction<String> mapFunction = x -> {
            if (x == 'a') {
                return "aRbFR";
            } else if (x == 'b') {
                return "LFaLb";
            } else {
                return x + "";
            }
        }; //Make the function; map the chars to Strings
        //a -> aRbFR, b -> LFaLb, otherwise -> itself

        /**
         * Make the curve; stream the chars repeatedly (starting with Fa) through the mapFunction n times Then remove
         * the a and b (createFilter function is useful for that)
         */
        public String createCurve(int n) {
            "Fa".chars(); //That's an IntStream with 'F' and 'a' ready to be acted upon
            return "Fa";
        }

        /**
         * How many of the specified char are in the given curve? Hint: createFilter could be useful for this
         */
        public long howMany(char c, String curve) {
            return 4L; //Determined by die roll; guaranteed to be random
        }

        /**
         * Create a predicate to filter the specified char; keep or remove based on keep variable
         */
        public IntPredicate createFilter(char filterWhat, boolean keep) {
            return null; //Dat predicate
        }
    }
}



