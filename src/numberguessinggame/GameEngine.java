package numberguessinggame;

import java.util.Random;
import java.util.Scanner;

public class GameEngine {
    /**
     * Number Guessing Game This number guessing game is an easy project built on Java where the player has to guess a
     * number given in between a range. If the guessed number is right, the player wins else, loses. It also has the
     * concept of limited attempts where the player has to guess the number within the limited attempts given.
     * <p>
     * Abstract: The UI has an input value option where the player has to enter the guessed value, it also displays the
     * time remaining to guess. After completing the limits given, if the guessed number is right, the player wins else
     * loses. The range between the number can be from 1 to 100 or 1 to 1000. Also, if the number you’ve guessed is high
     * or low to the actual value, the application sends you an alert “Too High” or “Too Low”. After the limited attempt
     * is completed, the actual value is revealed. Technologies Required: Java Programming Language and Random Class in
     * Java.
     */
    public static void main(String[] args) {
        play();
    }
    public static void play() {
        System.out.println("Нужен диапазон от нуля до n\nВведите число n");
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int rightNumber = random.nextInt(input.nextInt() + 1);
        while (true) {
            System.out.println("Угадайте число");
            int nextGuessing = input.nextInt();
            if (nextGuessing == rightNumber) {
                System.out.println("Верно!");
                break;
            } else if (nextGuessing > rightNumber) {
                System.out.println("Меньше");
            } else {
                System.out.println("Больше");
            }
        }
    }

}
