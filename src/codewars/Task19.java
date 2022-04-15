package codewars;

public class Task19 {
    public static void main(String[] args) {
        System.out.println(alphabetWar("zdqmwpbs"));
    }
    //Write a function that accepts fight string consists of only small letters and return who wins the fight.
    //When the left side wins return Left side wins!, when the right side wins return Right side wins!,
    //in other case return Let's fight again!.
    public static String alphabetWar(String fight) {
        int left = 0;
        int right = 0;
        String win;
        for (int i = 0; i < fight.length(); i++) {
            if (fight.charAt(i) == 'w') {
                left = left + 4;
            } else if (fight.charAt(i) == 'p') {
                left = left + 3;
            } else if (fight.charAt(i) == 'b') {
                left = left + 2;
            } else if (fight.charAt(i) == 's') {
                left = left + 1;
            } else if (fight.charAt(i) == 'm') {
                right = right + 4;
            } else if (fight.charAt(i) == 'q') {
                right = right + 3;
            } else if (fight.charAt(i) == 'd') {
                right = right + 2;
            } else if (fight.charAt(i) == 'z') {
                right = right + 1;
            }
        }
        if (left > right) {
            win = "Left side wins!";
        } else if (left < right) {
            win = "Right side wins!";
        } else {
            win = "Let's fight again!";

        }
        return win;
    }
}