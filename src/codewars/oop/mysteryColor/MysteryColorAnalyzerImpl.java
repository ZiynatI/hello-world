package codewars.oop.mysteryColor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MysteryColorAnalyzerImpl implements MysteryColorAnalyzer {
    //https://www.codewars.com/kata/59ffd0058ba91470bf0000bf
    //Create the implementation for the interface MysteryColorAnalyzer.
    //The implementation needs to be called "MysteryColorAnalyzerImpl".
    @Override
    public int numberOfDistinctColors(List<Color> mysteryColors) {
        Set<Color> colors = new HashSet<>();
        int count = 0;
        for (Color color : mysteryColors) {
            if (!colors.contains(color)) {
                colors.add(color);
                count++;
            }
        }
        return count;
    }

    @Override
    public int colorOccurrence(List<Color> mysteryColors, Color color) {
        int count = 0;
        for (Color c : mysteryColors) {
            if (c.equals(color)) {
                count++;
            }
        }
        return count;
    }
}
