package org.helloworld.demo;

import org.helloworld.task.Task1;

public class PackageDemo {
    public static void main(String[] args) {
        // Вызов функции из импортированного класса
        Task1.main(args);
        System.out.println(Task1.subtract(100, 30));

        // Вызов функции из класса по полному имени
        org.helloworld.task.Task1.main(args);
    }
}
