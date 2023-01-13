package rmgYantra;


import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class postReqUsingJsonFile {
	@Test
	public void createUsingJsonFile() {
		File file= new File("./MyData.txt");
		RequestSpecification reqs = RestAssured.given();
		reqs.contentType(ContentType.JSON);
		reqs.body(file);
		Response responce = reqs.post("http://localhost:8084/addProject");
		responce.prettyPrint();
		System.out.println(responce.getStatusCode());
		
	}

}
