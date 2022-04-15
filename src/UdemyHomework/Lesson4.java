package UdemyHomework;

public class Lesson4 {
        int id;
        String name;
        String surname;
        int year;
        double mathMark;
        double economyMark;
        double langMark;
}
    class Student {
        public static void main(String[] args) {
            Lesson4 sam = new Lesson4();
            sam.id = 1;
            sam.name = "Sam";
            sam.surname = "Simon";
            sam.year = 1990;
            sam.mathMark = 5;
            sam.economyMark = 4;
            sam.langMark = 5;
            double mark = (sam.mathMark+sam.langMark+sam.economyMark)/3;
            System.out.println( mark);
        }
    }

