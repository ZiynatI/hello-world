package org.helloworld.task.cop;
/*I. Elevator
time limit per test
2 seconds
memory limit per test
256 megabytes
input
standard input
output
standard output

The building has 𝑛 residential floors, numbered from 1 to 𝑛 from bottom to top. There is also a parking lot in the building; it is located on the 0-th floor. An elevator with a capacity of 𝑐 people (i. e. the elevator cannot carry more than 𝑐 people at a time) runs between all floors. The elevator moves at a speed of 1 floor per second, i. e. in one second, the elevator can move from floor 𝑥 to floor 𝑥+1 or 𝑥−1.
The number of people who want to take the elevator down to the parking lot from the 𝑖-th floor is 𝑎𝑖. Calculate the maximum number of people that the elevator can transport in 𝑚 seconds (possibly by making several rides), if it is initially located on the 0-th floor. You may assume that the time it takes people to enter and/or leave the elevator is negligible.
Input
The first line contains a single integer 𝑡(1≤𝑡≤1000) — the number of test cases.
The first line of each test case contains three integers 𝑛, 𝑐 and 𝑚 (1≤𝑛≤100; 1≤𝑐≤109; 1≤𝑚≤1013).
The second line contains 𝑛 integers 𝑎1,𝑎2,…,𝑎𝑛 (0≤𝑎𝑖≤109).
Output
For each test case, print one integer — the maximum number of people that the elevator can transport in 𝑚seconds, if it is initially located on the 0-th floor.
Example
Input
5
4 5 7
0 1 2 3
4 5 9
0 1 2 3
3 2 10
1 1 1
2 3 3
0 5
4 4 10
3 1 1 1

Output
3
5
3
0
6

Note
In the following example notes, if some integer appears more than once, it means that the number of people taken for the corresponding floor is more than one. For example, the sequence [2,3,3]corresponds to one person from the 2-nd floor and two people from the 3-rd floor.
In the first example, one of the possible strategies is as follows: the elevator takes people from the floors [2,3,3]and spends 6seconds on it.
In the second example, one of the possible strategies is as follows: the elevator takes people from the floors [2,3,3,4,4] and spends 8 seconds on it.
In the third example, one of the possible strategies is as follows: for the first ride, the elevator takes people from the floors [1,2] and spends 4 seconds on it; for the second ride, the elevator takes people from the floors [3] and spends 6 seconds on it.
In the fourth example, there is no way to transport even one person in just 3seconds.
In the fifth example, one of the possible strategies is as follows: for the first ride, the elevator takes people from the floors [1,2,3,4] and spends 8 seconds on it; for the second ride, the elevator takes people from the floors [1,1] and spends 2seconds on it.*/
public class IElevator {
}
