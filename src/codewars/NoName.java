package codewars;

public class NoName {
    public static void main(String[] args) {
        for (int i = 101; i <= 1000; i = i + 2) {
            if (i % 5 == 0) {
                System.out.println(i);
            }
        }
    }
}
