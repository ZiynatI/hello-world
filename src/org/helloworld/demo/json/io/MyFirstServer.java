package org.helloworld.demo.json.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import static java.nio.charset.StandardCharsets.UTF_8;

public class MyFirstServer {
    public static void main(String[] args) throws IOException {
        serveConnection(startServer());
    }

    public static Socket startServer() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(80)) {
            System.out.println("Сервер запущен!");
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Сокет запущен!");
                System.out.println("Связь  установлена!");
                return socket;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void serveConnection(Socket socket) throws IOException {
        try (socket) {
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
                out.close();
                socket.close();
            }
        } finally {
            System.out.println("Сокет закрыт!");
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
