package com.raven.demo;
import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcTest {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        String jdbcUrl = "jdbc:mysql://172.17.0.2:3306/hibernate_tutorial?useSSL=false";
        String user = "root";
        String password = "admin@123";
        // SessionFactory sessionFactory = null;
        // Session session = null;

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println("Connection seccessfull!!!");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
