package org.helloworld.demo.json.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

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
                while ((length = in.read(buffer)) > 0) {
                    if (in.available() <= 0) {
                        break;
                    }
                }
                out.write("HTTP/1.1 200 OK\n".getBytes(StandardCharsets.UTF_8));
                out.write(("Content-Length: 0\n" +
                        "Content-Type: text/html" +
                        "\n\n").getBytes(StandardCharsets.UTF_8));
                System.out.println("Hello, World!");
            }
        }
    }
}
