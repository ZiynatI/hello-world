package org.helloworld.demo.json.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

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
                        file = new File("C:/Users/user/Desktop/html/index.html");
                    } else {
                        String filePath = "C:/Users/user/Desktop/html/" + request.substring(5, request.indexOf(" ", 6));
                        file = new File(filePath);
                    }
                    serveConnection(socket, file);
                }
            }
        }
    }

    public static void serveConnection(Socket socket, File file) throws IOException {
        try (OutputStream out = socket.getOutputStream();
             FileInputStream fis = new FileInputStream(file)) {
            byte[] fileToBytes = fis.readAllBytes();
            String r = "HTTP/1.1 200 OK" +
                    "Content-Length: " + fileToBytes.length + "\n" +
                    "Content-Type: text/html";
            String response = r + "\n\n";
            out.write(response.getBytes(UTF_8));
            System.out.println(response);
            out.write(fileToBytes);
        }


    }
}
