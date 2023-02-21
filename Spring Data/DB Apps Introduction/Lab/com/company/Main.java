package com.company;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String user = scanner.nextLine();
        System.out.println();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.println();


        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", password);

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/diablo", props);

        PreparedStatement stmt =
                connection.prepareStatement("SELECT `user_name`, `first_name`, `last_name`, COUNT(g.`id`) AS 'count'\n" +
                        "FROM `users` AS u\n" +
                        "JOIN `users_games` AS ug ON u.`id` = ug.`user_id`\n" +
                        "JOIN `games` AS g ON ug.`game_id` = g.`id`\n" +
                        "WHERE u.`user_name` = ?\n" +
                        "GROUP BY u.`id`;");

        String userName = scanner.nextLine();
        stmt.setString(1, userName);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            System.out.println(rs.getString("user_name") + " " +
                    rs.getString("first_name") + " " +
                    rs.getString("last_name") + " " +
                    rs.getString("count"));
        } else {
            System.out.println("No such user exists");
        }

    }
}
