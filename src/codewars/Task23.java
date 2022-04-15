package codewars;

import java.util.HashMap;

public class Task23 {
    public static void main(String[] args) {
        System.out.println(looseChange(56));
    }
    //Welcome young Jedi! In this Kata you must create a function that takes an amount of US currency
    //in cents, and returns a dictionary/hash which shows the least amount of coins used to make up that amount.
    //The only coin denominations considered in this exercise are:
    // Pennies (1¢), Nickels (5¢), Dimes (10¢) and Quarters (25¢).
    // Therefor the dictionary returned should contain exactly 4 key/value pairs.
    //Notes:
    //    If the function is passed either 0 or a negative number, the function should return the dictionary with all values equal to 0.
    //    If a float is passed into the function, its value should be be rounded down, and the resulting dictionary should never contain fractions of a coin.
    public static HashMap<String, Integer> looseChange(int cent) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Pennies", 0);
        map.put("Nickels", 0);
        map.put("Dimes", 0);
        map.put("Quarters", 0);
        if(cent>0) {
            map.put("Quarters", cent/25);
            cent=cent- map.get("Quarters")*25;
            map.put("Dimes",cent/10);
            cent=cent- map.get("Dimes")*10;
            map.put("Nickels",cent/5);
            cent=cent-map.get("Nickels")*5;
            map.put("Pennies",cent);
        }
        return map;
    }
}
