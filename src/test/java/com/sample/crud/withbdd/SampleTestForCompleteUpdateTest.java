package com.sample.crud.withbdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForCompleteUpdateTest {

	@Test
	public void putDataToServer() {
		
		// Step-1: Create pre-requisites
		JSONObject jsonObj=new JSONObject();
		
		jsonObj.put("createdBy", "Rohit");
		jsonObj.put("status", "On Going");
		jsonObj.put("projectName", "FB_110");
		jsonObj.put("teamSize", 0);
		
		given()
		.contentType(ContentType.JSON)
		.body(jsonObj.toJSONString())
		.when() // Step-2: Perform action
		.put("http://49.249.28.218:8091/project/NH_PROJ_696")
		.then() // Step-3: Validation
		.assertThat().statusCode(200)
		.log().all();
	}

}
