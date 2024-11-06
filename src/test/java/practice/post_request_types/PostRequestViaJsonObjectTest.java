package practice.post_request_types;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostRequestViaJsonObjectTest {

	@Test
	public void postDataToServerTest() {

		
		// Step-1: Create pre-requisites
		JSONObject jsonObj = new JSONObject();
		
		jsonObj.put("createdBy", "Rohit");
		jsonObj.put("status", "Created");
		jsonObj.put("projectName", "FB_990");
		jsonObj.put("teamSize", "1000");
		
		given()
		.contentType(ContentType.JSON)
		.body(jsonObj)
		.log().all()
		.when() // Step-2: Perform action
		.post("http://49.249.28.218:8091/addProject")
		.then() // Step-3: Validation
		//.assertThat()
		.statusCode(201)
		.log().all();
	}
}
