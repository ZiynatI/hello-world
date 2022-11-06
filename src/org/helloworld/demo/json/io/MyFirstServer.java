package org.helloworld.demo.json.io;

import java.io.*;

public class MyFirstServer {


    public static void main(String args[]) throws IOException {
        FileInputStream fileIn = null;
        FileOutputStream fileOut = null;

        try {
            fileIn = new FileInputStream("file.txt");
            fileOut = new FileOutputStream("copied_file.txt");

            int a;
            // Копирование содержимого файла file.txt
            while ((a = fileIn.read()) != -1) {
                fileOut.write(a); // Чтение содержимого файла file.txt и запись в файл copied_file.txt
            }
        } finally {
            if (fileIn != null) {
                fileIn.close();
            }
            if (fileOut != null) {
                fileOut.close();
            }
        }
    }

}
