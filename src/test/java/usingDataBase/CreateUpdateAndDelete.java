package usingDataBase;

import org.testng.annotations.Test;

import com.google.common.graph.EndpointPair;

import static GenericUtility.JavaFacker.*;

import GenericUtility.EndPoints;
import GenericUtility.PojoClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateUpdateAndDelete {
	@Test
	public void createRequest(){
		baseURI="http://localhost";
		port=8084;
		PojoClass pojoClass = new PojoClass(createdBy(), projectName(), status(), 5);
		PojoClass pojoClass2= new PojoClass(createdBy(), projectName(), status(), 6);
		
		
		Response response = given()
		.contentType(ContentType.JSON)
		.body(pojoClass)
		.when()
		.post(EndPoints.addProject);
		
		String proId=response.jsonPath().get("projectId");
		given()
		.pathParam("projectId", proId)
		.contentType(ContentType.JSON)
		.body(pojoClass2)
		.when()
		.put(EndPoints.updateproject)
		.then().log().all().assertThat().statusCode(200);
		
		given()
		.pathParam("projectId", proId)
		.when()
		.delete(EndPoints.deletesingleproject);
		
	}
	

}
