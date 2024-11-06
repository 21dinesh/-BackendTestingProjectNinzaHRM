package com.sample.crud.withoutbdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleTestForDeleteTest {
	
	@Test
	public void deleteDataFromServerTest() {
		
		//Step-1: Create prerequisites
		
		//Step-2: Perform action
		Response response = RestAssured.delete("http://49.249.28.218:8091/project/NH_PROJ_693");
		
		//Step-3: Validate
		response.then().log().all();
		response.then().assertThat().statusCode(204);
	} 
}
