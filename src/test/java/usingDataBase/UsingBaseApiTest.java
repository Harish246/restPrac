package usingDataBase;

import org.testng.annotations.Test;

import GenericUtility.BaseAPI;
import GenericUtility.DataBaseUtils;
import GenericUtility.PojoClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static GenericUtility.JavaFacker.*;
import static GenericUtility.EndPoints.*;


public class UsingBaseApiTest extends BaseAPI {
	@Test
	public void createRequest() throws SQLException {
		baseURI ="http://localhost";
		port= 8084;
		PojoClass pojoClass= new PojoClass(createdBy(),projectName(), status(), 3);
		Response response= given()
				.contentType(ContentType.JSON)
				.body(pojoClass)
				.when()
				.post(addProject);
		
		String proId= response.jsonPath().get("projectId");
		given()
		.pathParam("projectId", proId)
		.when()
		.delete(deletesingleproject);
		
		ResultSet resultSet= dataBaseUtils.executeQuery("select project_id from project;");
		while(resultSet.next()) {
			if(!proId.equals(resultSet.getString(1))) {
				System.out.println("validate successful");
				break;
			}	
		}		
	}

}
