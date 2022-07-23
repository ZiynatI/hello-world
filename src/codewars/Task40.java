package codewars;

public class Task40 {
    public static void main(String[] args) {
        System.out.println(high("man i need a taxi up to ubud"));
    }

    //Given a string of words, you need to find the highest scoring word.
    //Each letter of a word scores points according to its position in the alphabet: a = 1, b = 2, c = 3 etc.
    //You need to return the highest scoring word as a string.
    //If two words score the same, return the word that appears earliest in the original string.
    //All letters will be lowercase and all inputs will be valid.
    public static String high(String s) {
        String[] words = s.split(" ");
        String highest = words[0];
        int highestScore = countScore(highest);
        for (int i = 1; i < words.length; i++) {
            int thisScore =countScore(words[i]);
            if (thisScore > highestScore) {
                highest = words[i];
                highestScore =thisScore;
            }
        }
        return highest;
    }

    public static int countScore(String word) {
        int score = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            score += (c - 'a' + 1);
        }
        return score;
    }
}
