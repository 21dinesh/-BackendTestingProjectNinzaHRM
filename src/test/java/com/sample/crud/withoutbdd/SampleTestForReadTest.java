package com.sample.crud.withoutbdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleTestForReadTest {
	
	@Test
	public void getDataFromServerTest() {
	//Step-1: Create a pre-requsite
		
    //Step-2: Perform the action
	Response response = RestAssured.get("http://49.249.28.218:8091/projects");
    //System.out.println(response.prettyPrint()); //This is going to print the response in json format
    //System.out.println(response.asString()); // This is going to print the response in string format
	
	//Step-3: Provide validation
	response.then().assertThat().statusCode(200); //Putting a validation for get request
	response.then().log().all();/*To display complete log of the response, log includes complete 
	header and body both*/
	}

}
