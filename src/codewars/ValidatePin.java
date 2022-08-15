package codewars;

public class ValidatePin {
    //ATM machines allow 4 or 6 digit PIN codes and PIN codes cannot contain anything
    // ut exactly 4 digits or exactly 6 digits.
    //If the function is passed a valid PIN string, return true, else return false.
    //Examples (Input --> Output):
    //"1234"   -->  true
    //"12345"  -->  false
    //"a234"   -->  false

    public static void main(String[] args) {
        System.out.println(validatePin("a234"));
    }

    public static boolean validatePin(String pin) {
        String regex = "\\d{4}|\\d{6}";
        return pin.matches(regex);
    }
}
