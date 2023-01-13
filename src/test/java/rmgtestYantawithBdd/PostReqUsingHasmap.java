package rmgtestYantawithBdd;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostReqUsingHasmap {
	@Test
	public void postReqUsingHashmap() {
		HashMap hp= new HashMap();
		hp.put("createdBy", "hetro");
		hp.put("projectName", "hetroExp");
		hp.put("status", "on-going");
		hp.put("teamSize", 4);
		
		given()
		.contentType(ContentType.JSON)
		.body(hp)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.log().all().assertThat().statusCode(201);
		
	}

}
