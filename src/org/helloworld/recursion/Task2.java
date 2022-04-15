package org.helloworld.recursion;

public class Task2 {
    public static void main(String[] args) {
        System.out.println(fromOneToN(10));
    }
    //У вас есть натуральное число n. Необходимо вывести все числа от 1 до n.
    public static String fromOneToN(int n){
        StringBuilder sb = new StringBuilder();
        if(n==1){
            return "1";
        }else {
            return fromOneToN(n-1)+n;
        }
    }
}
