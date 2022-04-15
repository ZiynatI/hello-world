package org.helloworld.demo;

public class ClassDemo {
    public static class Cat {
        String name;
        int age;

        public void getOlder(int addedAge) {
            this.age = this.age + addedAge;
        }

        public String toString() {
            return "Cat(" + this.name + ", " + this.age + ")";
        }
    }

    public static void main(String[] args) {
        Cat zorya = new Cat();
        zorya.name = "Зоря";
        zorya.age = 2;

        Cat barsik = new Cat();
        barsik.name = "Барсик";
        barsik.age = 4;

        System.out.println(zorya.toString());
        System.out.println(barsik.toString());

        barsik.getOlder(5);
        System.out.println(barsik.toString());
    }
}
