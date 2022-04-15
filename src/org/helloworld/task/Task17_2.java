package org.helloworld.task;

import java.util.ArrayList;
import java.util.Scanner;

public class Task17_2 { public static void main(String[] args) {
    //решето Эратосфена
    //ты определяешь дальнейшие простые числа с помощью уже определённых тобой ранее простых чисел
    //замени массив на список
    System.out.println("Введите число");
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    System.out.println(arrayToString(getPrimesUpTo(n)));

}

    public static ArrayList getPrimesUpTo(int lastNumber) {
        long startTimeMs = System.currentTimeMillis();
        ArrayList<Integer> primeArrayList = new ArrayList<>();
        int newElementsNumber = 1;
        primeArrayList.add(0, 2);
        for (int i = 3; i < lastNumber; i++) {
            boolean isPrime = true;
            double sqrt = Math.sqrt(i);
            for (int j = 0; ; j++) {
                if (primeArrayList.get(i) > sqrt) {
                    break;
                } else if (i % primeArrayList.get(i) == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeArrayList.add(newElementsNumber,i);
                newElementsNumber++;

            }
        }
        long endTimeMs = System.currentTimeMillis();
        System.out.println("Простые числа посчитаны за " + (endTimeMs - startTimeMs) + " миллисекунд");
        return primeArrayList;
    }

    public static ArrayList<String> arrayToString(ArrayList arr) {
        StringBuilder primeString = new StringBuilder("[");
       ArrayList<String> result = new ArrayList<>(arr.size());
       for(int i =0; i<result.size();i++){
           result.add((String) arr.get(i));
       }
       return result;
    }

}
