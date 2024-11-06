package com.sample.crud.withbdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForPartialUpdateTest {

	@Test
	public void putDataToServer() {
		
		JSONObject jsonObj=new JSONObject();
		
		jsonObj.put("createdBy", "Rohit_M");
//		jsonObj.put("status", "On Going");
//		jsonObj.put("projectName", "FB_76");
//		jsonObj.put("teamSize", 0);
		
	given() //precondition
	.contentType(ContentType.JSON)
	.body(jsonObj.toJSONString())
    .when() //actual action
    .patch("http://49.249.28.218:8091/project/NH_PROJ_695")
    .then() //validation
    .log().all(); //display response header and body
		
		 
		 
	}

}
