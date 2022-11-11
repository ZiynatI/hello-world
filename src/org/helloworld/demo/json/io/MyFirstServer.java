package org.helloworld.demo.json.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import static java.nio.charset.StandardCharsets.UTF_8;

public class MyFirstServer {
    public static void main(String[] args) throws IOException {
        getResponse();
    }

    public static void getResponse() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(80)) {
            System.out.println("Сервер запущен!");
            try (Socket socket = serverSocket.accept();
                 OutputStream out = socket.getOutputStream()) {
                System.out.println("Связь  установлена!");
                String response = "HTTP/1.1 200 OK\n" + "Content-Length: " + copyHtml().length() + "\n" +
                        "Content-Type: text/plain" + "\n\n" + copyHtml();
                out.write(response.getBytes(UTF_8));
                System.out.println(response);
            }
        }
    }

    public static StringBuilder copyHtml() throws IOException {
        byte[] buffer2 = new byte[2048];
        int length2;
        StringBuilder htmlSb = new StringBuilder();
        try (FileInputStream fin = new FileInputStream("C:\\Users\\user\\Desktop\\html\\index.html")) {
            while ((length2 = fin.read(buffer2)) > 0) {
                htmlSb.append(new String(buffer2, 0, length2, StandardCharsets.UTF_8));
                if (fin.available() <= 0) {
                    break;
                }
            }
        }
        return htmlSb;
    }
}
