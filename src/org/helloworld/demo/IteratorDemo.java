package org.helloworld.demo;

import java.util.*;

public class IteratorDemo {
    public static void main(String[] args) {
        Collection<String> coll1 = new ArrayList<>();
        Collection<String> coll2 = new HashSet<>();
        Collection<Map.Entry<String, String>> coll3 = new HashMap<String, String>().entrySet();

        coll1.add("q");
        coll1.add("w");
        coll1.add("e");

        for (Iterator<String> iter = coll1.iterator(); iter.hasNext(); /* NOOP */) {
            String s = iter.next();
            System.out.println(s);
        }
    }
}
