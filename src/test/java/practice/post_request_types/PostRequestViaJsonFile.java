package practice.post_request_types;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostRequestViaJsonFile {

	@Test
	public void postDataToServerTest() {

		
		// Step-1: Create pre-requisites
		File fileObj = new File("./proj.json");

		given()
		.contentType(ContentType.JSON)
		//since i have a jackson dependency in my pom.xml file automatically parsing will happen
		//you just have to pass the file object here
		.body(fileObj)
		.when() // Step-2: Perform action
		.post("http://49.249.28.218:8091/addProject")
		.then() // Step-3: Validation
		//.assertThat()
		.statusCode(201)
		.log().all();
	}
}
