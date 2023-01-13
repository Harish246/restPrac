package GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtils {
	Connection connection;
	public void connectToDb() throws SQLException {
		Driver driverRef= new Driver();
		DriverManager.registerDriver(driverRef);
		connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
	}
	public void disconnectToDb()throws SQLException{
		connection.close();
	}
	public ResultSet executeQuery(String path) throws SQLException{
		Statement statement = connection.createStatement();
		 ResultSet resultSet = statement.executeQuery(path);
		 return resultSet;
	}

}
