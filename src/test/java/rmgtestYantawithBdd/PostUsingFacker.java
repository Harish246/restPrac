package rmgtestYantawithBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericUtility.JavaFacker;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostUsingFacker {
	@Test
	public void usingFacker() {
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", JavaFacker.createdBy());
		jobj.put("projectName", JavaFacker.projectName());
		jobj.put("status", JavaFacker.status());
		jobj.put("teamSize", 4);
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.log().all();
		
	}

}
