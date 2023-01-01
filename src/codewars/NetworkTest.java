package codewars;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class NetworkTest {
    public static void main(String[] args) throws Exception {
        try (ServerSocket ss = new ServerSocket(80)) {
            try (Socket s = ss.accept()) {
                try (InputStream is = s.getInputStream()) {
                    byte[] bs = is.readAllBytes();
                    System.out.println(new String(bs, StandardCharsets.UTF_8));
                }
            }
        }
    }
}
