package codewars;

import java.util.*;

public class Task11 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(deleteNth(new int[]{20, 37, 20, 21}, 1)));
        System.out.println(Arrays.toString(deleteNth(new int[]{1, 1, 3, 3, 7, 2, 2, 2, 2}, 3)));
    }

    /*Given a list lst and a number N, create a new list that contains each number of lst at most N times
     without reordering. For example if N = 2, and the input is [1,2,3,1,2,1,2,3], you take [1,2,3,1,2],
     drop the next [1,2] since this would lead to 1 and 2 being in the result 3 times, and then take 3,
     which leads to [1,2,3,1,2,3].
     EnoughIsEnough.deleteNth(new int[] {20,37,20,21}, 1) // return [20,37,21]
     EnoughIsEnough.deleteNth(new int[] {1,1,3,3,7,2,2,2,2}, 3) // return [1, 1, 3, 3, 7, 2, 2, 2]*/

    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        Map<Integer, Integer> photos = new HashMap();
        List<Integer> Album = new ArrayList<>();
        for (int el : elements) {
            int elementsIndex = 0;
            if (photos.containsKey(el)) {
                photos.put(el, photos.get(el) + 1);
                if (photos.get(el) <= maxOccurrences) {
                    Album.add(elements[el]);
                }
            } else {
                photos.put(el, 1);
                if (maxOccurrences >= 1) {
                    Album.add(el);
                }
            }
        }
        return listToArray(Album);
    }

    public static int[] listToArray(List<Integer> lst) {
        int[] photosArray = new int[lst.size()];
        for (int i = 0; i < lst.size(); i++) {
            photosArray[i] = lst.get(i);
        }
        return photosArray;
    }
}
