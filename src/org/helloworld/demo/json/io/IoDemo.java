package org.helloworld.demo.json.io;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class IoDemo {
    public static final int BUFFER_SIZE = 8;

    public static void main(String[] args) throws Exception {
        File f = new File("C:\\Everything\\_java\\hello-world\\pom.xml");
        File f2 = new File(f.getParentFile(), "test.xml");

        try (InputStream is = new FileInputStream(f);
             PrintStream os = new PrintStream(new FileOutputStream(f2))) {
            byte[] buff = new byte[BUFFER_SIZE];
            int len;
            while ((len = is.read(buff)) >= 0) {
                String s = new String(buff, 0, len, StandardCharsets.UTF_8);
                os.print(s);
            }
        }


    }
}
