package org.helloworld.task;

public class Task7 {
    public static void main(String[] args) {
        System.out.println(solution("world"));

    }

    public static String solution(String str) {
        String str2 = "";
        for (int i = str.length() - 1; i >= 0; i = i - 1){
            str2 = str2 + str.charAt(i);
        }
        return str2;
    }
}
