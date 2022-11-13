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
                while (!socket.isClosed()) {
                    serveConnection(socket);
                }
            }
        }
    }

    public static void serveConnection(Socket socket) throws IOException {
        try (OutputStream out = socket.getOutputStream()) {
            File file = new File("C:\\Users\\user\\Desktop\\html\\index.html");
            byte[] fileToBytes = readFile(file).getBytes(UTF_8);
            String response = "HTTP/1.1 200 OK\n" +
                    "Content-Length: " + fileToBytes.length + "\n" +
                    "Content-Type: text/plain" + "\n\n";
            out.write(response.getBytes(UTF_8));
            out.write(fileToBytes);
            System.out.println(response);
            System.out.println(readFile(file));
        }
    }


    public static String readFile(File file) throws IOException {
        byte[] buffer = new byte[2048];
        int length;
        StringBuilder htmlSb = new StringBuilder();
        try (FileInputStream fin = new FileInputStream(file)) {
            while ((length = fin.read(buffer)) > 0) {
                htmlSb.append(new String(buffer, 0, length, StandardCharsets.UTF_8));
                if (fin.available() <= 0) {
                    break;
                }
            }
        }
        return htmlSb.toString();
    }
}
