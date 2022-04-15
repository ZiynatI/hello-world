package org.helloworld.demo.oop;

import java.util.ArrayList;

public class OopMain {
    public static void main(String[] args) {

        //        Animal c = new Cat();
        //        Animal d = new Dog("Chuck");
        //        c.makeSound();
        //        d.makeSound();
        //
        //        Animal[] animals = {c, d};
        //        animals[0].makeSound();
        //        animals[1].makeSound();


        Animal dog1 = new Dog("Chuck");
        Animal dog2 = new Dog("Chuck1");

        if (dog1.equals(dog2)) {
            System.out.println("Одна и та же собака");
        } else {
            System.out.println("Разные собаки: " + dog1 + " и " + dog2);
        }
    }

}
