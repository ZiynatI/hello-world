package codewars.oop;

import java.util.Random;

public class ColorGhost {
    //https://www.codewars.com/kata/53f1015fa9fe02cbda00111a
    //Color Ghost
    //Create a class Ghost
    //Ghost objects are instantiated without any arguments.
    //Ghost objects are given a random color attribute of "white" or "yellow" or "purple" or "red" when instantiated
    //Ghost ghost = new Ghost();
    //ghost.getColor(); //=> "white" or "yellow" or "purple" or "red"
    public String getColor() {
        Random random = new Random();
        int number = random.nextInt(4);
        if (number == 0) {
            return "white";
        } else if (number == 1) {
            return "yellow";
        } else if (number == 2) {
            return "purple";
        } else {
            return "red";
        }
    }
}
