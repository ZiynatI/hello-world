package codewars;

import java.util.*;

public class DirectionReduction {
    //Task
    //Write a function dirReduc which will take an array of strings and returns an array of strings
    //with the needless directions removed (W<->E or S<->N side by side).
    //    The Haskell version takes a list of directions with data Direction = North | East | West | South.
    //    The Clojure version returns nil when the path is reduced to nothing.
    //    The Rust version takes a slice of enum Direction {North, East, West, South}.
    //See more examples in "Sample Tests:"
    //Notes
    //    Not all paths can be made simpler. The path ["NORTH", "WEST", "SOUTH", "EAST"] is not reducible.
    //    "NORTH" and "WEST", "WEST" and "SOUTH", "SOUTH" and "EAST" are not directly opposite of each other
    //    and can't become such. Hence the result path is itself : ["NORTH", "WEST", "SOUTH", "EAST"].

    public static void main(String[] args) {
        System.out.println(Arrays.toString(reductDirection(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH"})));

    }

    public static String[] reductDirection(String[] arr) {
        List<String> directions = Arrays.asList(arr);
        //        List<String> cleaned = cleanArray(directions);
        Map<String, String> sides = new HashMap<>();
        sides.put("NORTH", "SOUTH");
        sides.put("SOUTH", "NORTH");
        sides.put("WEST", "EAST");
        sides.put("EAST", "WEST");
        Iterator<String> side = directions.iterator();
        while (!side.next().equals(sides.get(side))) {
            directions.remove(side);
            directions.remove(side.next());
        }
        //        while (!directions.equals(cleaned)) {
        //            directions = cleaned;
        //            cleaned = cleanArray(directions);
        //        }

        return directions.toArray(new String[0]);
    }

    public static List<String> cleanArray(List<String> directions) {
        Map<String, String> sides = new HashMap<>();
        sides.put("NORTH", "SOUTH");
        sides.put("SOUTH", "NORTH");
        sides.put("WEST", "EAST");
        sides.put("EAST", "WEST");
        List<String> cleaned = new ArrayList<>();
        Iterator<String> side = directions.iterator();

        for (int i = 0; i < directions.size(); /**/) {
            String thisString = directions.get(i);
            if (i != directions.size() - 1 && !thisString.equals(sides.get(directions.get(i + 1)))) {
                cleaned.add(thisString);
                i++;
            } else if (i <= directions.size() - 1) {

                if (i == directions.size() - 1) {
                    cleaned.add(thisString);
                }
                i += 2;
            }
        }
        return cleaned;
    }
}
