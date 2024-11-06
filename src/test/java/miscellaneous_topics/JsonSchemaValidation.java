package miscellaneous_topics;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class JsonSchemaValidation {

	@Test
	public void sampleTest() {

		JSONObject jsonObj=new JSONObject();
		
		jsonObj.put("createdBy", "Rohit");
		jsonObj.put("status", "Created");
		jsonObj.put("projectName", "FB_"+new Random().nextInt(1000));
		jsonObj.put("teamSize", 0);
		
		Response response = given()
		.contentType(ContentType.JSON)
		.body(jsonObj)
		.when()
		.post("http://49.249.28.218:8091/addProject");
		response.then().assertThat().statusCode(201).log().all();
		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("./src/test/resources/jsonschema.json")));
		
	}
}
