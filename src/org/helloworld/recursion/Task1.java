package org.helloworld.recursion;

public class Task1 {
    public static void main(String[] args) {
        System.out.println(countLength("example"));
    }
    //окей) а посчитайте длину строки рекурсивно
    //при этом ты не можешь использовать length(), но можешь isEmpty и substring
    public static int countLength(String s) {
        if (s.isEmpty()) {
            return 0;
        } else {
            return countLength(s.substring(1)) + 1;
        }
    }
}
