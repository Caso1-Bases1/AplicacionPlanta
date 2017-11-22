package util;

import java.sql.*;

public class DBSQLServer {

    private Connection connection;
    private String DB = "DB_CORP";
    private String login = "estudiantes";
    private String password = "estudiantes";
    
    private String URL = "jdbc:sqlserver://163.178.173.148:1433;databaseName=DB_CORP";

    public static DBSQLServer dbConnection;
    private static boolean dbConnected;

    public static DBSQLServer getInstance() {
        if (dbConnection == null) {
            dbConnection = new DBSQLServer();
        }
        return dbConnection;
    }

    public Connection connect() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(URL, login, password);
            if (connection != null){
                System.out.println("Database sql server connectada");
                dbConnected = true;
            }
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("No se pudo realizar la conexión");
            return null;
        }
    }

    public void disconnect() {
        try {
            if (connection != null) {
                if (!connection.isClosed()) {
                    dbConnected = false;
                }
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean isConnected() {
        return dbConnected;
    }
}
