package codewars;

public class PigLatin {
    //Move the first letter of each word to the end of it, then add "ay" to the end of the word.
    //Leave punctuation marks untouched.
    //Examples:
    //pigIt('Pig latin is cool'); // igPay atinlay siay oolcay
    //pigIt('Hello world !');     // elloHay orldway !

    public static void main(String[] args) {
        System.out.println(pigIt("Pig latin is cool"));
    }

    public static String pigIt(String str) {
        String[] words = str.split(" ");
        StringBuilder quasiWords = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (i != 0) {
                quasiWords.append(" ");
            }
            String word = words[i];
            if (word.equals(".") || word.equals("!") || word.equals("?") || word.equals(",")) {
                quasiWords.append(word);
            } else {
                quasiWords.append(word.substring(1)).append(word.charAt(0)).append("ay");
            }
        }
        return quasiWords.toString();
    }
}
