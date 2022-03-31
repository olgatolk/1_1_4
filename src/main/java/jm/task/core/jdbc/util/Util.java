package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
      //  if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/bd_1");
               // settings.put(Environment.URL, "jdbc:mysql://localhost:3306/bd_1?useSSL=false&allowMultiQueries=true&serverTimezone=UTC");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "Dctdsiybq7!!!");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "create-drop");
                configuration.setProperties(settings);
                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                //Configuration cfg=new Configuration().configure();
                //StandardServiceRegistryBuilder builder= new StandardServiceRegistryBuilder().applySettings(
                //       cfg.getProperties());
                //SessionFactory factory= cfg.buildSessionFactory(builder.build());

                // serviceRegistry = new ServiceRegistryBuilder().applySettings(
                //       configuration.getProperties()).buildServiceRegistry();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            } catch (HibernateException hibernateException) {
                hibernateException.printStackTrace();
            }
       // }
        return sessionFactory;
    }


    private static final String connectionUrl = "jdbc:mysql://localhost:3306/bd_1";
    private static final String userName = "root";
    private static final String password = "Dctdsiybq7!!!";

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
