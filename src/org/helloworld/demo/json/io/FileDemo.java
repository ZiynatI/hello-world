package org.helloworld.demo.json.io;

import java.io.File;
import java.util.Arrays;

public class FileDemo {
    public static void main(String[] args) {
        File directory = new File("C://Users/user/Desktop/test");
        File file = new File(directory,"testFile");
        System.out.println(directory.exists());
        File parentDirectory = directory.getParentFile();
        System.out.println(Arrays.toString(parentDirectory.list()));
    }
}
