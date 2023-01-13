package rmgYantra;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostReqByHashmap {
	@Test
	public void createRequest() {
		HashMap hp=new HashMap();
		hp.put("createBy", "sravan");
		hp.put("projectName", "sranPj");
		hp.put("status", "on-going");
		hp.put("teamSize", 4);
		
		RequestSpecification reqs = RestAssured.given();
		reqs.contentType(ContentType.JSON);
		reqs.body(hp);
		reqs.when();
		Response response = reqs.post("http://localhost:8084/addProject");
		response.prettyPrint();
		
		
		
	}

}
