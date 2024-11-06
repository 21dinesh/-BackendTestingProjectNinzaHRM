package com.sample.crud.withoutbdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class SampleTestForCreateTest {

	@Test
	public void postDataToServerTest() {
		
		//Step-1: Create the pre- requisites - request Body(pay load)
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("createdBy", "Rohit");
		jsonObj.put("projectName", "Fb_109");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", 0);
		
		RequestSpecification reqSpec = RestAssured.given();
		//given method is used to set preconditions for the request

		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(jsonObj.toJSONString());
		//The json object will always be in the form of key and value pair (map)
		//that should be converted into json format of string before passing into the body 
		
		//Step-2: Perform the action
		Response response = reqSpec.post("http://49.249.28.218:8091/addProject");
		//all http methods whether from RestAssured class or RequestSpecification Interface
		//all of them return Response reference only
		
		//Step-3: Validate the response
		response.then().log().all();
		response.then().statusCode(201); // putting a Validation for post method
		//ValidatableResponse vresp = response.then();
	}
        //CRUD operations without BDD disadvantage: Unnecessary variables are used to store data
}
