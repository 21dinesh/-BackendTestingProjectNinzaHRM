package practice.post_request_types;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoclass.utility.ProjectPojo;


public class PostRequestViaPojoClass {

	@Test
	public void postDataToServerTest() {

		
		// Step-1: Create pre-requisites
		Random random = new Random();
		int ranNum = random.nextInt(5000);
		// Create an object of Pojo class
		ProjectPojo projectPojoObj = new ProjectPojo("FB_85"+ranNum, "Created", "Rohit", 0);

		given()
		.contentType(ContentType.JSON)

		.body(projectPojoObj)
		//Automatically RestAssured will take care of Serialization, that means, automatically it
		//will convert java into json file before sending the request, because of Jackson
		.when() // Step-2: Perform action
		.post("http://49.249.28.218:8091/addProject")
		.then() // Step-3: Validation
		//.assertThat()
		.statusCode(201)
		.log().all();
	}
}
