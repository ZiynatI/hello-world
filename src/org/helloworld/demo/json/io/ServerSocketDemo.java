package org.helloworld.demo.json.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ServerSocketDemo {

    public static void main(String[] args) throws Exception {
        System.out.println("=== Listening...");
        try (ServerSocket ss = new ServerSocket(80)) {
            while (true) {
                try (Socket socket = ss.accept();
                     InputStream inputStream = socket.getInputStream();
                     OutputStream outputStream = socket.getOutputStream()) {
                    System.out.println("=== Incoming connection!");
                    byte[] buffer = new byte[8192];
                    int len;
                    while ((len = inputStream.read(buffer)) > 0) {
                        // System.out.println(new String(buffer, 0, len, StandardCharsets.UTF_8));
                        if (inputStream.available() <= 0) {
                            break;
                        }
                    }

                    System.out.println("=== Responding");
                    String httpHeader = "HTTP/1.1 200 OK";

                    File f = new File("C:/Users/user/Desktop/html/index.html");

                    StringBuilder sb = new StringBuilder();
                    try (InputStream fileInputStream = new FileInputStream(f)) {
                        while ((len = fileInputStream.read(buffer)) > 0) {
                            sb.append(new String(buffer, 0, len, StandardCharsets.UTF_8));
                        }
                    }
                    String htmlResponse = sb.toString();
                    String response = httpHeader + "\n\n" + htmlResponse + "\n";
                    outputStream.write(response.getBytes(StandardCharsets.UTF_8));
                }
            }
        }
    }
}
