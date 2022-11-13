package org.helloworld.demo.json.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static java.nio.charset.StandardCharsets.UTF_8;

public class MyFirstServer {
    public static void main(String[] args) throws IOException {
        startServer(new File("C:/Users/user/Desktop/html"));
    }

    public static void startServer(File parentFile) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(80)) {
            System.out.println("Сервер запущен!");
            while (true) {
                try (Socket socket = serverSocket.accept();
                     InputStream in = socket.getInputStream();
                     OutputStream out = socket.getOutputStream()) {
                    System.out.println("Сокет запущен!");
                    byte[] inBuffer = new byte[2048];
                    int length;
                    StringBuilder request = new StringBuilder();
                    while ((length = in.read(inBuffer)) > 0) {
                        request.append(new String(inBuffer, 0, length, UTF_8));
                        if (in.available() <= 0) {
                            break;
                        }
                    }
                    System.out.println(request);
                    File file;
                    System.out.println("Связь  установлена!");
                    if (request.charAt(5) == ' ') {
                        file = new File(parentFile, "index.html");
                    } else {
                        file = new File(parentFile, request.substring(5, request.indexOf(" ", 6)));
                    }
                    serveConnection(out, file);
                }
            }
        }
    }

    public static void serveConnection(OutputStream out, File file) throws IOException {
        String r = "HTTP/1.1 200 OK" +
                "Content-Length: " + readFile(file).length + "\n" +
                "Content-Type: text/html";
        String response = r + "\n\n";
        out.write(response.getBytes(UTF_8));
        System.out.println(response);
        out.write(readFile(file));

    }

    public static byte[] readFile(File file) throws IOException {
        byte[] fileToBytes;
        try (FileInputStream fis = new FileInputStream(file)) {
            fileToBytes = fis.readAllBytes();
        }
        return fileToBytes;
    }
}
