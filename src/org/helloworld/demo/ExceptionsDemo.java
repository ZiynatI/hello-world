package org.helloworld.demo;

public class ExceptionsDemo {
    public static void main(String[] args) {
        try {
            mainWrapper();
        } catch (MyException ex) {
            System.err.println("MyException!!!! " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("EXCEPTION!!!! " + ex.getMessage());
        }
    }

    public static void mainWrapper() {
        System.out.println(sqrt(25));
        try {
            System.out.println(sqrt(-1));
        } catch (IllegalArgumentException ex) {
            System.err.println("IllegalArgumentException!!!! " + ex.getMessage());
        }

        System.out.println(div(10, 5));
        System.out.println(div(10, 0));
    }

    public static int sqrt(int x) throws ArithmeticException {
        if (x < 0) {
            throw new MyException("Square root of a negative number!!!!!!");
        }
        return (int) Math.sqrt(x);
    }

    public static int div(int x, int y) {
        if (y == 0) {
            throw new MyException("Divided by zero!!!!!!!!!!!");
        }
        return x / y;
    }

    public static class MyException extends RuntimeException {
        public MyException(String message) {
            super(message);
        }
    }
}
