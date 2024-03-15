package org.example;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) {
        ResourceBundle res = ResourceBundle.getBundle("db");
        String url = res.getString("url");
        String username = res.getString("username");
        String password = res.getString("password");

        var query = "select * from posts";
        try (var con = DriverManager.getConnection(url, username, password);
             var stmt = con.createStatement();
             var rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println(rs.getString("post_id"));
                System.out.println(rs.getString("title"));
                System.out.println(rs.getString(4));
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("An error occur");
        }
    }
}