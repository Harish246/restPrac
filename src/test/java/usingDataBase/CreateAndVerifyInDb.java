package usingDataBase;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import static GenericUtility.JavaFacker.*;
import static GenericUtility.EndPoints.*;

import GenericUtility.PojoClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CreateAndVerifyInDb {
	@Test
	public void createRequest() throws SQLException {
		baseURI="http://localhost";
		port= 8084;
		
		PojoClass pojoClass= new PojoClass(createdBy(), projectName(), status(), 3);
		Response response = given()
		.contentType(ContentType.JSON)
		.body(pojoClass)
		.when()
		.post(addProject);
		
		String proName= response.jsonPath().get("projectName");
		Driver driverRef= new Driver();
		DriverManager.registerDriver(driverRef);
		
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		Statement statement = connection.createStatement();
		ResultSet resultSet=statement.executeQuery("select project_name from project;");
		while(resultSet.next()) {
			if(proName.equals(resultSet.getString(1))) {
				System.out.println(resultSet.getString(1));
				break;
			}
		}
		connection.close();
			
	}

}
