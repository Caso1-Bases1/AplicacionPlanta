package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private Connection connection;
	//private String URL = "jdbc:mysql://localhost:3306/db_planta";
	private String URL = "jdbc:mysql://163.178.107.130:3306/db_planta";
	private String USERNAME = "mysqlparaiso";
	private String PASSWORD = "saucr.117";
	
	private static boolean dbConnected;
	
	public static DBConnection dbConnection;
	
	public static DBConnection getInstance(){
		if (dbConnection == null){
			dbConnection = new DBConnection();			
		}
		return dbConnection;
	}
	
	public Connection connect(){
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		    System.out.println("Database connectada");
		    dbConnected = true;
		    return connection;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		    System.err.println("No se puedo conectar con la base de datos");
		    return null;
		}
	}
	
	public void disconnect (){
		try {
			if (connection != null)
				if (!connection.isClosed())
					dbConnected = false;
					connection.close();
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	}
	
	public static boolean isConnected(){
		return dbConnected;
	}
}
