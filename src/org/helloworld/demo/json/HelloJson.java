package org.helloworld.demo.json;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class HelloJson {
    public static void main(String[] args) {
        Person p1 = new Person("Ziynat", "Isomurodova",
                new Address(Arrays.asList("77 Nukus st.", "Apt 11"), "Tashkent", "Uzbekistan"));
        System.out.println(p1);

        Gson gson = new Gson();
        String json = gson.toJson(p1);
        System.out.println(json);

        Person p2 = gson.fromJson(json, Person.class);
        System.out.println(p2);
        System.out.println();

        System.out.println(p1.equals(p2));
    }

    public static class Person {
        private final String firstName;
        private final String lastName;
        private final Address address;

        public Person(String firstName, String lastName, Address address) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", address=" + address +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(address, person.address);
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstName, lastName, address);
        }
    }

    public static class Address {
        private final List<String> addrLines;
        private final String city;
        private final String country;

        public Address(List<String> addrLines, String city, String country) {
            this.addrLines = addrLines;
            this.city = city;
            this.country = country;
        }

        @Override
        public String toString() {
            return "Address{" +
                    "addrLines='" + addrLines + '\'' +
                    ", city='" + city + '\'' +
                    ", country='" + country + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Address address = (Address) o;
            return Objects.equals(addrLines, address.addrLines) && Objects.equals(city, address.city) && Objects.equals(country, address.country);
        }

        @Override
        public int hashCode() {
            return Objects.hash(addrLines, city, country);
        }
    }
}
