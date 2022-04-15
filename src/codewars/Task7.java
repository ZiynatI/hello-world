package codewars;

public class Task7 {
    public static void main(String[] args) {
        String example = "You don't have to worry with strings with less than two characters.";
        System.out.println(remove(example));
    }
    //It's pretty straightforward.
    // Your goal is to create a function that removes the first and last characters of a string.
    // You're given one parameter, the original string.
    // You don't have to worry with strings with less than two characters.
    public static String remove(String str) {
        StringBuilder newString = new StringBuilder();
        if (str.length() > 1) {
            for (int i = 0; i < str.length(); i++) {
                if (i != 0 && (i != str.length() - 1)) {
                    newString.append(str.charAt(i));
                }
            }
        } return newString.toString();
    }
}

