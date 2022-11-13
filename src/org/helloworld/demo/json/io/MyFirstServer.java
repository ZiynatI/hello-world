package org.helloworld.demo.json.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import static java.nio.charset.StandardCharsets.UTF_8;

public class MyFirstServer {
    public static void main(String[] args) throws IOException {
        startServer();
    }

    public static void startServer() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(80)) {
            System.out.println("Сервер запущен!");
            while (true) {
                try (Socket socket = serverSocket.accept();
                     InputStream in = socket.getInputStream()) {
                    System.out.println("Сокет запущен!");
                    byte[] inBuffer = new byte[2048];
                    int length;
                    while ((length = in.read(inBuffer)) > 0) {
                        System.out.println(new String(inBuffer, 0, length, UTF_8));
                        if (in.available() <= 0) {
                            break;
                        }
                    }
                    System.out.println("Связь  установлена!");

                    serveConnection(socket);
                }
            }
        }
    }

    public static void serveConnection(Socket socket) throws IOException {
        try (OutputStream out = socket.getOutputStream()) {
            System.out.println(readFile());
            byte[] fileToBytes = readFile().getBytes(UTF_8);
            String r = "HTTP/1.1 200 OK" +
                    "Content-Length: " + fileToBytes.length + "\n" +
                    "Content-Type: text/html";
            String response = r + "\n\n" + readFile() + "\n";
            out.write(response.getBytes(UTF_8));
            System.out.println(response);
        }
    }


    public static String readFile() throws IOException {
        File file = new File("C:/Users/user/Desktop/html/index.html");
        byte[] buffer = new byte[2048];
        int length;
        StringBuilder htmlSb = new StringBuilder();
        try (InputStream fin = new FileInputStream(file)) {
            while ((length = fin.read(buffer)) > 0) {
                htmlSb.append(new String(buffer, 0, length, StandardCharsets.UTF_8));
            }
        }
        return htmlSb.toString();
    }
}
