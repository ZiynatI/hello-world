package org.helloworld.demo.json.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import static java.nio.charset.StandardCharsets.UTF_8;

public class MyFirstServer {
    public static void main(String args[]) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(80)) {
            System.out.println("Сервер запущен!");
            try (Socket socket = serverSocket.accept();
                 InputStream in = socket.getInputStream();
                 OutputStream out = socket.getOutputStream()) {
                System.out.println("Связь  установлена!");
                byte[] buffer = new byte[2048];
                int length;
                System.out.println("Request: ");
                while ((length = in.read(buffer)) > 0) {
                    String request = new String(buffer, 0, length, UTF_8);
                    System.out.println(request);
                    if (in.available() <= 0) {
                        break;
                    }
                }
                byte[] helloWorld = "Hello, World!".getBytes(UTF_8);
                String response = "Content-Length: " + helloWorld.length + "\n" +
                        "Content-Type: text/plain" + "\n\n";
                System.out.println(response);
                out.write("HTTP/1.1 200 OK\n".getBytes(StandardCharsets.UTF_8));
                out.write(response.getBytes(StandardCharsets.UTF_8));
                out.write(helloWorld);

                try (FileInputStream fin = new FileInputStream("C:\\Users\\user\\Desktop\\html\\index.html")) {
                    byte[] buffer2 = new byte[2048];
                    int length2;
                    while ((length2 = fin.read(buffer2)) > 0) {
                        out.write(buffer2);
                        System.out.println(new String(buffer2, 0, length2, StandardCharsets.UTF_8));
                        if (in.available() <= 0) {
                            break;
                        }
                    }
                }


            }
        }
    }
}
