package rmgtestYantawithBdd;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GenericUtility.PojoClass;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UsingDataProvider {
	@Test(dataProvider = "provideData")
	public void postUsingDataProvider(String createdBy, String projectName,String status,int teamSize) {
		PojoClass pc=new PojoClass(createdBy,projectName,status,teamSize);
		given()
		.contentType(ContentType.JSON)
		.body(pc)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.log().all().assertThat().statusCode(201);
	}
	@DataProvider
	public Object[][] provideData(){
		Object [][]obj=new Object[2][4];
		obj[0][0]="hellojava";
		obj[0][1]="remoScl";
		obj[0][2]="on-going";
		obj[0][3]=5;
		
		obj[1][0]="meetjava";
		obj[1][1]="remolittle";
		obj[1][2]="on-going";
		obj[1][3]=3;
		
		return obj;
		
	}

}
