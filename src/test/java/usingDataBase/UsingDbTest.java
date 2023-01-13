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

public class UsingDbTest {
	@Test
	public void verifyDb() throws SQLException {
		baseURI="http://localhost";
		port=8084;
		PojoClass pojoClass= new PojoClass(createdBy(), projectName(),status() , 3);
		PojoClass pojoClass2 = new PojoClass(createdBy(), projectName(), status(), 4);
		
		Response response = given()
		.contentType(ContentType.JSON)
		.body(pojoClass)
		.when()
		.post(addProject);
		
		String proId= response.jsonPath().get("projectId");
		given()
		.pathParam("projectId", proId)
		.contentType(ContentType.JSON)
		.body(pojoClass2)
		.when()
		.put(updateproject)
		.then().log().all();
		
		given()
		.pathParam("projectId", proId)
		.when()
		.delete(deletesingleproject);
		
		Driver driverSet = new Driver();
		DriverManager.registerDriver(driverSet);
		Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		Statement statement= connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select project_id from project");
		while(resultSet.next()) {
			if(!proId.equals(resultSet.getString(1))) {
				System.out.println("validation Successful");
				break;
			}
		}
		connection.close();			
	}

}
