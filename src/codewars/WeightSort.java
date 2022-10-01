package codewars;

public class WeightSort {
    //My friend John and I are members of the "Fat to Fit Club (FFC)". John is worried because each month
    //a list with the weights of members is published and each month he is the last on the list which means
    //he is the heaviest.
    //I am the one who establishes the list, so I told him: "Don't worry anymore, I will modify the order
    //of the list". It was decided to attribute a "weight" to numbers. The weight of a number will be
    //from now on the sum of its digits.
    //For example 99 will have "weight" 18, 100 will have "weight" 1 so in the list 100 will come before 99.
    //Given a string with the weights of FFC members in normal order can you give this string ordered by
    //"weights" of these numbers?
    //Example:
    //"56 65 74 100 99 68 86 180 90" ordered by numbers weights becomes:
    //"100 180 90 56 65 74 68 86 99"
    //When two numbers have the same "weight", let us class them as if they were strings (alphabetical ordering) and not numbers:
    //180 is before 90 since, having the same "weight" (9), it comes before as a string.
    //All numbers in the list are positive numbers and the list can be empty.
    //Notes
    //    it may happen that the input string have leading, trailing whitespaces and more than a unique whitespace between two consecutive numbers


    public static void main(String[] args) {
        Integer i = 4;
        System.out.println(i instanceof Number);
        System.out.println(orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
        System.out.println(orderWeight("103 123 4444 99 2000"));
        //        System.out.println(orderWeight("59544965313"));
    }

    public static String orderWeight(String strng) {
        if (strng.equals("")) {
            return "";
        }
        String[] weight = strng.split(" ");
        NumbersWithWeight[] nw = new NumbersWithWeight[weight.length];
        for (int i = 0; i < weight.length; i++) {
            nw[i] = new NumbersWithWeight(weight[i]);
        }
        NumbersWithWeight temp;
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < nw.length - 1; i++) {
//                if (nw[i] == nw[i + 1]){
//                    List<String> list = new ArrayList<>();
//                    list.add(nw[i].weightOfValue);
//                    list.add(nw[i+1].weightOfValue);
//                    Collections.sort(list);
//                    nw[i]=list.get(0);
//
//                }
//               else
                   if (nw[i].weightOfValue > nw[i + 1].weightOfValue) {

                    temp = nw[i];
                    nw[i] = nw[i + 1];
                    nw[i + 1] = temp;
                    sorted=false;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nw.length; i++) {
            sb.append(nw[i].value);
            if (i != nw.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    public static class NumbersWithWeight {
        public String value;
        public int weightOfValue;

        public NumbersWithWeight(String value) {
            this.value = value;
            this.weightOfValue = getWeight();
        }

        public int getWeight() {
            int weight = 0;
            int v = Integer.parseInt(value);
            while (v > 0) {
                weight = weight + v % 10;
                v = (v - v % 10) / 10;
            }
            return weight;
        }
    }
}
