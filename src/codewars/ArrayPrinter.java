package codewars;

public class ArrayPrinter {
    //Input: Array of elements
    //["h","o","l","a"]
    //Output: String with comma delimited elements of the array in th same order.
    //"h,o,l,a"
    //Note: if this seems too simple for you try the next level
    public static String printArray(Object[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append(array[0]);
        for (int i = 1; i < array.length; i++) {
            sb.append(",").append(array[i]);
        }
        return sb.toString();
    }
}
