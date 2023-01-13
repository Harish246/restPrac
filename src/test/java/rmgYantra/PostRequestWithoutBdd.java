package rmgYantra;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestWithoutBdd {
	@Test
	public void createReqest() {
		 
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "LaxmiPrasad");
		jobj.put("projectName", "PayTm");
		jobj.put("status", "on-going");
		jobj.put("teamSize", 4);
		
		RequestSpecification reqs = RestAssured.given();
		reqs.contentType(ContentType.JSON);
		reqs.body(jobj);
		reqs.when();
		Response response = reqs.post("http://localhost:8084/addProject");
		response.prettyPrint();
		System.out.println(response.getStatusCode());
		
	}

}
