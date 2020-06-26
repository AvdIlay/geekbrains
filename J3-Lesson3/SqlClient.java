package ru.gb.jtwo.chat.server.core;

import java.sql.*;

public class SqlClient {

    private static Connection connection;
    private static Statement statement;


    public synchronized static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\i.avdienko\\Downloads\\Chat_new\\Chat_new\\J2_Stream200402\\chat-nick.db");
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized static String getNickname(String login, String password) {
        String query = String.format("select nickname from users where login='%s' and password='%s'", login, password);
        try (ResultSet set = statement.executeQuery(query)) {
            if (set.next())
                return set.getString(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    public synchronized static void editNickname(String nickname, String login){
        String query = String.format("UPDATE users SET nickname = '%s' WHERE login = '%s'", nickname, login);
        try {
            statement.executeUpdate(query);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    synchronized static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
