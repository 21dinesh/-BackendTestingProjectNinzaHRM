package miscellaneous_topics;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.http.ContentType;

public class DataMasking {

	@Test
	public void sampleTest() {
		
		JSONObject jsonObj = new JSONObject();

		jsonObj.put("createdBy", "Rohit");
		jsonObj.put("status", "Created");
		jsonObj.put("projectName", "FB_178");
		jsonObj.put("teamSize", 0);

		given()
		.contentType(ContentType.JSON)
		.config(RestAssured.config.logConfig(LogConfig.logConfig().blacklistHeader("Content-Type")))
		.body(jsonObj)	
		.when()
		.post("http://49.249.28.218:8091/addProject")
		.then()
		.log().all();
	}
}
