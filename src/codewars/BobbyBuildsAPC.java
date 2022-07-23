package codewars;

import java.util.*;

public class BobbyBuildsAPC {
    //Bobby wants a new gaming PC so he can play all the latest games at top speed. He heard that building your own PC can save you money and offer more customization, so he chooses to buy all the components and assemble the computer by himself.
    //However, Bobby has severe short term memory loss, which means he has trouble remembering if he has bought all the parts he needs for the PC. Thankfully, Bobby wrote a list of all the parts he has currently bought before he could forget. Help Bobby out by writing a function partsLeft that takes in a boolean for each part (true=bought and false=not bought) and return a String containing all the parts he still needs to buy.
    //Here is a list of all the parts Bobby will need in his PC:
    //CPU
    //motherboard
    //ram
    //GPU
    //hardDrive
    //powerSupply
    //desktopCase
    //lights
    //Return a String that contains the parts in that list he has not bought, formatted like this (parts in the order of the above list, separated by commas):
    //Input: false, true, true, false, true, true, false, true //as booleans
    //Output: "CPU, GPU, desktopCase." //as a String with a period at the end.
    //If every item has been bought then return "Your PC is ready to build!" If no items have been bought then return "No items bought!"
    public static void main(String[] args) {
        System.out.println(partsLeft(false, true, true, false, true, true, false, true));
    }

    public static String partsLeft(boolean CPU, boolean motherboard, boolean ram,
                                   boolean GPU, boolean hardDrive, boolean powerSupply,
                                   boolean desktopCase, boolean lights) {
        StringBuilder allParts = new StringBuilder();
        List<String> partsList = new ArrayList<>();
        if (!CPU) {
            partsList.add("CPU");
        }
        if (!motherboard) {
            partsList.add("motherboard");
        }
        if (!ram) {
            partsList.add("ram");
        }
        if (!GPU) {
            partsList.add("GPU");
        }
        if (!hardDrive) {
            partsList.add("hardDrive");
        }
        if (!powerSupply) {
            partsList.add("powerSupply");
        }
        if (!desktopCase) {
            partsList.add("desktopCase");
        }
        if (!lights) {
            partsList.add("lights");
        }
        if (partsList.size() == 8) {
            return "Your PC is ready to build!";
        } else if (partsList.size() == 0) {
            return "No items bought!";
        } else {
            Iterator<String> part = partsList.iterator();
            while (part.hasNext()) {
                allParts.append(part.next());
                if (part.hasNext()) {
                    allParts.append(", ");
                } else {
                    allParts.append(".");
                }
            }
        }
        return allParts.toString();
    }
}
