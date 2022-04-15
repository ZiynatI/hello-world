package org.helloworld.demo.oop;

public abstract class Animal {
    private String sound;

    protected Animal(String sound) {
        this.sound = sound;
    }

    public void makeSound() {
        System.out.println(sound);
    }
}
