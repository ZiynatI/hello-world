package codewars;

public class Task31 {
    public static void main(String[] args) {
        System.out.println(travel("123 Main Street St. Louisville OH 43071,432 Main Long Road St. Louisville OH 43071,786 High Street Pollocksville NY 56432", "NY 5632"));
    }

    //A traveling salesman has to visit clients. He got each client's address e.g. "432 Main Long Road St. Louisville OH 43071" as a list.
    //The basic zipcode format usually consists of two capital letters followed by a white space and five digits. The list of clients to visit was given as a string of all addresses, each separated from the others by a comma, e.g. :
    //"123 Main Street St. Louisville OH 43071,432 Main Long Road St. Louisville OH 43071,786 High Street Pollocksville NY 56432".
    //To ease his travel he wants to group the list by zipcode.
    //Task
    //The function travel will take two parameters r (addresses' list of all clients' as a string) and zipcode and returns a string in the following format:
    //zipcode:street and town,street and town,.../house number,house number,...
    //The street numbers must be in the same order as the streets where they belong.
    //If a given zipcode doesn't exist in the list of clients' addresses return "zipcode:/"
    //Examples
    //r = "123 Main Street St. Louisville OH 43071,432 Main Long Road St. Louisville OH 43071,786 High Street Pollocksville NY 56432"
    //travel(r, "OH 43071") --> "OH 43071:Main Street St. Louisville,Main Long Road St. Louisville/123,432"
    //travel(r, "NY 56432") --> "NY 56432:High Street Pollocksville/786"
    //travel(r, "NY 5643") --> "NY 5643:/"
    //Note for Elixir:
    //In Elixir the empty addresses' input is an empty list, not an empty string.
    //Note:
    //You can see a few addresses and zipcodes in the test cases.
    public static String travel(String r, String zipcode) {
        if (zipcode.length() == 0) {
            return ":/";
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder streetAndTown = new StringBuilder();
        StringBuilder houseNumber = new StringBuilder();
        sb.append(zipcode).append(':');
        String[] addresses = r.split(",");
        for (String address : addresses) {
            if (address.endsWith(zipcode)) {
                houseNumber.append(address, 0, address.indexOf(' ')).append(',');
                streetAndTown.append(address, address.indexOf(' ') + 1, address.indexOf(zipcode) - 1).append(',');
            }
        }
        if (houseNumber.length() != 0) {
            streetAndTown.deleteCharAt(streetAndTown.length() - 1);
            houseNumber.deleteCharAt(houseNumber.length() - 1);
        }
        sb.append(streetAndTown).append('/').append(houseNumber);
        return sb.toString();
    }
}
