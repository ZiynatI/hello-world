package codewars;

public class Dinglemouse {
    //https://www.codewars.com/kata/596b2b9d9e2fbd7811000046
    //The code provided is supposed to execute method1 and method2 in different threads.
    //
    //But it's not working properly.
    //Task
    //
    //Fix the bug so we can all go home early.
    //Notes
    //
    //This link won't help solve this Kata, but it may explain my choice of class names.
    //
    //:-)
    private static class Logan5 implements Runnable {
        public void run() {
            System.out.println("Hello from Logan5");
        }
    }

    private static class Jessica6 implements Runnable {
        public void run() {
            System.out.println("Hello from Jessica6");
        }
    }

    public static void runRunners() {
        new Thread(new Logan5()).start();
        new Thread(new Jessica6()).start();
    }
}
