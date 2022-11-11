package org.helloworld.demo;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class CharsetDemo {
    public static void main(String[] args) {
        String source = "qwerty!";
        byte[] encoded = source.getBytes(StandardCharsets.UTF_8);
        String decoded = new String(encoded, Charset.forName("utf32"));
        System.out.println("Source:    " + source);
        System.out.println("Encoded:   " + Arrays.toString(encoded));
        System.out.println("Reencoded: " + decoded);
        System.out.println("Equal?     " + source.equals(decoded));
        Charset.availableCharsets().entrySet().stream().forEach(e -> {
            System.out.println(e.getValue());
        });
    }
}
