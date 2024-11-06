package practice.post_request_types;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostRequestViaHashMapTest {

	@Test
	public void postDataToServerTest() {

		
		// Step-1: Create pre-requisites
		HashMap<String,Object> hashMap =new HashMap();
		
		hashMap.put("createdBy", "Rohit");
		hashMap.put("status", "Created");
		hashMap.put("projectName", "FB_82");
		hashMap.put("teamSize", 0);
		
		given()
		.contentType(ContentType.JSON)
		.body(hashMap)
		.when() // Step-2: Perform action
		.post("http://49.249.28.218:8091/addProject")
		.then() // Step-3: Validation
		//.assertThat()
		.statusCode(201)
		.log().all();
	}
}
