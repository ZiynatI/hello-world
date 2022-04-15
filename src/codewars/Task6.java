package codewars;

public class Task6 {
    /*Complete the function that accepts a string parameter, and reverses each word in the string.
     All spaces in the string should be retained.*/
    public static void main(String[] args) {
        String example = "This is an example!";
        System.out.println(reverseWords(example));
    }

    public static String reverseWords(final String original) {
        String reversedString = "";
        StringBuilder reversedWord = new StringBuilder();
        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) != ' ') {
                reversedWord.insert(0, original.charAt(i));
            } else {
                reversedString = reversedString + reversedWord + " ";
                reversedWord.setLength(0);
            }
        }
        if (reversedWord.length() != 0) {
            reversedString = reversedString + reversedWord;
        }
        return reversedString;
    }
}

