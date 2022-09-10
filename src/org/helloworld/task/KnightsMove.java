package org.helloworld.task;

import java.util.ArrayList;
import java.util.List;

class KnightsMove {

    //    Don't Get Volunteered!
    //    ======================
    //        As a henchman on Commander Lambda's space station, you're expected to be resourceful, smart, and a quick thinker.
    //        It's not easy building a doomsday device and ordering the bunnies around at the same time, after all!
    //        In order to make sure that everyone is sufficiently quick-witted, Commander Lambda has installed new flooring outside
    //        the henchman dormitories. It looks like a chessboard, and every morning and evening you have to solve a new movement puzzle
    //        in order to cross the floor. That would be fine if you got to be the rook or the queen, but instead, you have to be the knight.
    //        Worse, if you take too much time solving the puzzle, you get "volunteered" as a test subject for the LAMBCHOP doomsday device!
    //        To help yourself get to and from your bunk every day, write a function called solution(src, dest) which takes in two parameters:
    //        the source square, on which you start, and the destination square, which is where you need to land to solve the puzzle.
    //        The function should return an integer representing the smallest number of moves it will take for you to travel
    //        from the source square to the destination square using a chess knight's moves (that is, two squares in any direction immediately
    //        followed by one square perpendicular to that direction, or vice versa, in an "L" shape).  Both the source and destination squares
    //        will be an integer between 0 and 63, inclusive, and are numbered like the example chessboard below:
    //        -------------------------
    //    | 0| 1| 2| 3| 4| 5| 6| 7|
    //    -------------------------
    //    | 8| 9|10|11|12|13|14|15|
    //    -------------------------
    //    |16|17|18|19|20|21|22|23|
    //    -------------------------
    //    |24|25|26|27|28|29|30|31|
    //    -------------------------
    //    |32|33|34|35|36|37|38|39|
    //    -------------------------
    //    |40|41|42|43|44|45|46|47|
    //    -------------------------
    //    |48|49|50|51|52|53|54|55|
    //    -------------------------
    //    |56|57|58|59|60|61|62|63|
    //    -------------------------
    //
    //    Languages
    //    =========
    //    To provide a Python solution, edit solution.py
    //    To provide a Java solution, edit Solution.java
    //    Test cases
    //    ==========
    //    Your code should pass the following test cases.
    //    Note that it may also be run against hidden test cases not shown here.
    //    -- Java cases --
    //    Input:
    //    Solution.solution(19, 36)
    //    Output:
    //        1
    //    Input:
    //    Solution.solution(0, 1)
    //    Output:
    //        3
    public static void main(String[] args) {


        System.out.println(solution(19, 36));
        System.out.println(solution(0, 1));
    }

    public static List<Integer> routesList(int src) {
        List<Integer> routes = new ArrayList<>();
        if (rightRightUp(src) > 0) {
            routes.add(rightRightUp(src));
        }
        if (rightRightDown(src) > 0) {
            routes.add(rightRightDown(src));
        }
        if (leftLeftUp(src) > 0) {
            routes.add(leftLeftUp(src));
        }
        if (leftLeftDown(src) > 0) {
            routes.add(leftLeftDown(src));
        }
        if (upUpRight(src) > 0) {
            routes.add(upUpRight(src));
        }
        if (upUpLeft(src) > 0) {
            routes.add(upUpLeft(src));
        }
        if (downDownRight(src) > 0) {
            routes.add(downDownRight(src));
        }
        if (downDownLeft(src) > 0) {
            routes.add(downDownLeft(src));
        }
        return routes;
    }

    public static int solution(int src, int dest) {
        List<Integer> routes = routesList(src);
        int moves = 1;
        for (int i = 0; i < routes.size(); i++) {
            if (routes.get(i) == dest) {
                return moves;
            }
        }
        List<Integer> sources = new ArrayList<>();
        while (true) {
            moves++;
            for (int i = 0; i < routes.size(); i++) {
                if (routes.get(i) >= 0) {
                    sources.addAll(routesList(routes.get(i)));
                }
                for (int j = 0; j < sources.size(); j++) {
                    if (sources.get(j) == dest) {
                        return moves;
                    }
                }
            }
            routes = List.copyOf(sources);
            sources.clear();
        }
    }


    public static int rightRightUp(int src) {
        if (src % 8 == 6 || src % 8 == 7 || src < 8) {
            return -1;
        } else {
            return src + 2 - 8;
        }
    }

    public static int rightRightDown(int src) {
        if (src % 8 == 6 || src % 8 == 7 || src > 55) {
            return -1;
        } else {
            return src + 2 + 8;
        }
    }

    public static int leftLeftUp(int src) {
        if (src % 8 == 1 || src % 8 == 0 || src < 8) {
            return -1;
        } else {
            return src - 2 - 8;
        }
    }

    public static int leftLeftDown(int src) {
        if (src % 8 == 1 || src % 8 == 0 || src > 55) {
            return -1;
        } else {
            return src - 2 + 8;
        }
    }

    public static int upUpRight(int src) {
        if (src < 16 || src % 8 == 7) {
            return -1;
        } else {
            return src - 2 * 8 + 1;
        }
    }

    public static int upUpLeft(int src) {
        if (src < 16 || src % 8 == 0) {
            return -1;
        } else {
            return src - 2 * 8 - 1;
        }
    }

    public static int downDownRight(int src) {
        if (src > 47 || src % 8 == 7) {
            return -1;
        } else {
            return src + 2 * 8 + 1;
        }
    }

    public static int downDownLeft(int src) {
        if (src > 47 || src % 8 == 0) {
            return -1;
        } else {
            return src + 2 * 8 - 1;
        }
    }


    //    public static int solution2(int src, int dest) {
    //
    //        return recurse(63, 0, 0, src, dest);
    //    }
    //
    //    public static int recurse(int minMoves, int numMoves, int route, int src, int dest) {
    //        if (src == dest) {
    //            return numMoves;
    //        } else if (routesList(src).get(route) <= 0) {
    //            recurse(minMoves, numMoves, route + 1, routesList(src).get(route + 1), dest);
    //        } else {
    //            if (numMoves < minMoves && numMoves != 0) {
    //                minMoves = numMoves;
    //            }
    //            recurse(minMoves, numMoves, route, routesList(src).get(route), dest);
    //        }
    //        //        for (int i = 0; i < routesList(src).size(); i++) {
    //        //            while (src != dest) {
    //        //                if (src < 0) {
    //        //                    return 63;
    //        //                }
    //        //                recurse(minMoves, numMoves + 1, routesList(src).get(i), dest);
    //        //            }
    //        //            if (minMoves > numMoves) {
    //        //                minMoves = numMoves;
    //        //            }
    //        //        }
    //        return numMoves;
    //    }
}

