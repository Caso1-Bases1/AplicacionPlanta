package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public String URL = "jdbc:mysql://localhost:3306/db_planta";
	public String USERNAME = "root";
	public String PASSWORD = "";
	
	public void conectar(){
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
		    System.out.println("Database connected!");
		    connection.createStatement();
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}
}
