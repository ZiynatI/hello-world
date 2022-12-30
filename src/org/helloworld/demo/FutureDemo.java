package org.helloworld.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {
    public static void main(String[] args) throws Exception {
        ExecutorService es = Executors.newFixedThreadPool(10);
        System.out.println("Start");
        Future<String> myIpFuture = es.submit(() -> getMyIpAddress());
        while (!myIpFuture.isDone()) {
            System.out.println("Not done yet!");
            Thread.sleep(10);
        }
        System.out.println("My IP is " + myIpFuture.get());
        es.shutdown();
    }

    public static String getMyIpAddress() throws Exception {
        URL url = new URL("http://checkip.amazonaws.com/");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
            return br.readLine();
        }
    }
}
