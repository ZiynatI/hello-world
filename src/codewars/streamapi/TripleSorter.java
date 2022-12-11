package codewars.streamapi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TripleSorter {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(23, 88, "David Goodman"));
        students.add(new Student(25, 82, "Mark Rose"));
        students.add(new Student(22, 90, "Jane Doe"));
        students.add(new Student(25, 90, "Jane Dane"));
        System.out.println(sort(students));
    }
    //Tale University is a bit messy, and can't maintain an ordered list of their student.
    //Tale's dean wants to print a sortet list of his students by the gpa, last name and age
    //and post it on the walls so everybody can be impressed of his great students.
    //Given a list of students, sort them by (from most important to least important):
    //    GPA (descending)
    //    First letter of last name (ascending)
    //    Age (ascending)
    //And the class Student:
    //class Student {
    //    ...
    //  int getGpa()
    //  int getAge();
    //  String getFullName();
    //}
    //Return the sorted result as full names string, comma separated.
    //For Example, given the list (name, age, gpa):
    //    David Goodman, 23, 88
    //    Mark Rose, 25, 82
    //    Jane Doe, 22, 90
    //    Jane Dane, 25, 90
    //sort(students) should return "Jane Doe,Jane Dane,David Goodman,Mark Rose"

    public static String sort(List<Student> students) {
        String s = students.stream().sorted(Comparator.comparing(Student::getGpa).thenComparing(Student::getAge)).toString();
        return s;
    }

    static class Student {
        int age;
        int gpa;
        String fullName;

        Student(int age, int gpa, String fullName) {
            this.age = age;
            this.gpa = gpa;
            this.fullName = fullName;
        }

        int getGpa() {
            return this.gpa;
        }

        int getAge() {
            return this.age;
        }

        String getFullName() {
            return this.fullName;
        }

        ;
    }
}
