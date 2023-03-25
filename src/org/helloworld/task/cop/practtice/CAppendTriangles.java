package org.helloworld.task.cop.practtice;

import java.util.Scanner;

//C. Append Triangles
//time limit per test
//2 seconds
//memory limit per test
//256 megabytes
//input
//standard input
//output
//standard output
//Little Johnny wants to draw a rectangle on a plane with its sides parallel to axes. If it happens to be a square, it's also fine, — a square is a rectangle in Little Johnny's books.
//Unfortunately, he only knows how to draw triangles. Also, he has drawn one triangle already.
//Now he wonders if he can draw more triangles so that they make a rectangle together. The triangles that Little Johnny draws should not overlap (neither with each other nor with the original triangle), but can touch. The union of all triangles should form a rectangle with its sides parallel to the coordinate axes.
//What's the smallest number of triangles Little Johnny has to draw in addition to the original one to get a rectangle?
//Input
//The first line contains a single integer 𝑡
//(1≤𝑡≤100
//) — the number of test cases.
//The only line of each test case contains six integers 𝑥1,𝑦1,𝑥2,𝑦2,𝑥3,𝑦3
//(−1000≤𝑥1,𝑦1,𝑥2,𝑦2,𝑥3,𝑦3≤1000) — the coordinates of the points of the triangle that Little Johnny has drawn already. This triangle is non-degenerate, i. e. has an area strictly greater than 0
//.
//Output
//For each test case, print a single integer — the smallest number of triangles Little Johnny has to draw in addition to the original one to get a rectangle.
//Example
//Input
//4
//-5 4 10 8 0 -7
//0 0 3 0 0 3
//4 -1 5 -1 3 6
//4 1 0 2 -2 -6
//Output
//3
//1
//2
//3
//Note
//Here's the picture for the fourth test case. The original triangle is marked orange, the additional 3
//triangles are marked blue.
//Note that you can't add just 1
//triangle to make a rectangle like that, because it has to be axis-aligned.

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
        String[] nums = stdin.nextLine().split(" ");
        int overallCoors = 0;
        if (nums[0].equals(nums[2])) {
            overallCoors++;
        }
        if (nums[2].equals(nums[4])) {
            overallCoors++;
        }
        if (nums[0].equals(nums[4])) {
            overallCoors++;
        }
        if (nums[1].equals(nums[3])) {
            overallCoors++;
        }
        if (nums[3].equals(nums[5])) {
            overallCoors++;
        }
        if (nums[1].equals(nums[5])) {
            overallCoors++;
        }
        if (overallCoors == 2) {
            System.out.println(1);
        } else if (overallCoors == 1) {
            System.out.println(2);
        } else {
            System.out.println(3);
        }
    }
}
