package codewars;

import java.util.HashMap;
import java.util.Map;

public class MorseCodeDecoder0 {
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
        System.out.println(decode("...---..."));
    }

    public static String decode(String morseCode) {
        // your brilliant code here, remember that you can access the preloaded Morse code table through MorseCode.get(code)
        morseCode = morseCode.trim();
        Map<String, String> morseMap = new HashMap();
        morseMap.put(".-", "A");
        morseMap.put("-...", "B");
        morseMap.put("-.-.", "C");
        morseMap.put("-..", "D");
        morseMap.put(".", "E");
        morseMap.put("..-.", "F");
        morseMap.put("--.", "G");
        morseMap.put("....", "H");
        morseMap.put("..", "I");
        morseMap.put(".---", "J");
        morseMap.put("-.-", "K");
        morseMap.put(".-..", "L");
        morseMap.put("--", "M");
        morseMap.put("-.", "N");
        morseMap.put("---", "O");
        morseMap.put(".--.", "P");
        morseMap.put("--.-", "Q");
        morseMap.put(".-.", "R");
        morseMap.put("...", "S");
        morseMap.put("-", "T");
        morseMap.put("..-", "U");
        morseMap.put("...-", "V");
        morseMap.put(".--", "W");
        morseMap.put("-..-", "X");
        morseMap.put("-.--", "Y");
        morseMap.put("--..", "Z");
        morseMap.put(".----", "1");
        morseMap.put("..---", "2");
        morseMap.put("...--", "3");
        morseMap.put("....-", "4");
        morseMap.put(".....", "5");
        morseMap.put("-....", "6");
        morseMap.put("--...", "7");
        morseMap.put("---..", "8");
        morseMap.put("----.", "9");
        morseMap.put("-----", "0");
        morseMap.put("...---...","SOS");
        morseMap.put("-.-.--","!");
        morseMap.put(".-.-.-",".");
        StringBuilder decoded = new StringBuilder();
        StringBuilder character = new StringBuilder();
        for (int i = 0; i < morseCode.length(); i++) {
            if (morseCode.charAt(i) == ' ') {
                decoded.append(morseMap.get(character.toString()));
                character.setLength(0);
                if (morseCode.charAt(i + 1) == ' ' && morseCode.charAt(i + 2) == ' ') {
                    decoded.append(" ");
                    i = i + 2;
                }
            } else {
                character.append(morseCode.charAt(i));
            }
        }
        decoded.append(morseMap.get(character.toString()));
        return decoded.toString();
    }
}
