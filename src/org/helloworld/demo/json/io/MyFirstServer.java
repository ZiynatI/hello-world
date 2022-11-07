package org.helloworld.demo.json.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyFirstServer {
    public static void main(String args[]) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(80);) {
            System.out.println("Сервер запущен!");
            try (Socket socket = serverSocket.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
                System.out.println("Связь  установлена!");
                String massage = in.readLine();
                out.write("Привет, это Сервер! Подтверждаю, вы написали : " + massage + "\n");
                out.flush();
            }
        }
    }
}
