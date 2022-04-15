package codewars;

public class Task10 {
    public static void main(String[] args) {
        int[] exampleArr = new int[]{3, 6, 7, 5, 5, 2, 5, 2, 6, 4, 1, 7, 1, 5, 4, 5, 2, 7, 6, 4, 1, 6, 5, 3, 1};
        int tills = 3;
        System.out.println(solveSuperMarketQueue(exampleArr, tills));
    }

    public static int solveSuperMarketQueue(int[] customers, int n) {
        int tills[] = new int[n];
        for (int i = 0; i < customers.length; i++) {
            int min = findMin(tills, n);
            tills[min] += customers[i];
        }

        int indexOfMax = 0;
        for (int i = 0; i < n; i++) {
            if (tills[i] > tills[indexOfMax]) {
                indexOfMax = i;
            }
        }
        return tills[indexOfMax];
    }

    public static int findMin(int[] tills, int n) {
        int indexOfMin = 0;
        for (int i = 0; i < n; i++) {
            if (tills[i] < tills[indexOfMin]) {
                indexOfMin = i;
            }
        }
        return indexOfMin;
    }
}