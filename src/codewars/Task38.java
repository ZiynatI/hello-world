package codewars;

public class Task38 {
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
            }
            else {
                return false;
            }
        }
        if (countDigits == 4 || countDigits == 6) {
            return true;
        }
        return false;
    }

}
