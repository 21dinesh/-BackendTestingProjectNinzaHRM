package com.sample.crud.withbdd;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class SampleTestForReadTest {
	@Test
	public void getDataFromServerTest() {
		
		given()
		.contentType(ContentType.JSON)
		.when()
		.get("http://49.249.28.218:8091/projects") // Step-2: Perform action
		.then() // Step-3: Validation
		.contentType(ContentType.JSON)
		.statusCode(200)
		.log().all();
	}
}
