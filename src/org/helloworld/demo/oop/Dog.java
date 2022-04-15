package org.helloworld.demo.oop;

import java.util.Objects;

public class Dog extends Animal {
    private String name;

    protected Dog(String name) {
        super("Woof!");
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Dog dog = (Dog) o;
        return name.equals(dog.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
