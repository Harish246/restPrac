package rmgtestYantawithBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostReqWithBdd {
	@Test
	public void PostReqWithBdd() {
		JSONObject jobj= new JSONObject();
		jobj.put("createdBy", "hercul");
		jobj.put("projectName", "RoadRash");
		jobj.put("status", "on-going");
		jobj.put("teamSize", 2);
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.log()
		.all().assertThat().statusCode(201);
	}
	

}
