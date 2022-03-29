package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String connectionUrl = "jdbc:mysql://localhost:3306/bd_1";
    private static final String userName = "root";
    private static final String password = "Dctdsiybq7!!!";

   // Connection connection = getMyConnection();




    public static Connection getMyConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionUrl, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }



    /*public static Connection getMySQLConnection() throws SQLException,
            ClassNotFoundException {

        String hostName = "localhost";
        String dbName = "bd_1";
        String userName = "root";
        String password = "Dctdsiybq7!!!";

        return getMySQLConnection(hostName, dbName, userName, password);
    }
    public static Connection getMySQLConnection(String hostName, String dbName,
                                                String userName, String password)  {

        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(connectionURL, userName,
                    password);
          //  if (!conn.isClosed()) {
           // System.out.println("Ok");}
//conn.close();
           // if (conn.isClosed()) {
              //  System.out.println("Ups");}
        } catch (SQLException e) {
            e.printStackTrace();
           // System.out.println("Ups");
        }

        return conn;
    }*/
}
