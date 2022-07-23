package codewars;

import java.util.HashMap;
import java.util.Map;

public class MorseCodeDecoder1 {
    //In this kata you have to write a simple Morse code decoder. While the Morse code is now mostly superseded by voice and digital data communication channels, it still has its use in some applications around the world.
    //The Morse code encodes every character as a sequence of "dots" and "dashes". For example, the letter A is coded as ·−, letter Q is coded as −−·−, and digit 1 is coded as ·−−−−. The Morse code is case-insensitive, traditionally capital letters are used. When the message is written in Morse code, a single space is used to separate the character codes and 3 spaces are used to separate words. For example, the message HEY JUDE in Morse code is ···· · −·−−   ·−−− ··− −·· ·.
    //NOTE: Extra spaces before or after the code have no meaning and should be ignored.
    //In addition to letters, digits and some punctuation, there are some special service codes, the most notorious of those is the international distress signal SOS (that was first issued by Titanic), that is coded as ···−−−···. These special codes are treated as single special characters, and usually are transmitted as separate words.
    //Your task is to implement a function that would take the morse code as input and return a decoded human-readable string.
    //For example:
    //MorseCodeDecoder.decode(".... . -.--   .--- ..- -.. .")
    ////should return "HEY JUDE"
    //NOTE: For coding purposes you have to use ASCII characters . and -, not Unicode characters.
    //    NASM: a table of pointers to the morsecodes, and a corresponding list of ascii symbols
    //All the test strings would contain valid Morse code, so you may skip checking for errors and exceptions. In C#, tests will fail if the solution code throws an exception, please keep that in mind. This is mostly because otherwise the engine would simply ignore the tests, resulting in a "valid" solution.
    //Good luck!
    //After you complete this kata, you may try yourself at Decode the Morse code, advanced.

    public static void main(String[] args) {
        System.out.println(decode(".... . -.--   .--- ..- -.. ."));
    }

    public static String decode(String morseCode) {
        // your brilliant code here, remember that you can access the preloaded Morse code table through MorseCode.get(code)
        Map<String, String> MorseCode = new HashMap();
        MorseCode.put(".-", "A");
        MorseCode.put("-...", "B");
        MorseCode.put("-.-.", "C");
        MorseCode.put("-..", "D");
        MorseCode.put(".", "E");
        MorseCode.put("..-.", "F");
        MorseCode.put("--.", "G");
        MorseCode.put("....", "H");
        MorseCode.put("..", "I");
        MorseCode.put(".---", "J");
        MorseCode.put("-.-", "K");
        MorseCode.put(".-..", "L");
        MorseCode.put("--", "M");
        MorseCode.put("-.", "N");
        MorseCode.put("---", "O");
        MorseCode.put(".--.", "P");
        MorseCode.put("--.-", "Q");
        MorseCode.put(".-.", "R");
        MorseCode.put("...", "S");
        MorseCode.put("-", "T");
        MorseCode.put("..-", "U");
        MorseCode.put("...-", "V");
        MorseCode.put(".--", "W");
        MorseCode.put("-..-", "X");
        MorseCode.put("-.--", "Y");
        MorseCode.put("--..", "Z");
        MorseCode.put(".----", "1");
        MorseCode.put("..---", "2");
        MorseCode.put("...--", "3");
        MorseCode.put("....-", "4");
        MorseCode.put(".....", "5");
        MorseCode.put("-....", "6");
        MorseCode.put("--...", "7");
        MorseCode.put("---..", "8");
        MorseCode.put("----.", "9");
        MorseCode.put("-----", "0");
        MorseCode.put("...---...", "SOS");
        MorseCode.put("-.-.--", "!");
        MorseCode.put(".-.-.-", ".");
        morseCode = morseCode.trim();
        String[] letters = morseCode.replaceAll("   ", " _ ").split(" ");
        StringBuilder decoded = new StringBuilder();
        for (String letter : letters) {
            if (letter.equals("_")) {
                decoded.append(" ");
            } else {
                decoded.append(MorseCode.get(letter));
            }
        }
        return decoded.toString();
    }



    public static String decodeBits(String bits) {
        return ".";
    }
}
