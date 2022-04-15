package org.helloworld.recursion;

public class Task3 {
    public static void main(String[] args) {
        System.out.println(fromAToB(5, 10));
    }

    //Имеются 2 целых числа A и В (каждое из них в отдельной строке).
    //Необходимо вывести все числа от A до B включительно.
    //Если A < B, числа выводятся по возрастанию, в обратном случае — по убыванию.
    public static String fromAToB(int a, int b) {
        StringBuilder ab = new StringBuilder();
        if (b == a) {
            return ab.append(a).toString();
        }
        return ab.append(fromAToB(a, b - 1)).append(b).toString();

    }
}
