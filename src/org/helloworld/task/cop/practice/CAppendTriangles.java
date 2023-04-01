package org.helloworld.task.cop.practice;

/*C. Append Triangles
time limit per test
2 seconds
memory limit per test
256 megabytes
input
standard input
output
standard output

Little Johnny wants to draw a rectangle on a plane with its sides parallel to axes.
If it happens to be a square, it's also fine, — a square is a rectangle in Little Johnny's books.
Unfortunately, he only knows how to draw triangles. Also, he has drawn one triangle already.
Now he wonders if he can draw more triangles so that they make a rectangle together.
The triangles that Little Johnny draws should not overlap (neither with each other nor with the original triangle), but can touch.
The union of all triangles should form a rectangle with its sides parallel to the coordinate axes.
What's the smallest number of triangles Little Johnny has to draw in addition to the original one to get a rectangle?
Input
The first line contains a single integer 𝑡 (1≤𝑡≤100) — the number of test cases.
The only line of each test case contains six integers 𝑥1,𝑦1,𝑥2,𝑦2,𝑥3,𝑦3
(−1000≤𝑥1,𝑦1,𝑥2,𝑦2,𝑥3,𝑦3≤1000) — the coordinates of the points of the triangle that Little Johnny has drawn already.
This triangle is non-degenerate, i. e. has an area strictly greater than 0.
Output
For each test case, print a single integer — the smallest number of triangles Little Johnny has to draw in addition to the original one to get a rectangle.
Example
Input

4
-5 4 10 8 0 -7
0 0 3 0 0 3
4 -1 5 -1 3 6
4 1 0 2 -2 -6

Output

3
1
2
3

Note
Here's the picture for the fourth test case. The original triangle is marked orange, the additional 3 triangles are marked blue.
Note that you can't add just 1 triangle to make a rectangle like that, because it has to be axis-aligned.
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CAppendTriangles {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int n = Integer.parseInt(stdin.nextLine());
        while (n > 0) {
            findNumOfTTriangles(stdin);
            n--;
        }
    }

    public static void findNumOfTTriangles(Scanner stdin) {
        int[] nums = Arrays.stream(stdin.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Set<Integer> xs = new HashSet<>();
        xs.add(nums[0]);
        xs.add(nums[2]);
        xs.add(nums[4]);

        Set<Integer> ys = new HashSet<>();
        ys.add(nums[1]);
        ys.add(nums[3]);
        ys.add(nums[5]);

        if (xs.size() == 2 && ys.size() == 2) {
            System.out.println(1);
        } else if (xs.size() == 2 || ys.size() == 2) {
            System.out.println(2);
        } else {
            System.out.println(3);
        }
    }
}
