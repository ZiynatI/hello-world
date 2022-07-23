package codewars;

import java.util.LinkedHashMap;
import java.util.Map;

public class BobbyBuildsAPC2 {
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
        StringBuilder allparts = new StringBuilder();
        Map<String, Boolean> parts = new LinkedHashMap<>();
        parts.put("CPU", CPU);
        parts.put("motherboard", motherboard);
        parts.put("ram", ram);
        parts.put("GPU", GPU);
        parts.put("hardDrive", hardDrive);
        parts.put("powerSupply", powerSupply);
        parts.put("desktopCase", desktopCase);
        parts.put("lights", lights);
        if (!parts.containsValue(false)) {
            return "Your PC is ready to build!";
        } else if (!parts.containsValue(true)) {
            return "No items bought!";
        } else {
            for (String part : parts.keySet()) {
                if (!parts.get(part)) {
                    if(allparts.length()!=0){
                        allparts.append(", ");
                    }
                    allparts.append(part);
                }
            }
            return allparts.append(".").toString();

        }
    }
}
