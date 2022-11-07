package org.helloworld.demo.json.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

import static java.nio.charset.StandardCharsets.UTF_8;

public class SocketDemo {
    public static void main(String[] args) throws Exception {
        File f = new File("C:\\Everything\\_java\\hello-world\\test.html");
        InetAddress addr = InetAddress.getByName("www.example.com");
        try (Socket sock = new Socket(addr, 80);
             OutputStream os = sock.getOutputStream();
             InputStream is = sock.getInputStream();
             OutputStream fos = new FileOutputStream(f)) {

            os.write("GET / HTTP/1.1\n".getBytes(UTF_8));
            os.write("Host: example.com\n\n".getBytes(UTF_8));

            boolean dataStarted = false;
            byte[] buf = new byte[1024];
            int len;
            while ((len = is.read(buf)) > 0) {
                String s = new String(buf, 0, len, UTF_8);
                System.out.println(s);
                if (dataStarted) {
                    fos.write(buf, 0, len);
                } else if (s.contains("\n\n")) {
                    dataStarted = true;
                    fos.write(s.substring(s.indexOf("\n\n") + 2).getBytes(UTF_8));
                }
                if (is.available() <= 0) {
                    break;
                }
            }
        }
    }
}