package com.sample.crud.withoutbdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForPartialUpdateTest {
	
	@Test
	public void putDataToServer() {	
		//Step-1: Create pre-requsites
		JSONObject jsonObj= new JSONObject();

		jsonObj.put("projectName", "FB_110");
		
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(jsonObj.toJSONString());
		
		Response response = reqSpec.patch("http://49.249.28.218:8091/project/NH_PROJ_696");
		response.then().log().all();
		response.then().assertThat().statusCode(200);
	} 
	

}
