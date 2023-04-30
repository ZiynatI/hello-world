package codewars;

//https://www.codewars.com/kata/5839c48f0cf94640a20001d3
/*Given an array arr of strings, complete the function by calculating the total perimeter of all the islands.
Each piece of land will be marked with 'X' while the water fields are represented as 'O'.
Consider each tile being a perfect 1 x 1 piece of land. Some examples for better visualization:
['XOOXO',
 'XOOXO',
 'OOOXO',
 'XXOXO',
 'OXOOO']
should return: "Total land perimeter: 24".
Following input:
['XOOO',
 'XOXO',
 'XOXO',
 'OOXX',
 'OOOO']
should return: "Total land perimeter: 18"
*/
public class LandPerimeter {
    public static void main(String[] args) {
        System.out.println(landPerimeter(new String[]{
                "XOOXO",
                "XOOXO",
                "OOOXO",
                "XXOXO",
                "OXOOO"}));
    }

    public static String landPerimeter(String[] arr) {
        boolean lastWasX = false;
        int perimeter = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length(); j++) {
                if (lastWasX) {
                    if (arr[i].charAt(j) == 'O') {
                        perimeter++;
                        lastWasX = false;
                    }
                } else {
                    if (arr[i].charAt(j) == 'X') {
                        lastWasX = true;
                    }
                }
            }
            if (lastWasX) {
                perimeter++;
                lastWasX = false;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i].length() - 1; j >= 0; j--) {
                if (lastWasX) {
                    if (arr[i].charAt(j) == 'O') {
                        perimeter++;
                        lastWasX = false;
                    }
                } else {
                    if (arr[i].charAt(j) == 'X') {
                        lastWasX = true;
                    }
                }
            }
            if (lastWasX) {
                perimeter++;
                lastWasX = false;
            }
        }
        for (int j = 0; j < arr[0].length(); j++) {
            for (int i = 0; i < arr.length; i++) {
                if (lastWasX) {
                    if (arr[i].charAt(j) == 'O') {
                        perimeter++;
                        lastWasX = false;
                    }
                } else {
                    if (arr[i].charAt(j) == 'X') {
                        lastWasX = true;
                    }
                }
            }
            if (lastWasX) {
                perimeter++;
                lastWasX = false;
            }
        }
        for (int j = 0; j < arr[0].length(); j++) {
            for (int i = arr.length - 1; i >= 0; i--) {
                if (lastWasX) {
                    if (arr[i].charAt(j) == 'O') {
                        perimeter++;
                        lastWasX = false;
                    }
                } else {
                    if (arr[i].charAt(j) == 'X') {
                        lastWasX = true;
                    }
                }
            }
            if (lastWasX) {
                perimeter++;
                lastWasX = false;
            }
        }
        return "Total land perimeter: " + perimeter;
    }
}
