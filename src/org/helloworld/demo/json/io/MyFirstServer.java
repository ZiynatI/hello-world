package org.helloworld.demo.json.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import static java.nio.charset.StandardCharsets.UTF_8;

public class MyFirstServer {
    public static void main(String[] args) throws IOException {
        getOutputStream();
    }

    public static void getOutputStream() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(80)) {
            System.out.println("Сервер запущен!");
            try (Socket socket = serverSocket.accept();
                 OutputStream out = socket.getOutputStream()) {
                System.out.println("Связь  установлена!");
                out.write(collectString().getBytes(UTF_8));
                System.out.println(collectString());
            }
        }
    }

    public static String collectString() throws IOException {
        byte[] buffer = new byte[2048];
        int length;
        StringBuilder htmlSb = new StringBuilder();
        try (FileInputStream fin = new FileInputStream("C:\\Users\\user\\Desktop\\html\\index.html")) {
            while ((length = fin.read(buffer)) > 0) {
                htmlSb.append(new String(buffer, 0, length, StandardCharsets.UTF_8));
                if (fin.available() <= 0) {
                    break;
                }
            }
        }
        return "HTTP/1.1 200 OK\n" +
                "Content-Length: " + htmlSb.length() + "\n" +
                "Content-Type: text/plain" + "\n\n" +
                htmlSb;
    }
}
