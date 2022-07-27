package codewars;

public class Task38 {
    public static void main(String[] args) {
        System.out.println(nSquaresFor(18));
    }
    public static int nSquaresFor(int n) {
        if (n <= 3)
            return n;
        int res = n;
        for (int x = 1; x <= n; x++)
        {
            int temp = x * x;
            if (temp > n)
                break;
            else
                res = Math.min(res, 1 + nSquaresFor(n - temp));
        }
        return res;
    }
    //In this kata you parse RGB colors represented by strings. The formats are primarily used in HTML and CSS. Your task is to implement a function which takes a color as a string and returns the parsed color as a map (see Examples).
    //Input:
    //
    //The input string represents one of the following:
    //
    //    6-digit hexadecimal - "#RRGGBB"
    //    e.g. "#012345", "#789abc", "#FFA077"
    //    Each pair of digits represents a value of the channel in hexadecimal: 00 to FF
    //
    //    3-digit hexadecimal - "#RGB"
    //    e.g. "#012", "#aaa", "#F5A"
    //    Each digit represents a value 0 to F which translates to 2-digit hexadecimal: 0->00, 1->11, 2->22, and so on.
    //
    //    Preset color name
    //    e.g. "red", "BLUE", "LimeGreen"
    //    You have to use the predefined map PRESET_COLORS (JavaScript, Python, Ruby), presetColors (Java, C#, Haskell), or preset-colors (Clojure). The keys are the names of preset colors in lower-case and the values are the corresponding colors in 6-digit hexadecimal (same as 1. "#RRGGBB").
    //
    //Examples:
    //
    //parse("#80FFA0")   === new RGB(128, 255, 160))
    //parse("#3B7")      === new RGB( 51, 187, 119))
    //parse("LimeGreen") === new RGB( 50, 205,  50))
    //
    //// RGB class is defined as follows:
    //final class RGB {
    //    public int r, g, b;
    //
    //    public RGB();
    //    public RGB(int r, int g, int b);
    //}
    //    public class HtmlColorParser {
    //        private final Map<String, String> presetColors;
    //
    //        public HtmlColorParser(Map<String, String> presetColors) {
    //            this.presetColors = presetColors;
    //        }
    //
    //        public RGB parse(String color) {
    //            return new RGB(0, 128, 255);
    //        }
    //    }

    public static boolean validatePin(String pin) {
        int countDigits = 0;
        for (int i = 0; i < pin.length(); i++) {
            if (Character.isDigit(pin.charAt(i))) {
                countDigits++;
            } else {
                return false;
            }
        }
        if (countDigits == 4 || countDigits == 6) {
            return true;
        }
        return false;
    }

    public static String reverseWords(String str) {
        String[] words = str.split(" ");
        StringBuilder reserved = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (i != words.length - 1) {
                reserved.append(" ");
            }
            reserved.append(words[i]);
        }
        return reserved.toString();
    }

    public static String maskify(String str) {

        StringBuilder maskified = new StringBuilder();
        for (int i = 0; i < str.length() - 1; i++) {
            if (i < str.length() - 4) {
                maskified.append("#");
            } else {
                maskified.append(str.charAt(i));
            }
        }
        return maskified.toString();
    }


//    public static int rowSumOddNumbers(int n) {
//        int row = 0;
//        int i =2;
//        int thisI=0;
//        while (row!=n){
//
//        }
//        return ;
//    }
}
