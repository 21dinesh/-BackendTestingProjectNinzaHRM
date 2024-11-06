package com.sample.crud.withoutbdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForCompleteUpdateTest {
	
	@Test
	public void putDataToServerTest() {
		
		//Step-1: Create pre-requsites
		JSONObject jsonObj= new JSONObject(); 
		
		jsonObj.put("createdBy", "Rohit");
		jsonObj.put("projectName", "Fb_112");
		jsonObj.put("status", "Completed");
		jsonObj.put("teamSize", 0);

		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(jsonObj.toJSONString());
		//body() and contentType both are preconditions for put()
		
		//Step-2: perform action
		Response response = reqSpec.put("http://49.249.28.218:8091/project/NH_PROJ_688");
		
		//Step-3: Validation
		response.then().log().all();
		response.then().assertThat().statusCode(200);
		
	}
	

}
