package com.sample.crud.withbdd;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class SampleTestForCreateTest {

	@Test
	public void postDataToServerTest() {
		
		//given()-> Preconditions
		//when()-> Actual Actions
		//then()-> Validations 
		//With the help of method chaining unnecessary variable usage can be reduced
		
		// Step-1: Create pre-requisites
		JSONObject jsonObj=new JSONObject();
		
		jsonObj.put("createdBy", "Rohit");
		jsonObj.put("status", "Created");
		jsonObj.put("projectName", "FB_80");
		jsonObj.put("teamSize", 0);
		
		given()
		.contentType(ContentType.JSON)
		.body(jsonObj)
		.when() // Step-2: Perform action
		.post("http://49.249.28.218:8091/addProject")
		.then() // Step-3: Validation
		//.assertThat()
		.statusCode(201)
		.log().all();
	}
}
