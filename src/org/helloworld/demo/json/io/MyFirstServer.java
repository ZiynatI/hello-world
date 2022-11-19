package org.helloworld.demo.json.io;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyFirstServer {
    private static final Logger log = LoggerFactory.getLogger(MyFirstServer.class);

    public static void main(String[] args) throws IOException {
        startServer(new File("C:/Users/user/Desktop/html"));
    }

    private static void startServer(File parentFile) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(80)) {
            log.debug("Сервер запущен!");
            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    log.debug("Сокет запущен!");

                    serveConnection(socket, parentFile);
                }
            }
        }
    }

    private static void serveConnection(Socket socket, File parentFile) throws IOException {
        try (InputStream in = socket.getInputStream();
             OutputStream out = socket.getOutputStream()) {

            byte[] inBuffer = new byte[2048];
            int length;
            StringBuilder request = new StringBuilder();
            while ((length = in.read(inBuffer)) > 0) {
                request.append(new String(inBuffer, 0, length, UTF_8));
                if (in.available() <= 0) {
                    break;
                }
            }
            log.debug(request.toString());
            log.debug("Связь установлена!");


            File file;
            if (request.length() >= 5 && request.charAt(5) == ' ') {
                file = new File(parentFile, "index.html");
            } else {
                file = new File(parentFile, request.substring(5, request.indexOf(" ", 6)));
            }

            try {
                byte[] fileBytes = readFile(file);
                String response = "HTTP/1.1 200 OK\n" +
                        "Content-Length: " + fileBytes.length + "\n" +
                        "Content-Type: " + getFileMimeType(file) + "\n\n";
                out.write(response.getBytes(UTF_8));
                log.debug(response);
                out.write(fileBytes);
            } catch (FileNotFoundException ex) {
                out.write("HTTP/1.1 404 Not Found".getBytes(UTF_8));
                log.debug("File not found", ex);
            }
        }
    }

    private static String getFileMimeType(File file) {
        String fileName = file.getName();
        String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);
        if (fileExtension.equals("html")) {
            return "text/html";
        } else if (fileExtension.equals("jpg")) {
            return "image/jpeg";
        } else {
            return "text/plain";
        }
    }

    private static byte[] readFile(File file) throws IOException {
        byte[] fileToBytes;
        try (FileInputStream fis = new FileInputStream(file)) {
            fileToBytes = fis.readAllBytes();
        }
        return fileToBytes;
    }
}
