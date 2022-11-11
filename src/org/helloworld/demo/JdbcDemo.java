package org.helloworld.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDemo {
    public static void main(String[] args) throws Exception {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/postgres?user=postgres";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM person")) {
                while (rs.next()) {
                    System.out.println("(id=" + rs.getInt(1)
                            + ", first_name=" + rs.getString(2)
                            + ", last_name=" + rs.getString(3)
                            + ", age=" + rs.getInt(4) + ")");
                }
            }
        }
    }
}
