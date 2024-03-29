package codewars;

public class Task18 {
    public static void main(String[] args) {
        System.out.println(nbYear(1500, 5, 100, 5000));
        System.out.println(nbYear(1500000, 2.5, 10000, 2000000));
    }

    //More generally given parameters:
    //p0, percent, aug (inhabitants coming or leaving each year), p (population to surpass)
    //the function nb_year should return n number of entire years needed to get a population greater or equal to p.
    //aug is an integer, percent a positive or null floating number, p0 and p are positive integers (> 0)
    //Examples:
    //nb_year(1500, 5, 100, 5000) -> 15
    //nb_year(1500000, 2.5, 10000, 2000000) -> 10
    //Note:
    //Don't forget to convert the percent parameter as a percentage in the body of your function: if the parameter percent is 2 you have to convert it to 0.02.
    public static int nbYear(int p0, double percent, int aug, int p) {
        int nb = 0;
        while (p0 < p) {
            p0 = (int) (p0 + (p0 * percent / 100) + aug);
            nb++;
        }
        return nb;
    }
}
