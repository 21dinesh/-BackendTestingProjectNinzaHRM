package requestchaining;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclass.utility.ProjectPojo;

public class Scenario_1_DeleteProject {

	@Test
	public void sampleTest() {

		// Step-1: Create pre-requisites
		Random random = new Random();
		int ranNum = random.nextInt(5000);

		// API-1 ==> Add a project inside the server
		ProjectPojo projectPojoObj = new ProjectPojo("FB_" + ranNum, "Created", "Rohit", 0);

		Response response = given()
				.contentType(ContentType.JSON)
				.body(projectPojoObj)
	
				.when() // Step-2: Perform action
				.post("http://49.249.28.218:8091/addProject");
		         response.then() // Step-3: Validation
				.assertThat().statusCode(201)
				.log().all();
		         
		         //capture project name from response
		         String projectId = response.jsonPath().get("projectId");
		         System.out.println(projectId);
		         
		 // API-2 ==> Delete project inside the server
		         given().delete("http://49.249.28.218:8091/project/"+projectId)
		         .then()
		         .log().all();
		         
	}
}
