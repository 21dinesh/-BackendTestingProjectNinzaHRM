package com.sample.crud.withbdd;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class SampleTestForDeleteTest {

	@Test
	public void deleteDataFromServer() {
		
		given() //we can use given even if there is no precondition
		//.contentType(ContentType.JSON)
		.delete("http://49.249.28.218:8091/project/NH_PROJ_696") // Step-2: Perform action
		.then() // Step-3: Validation
		.assertThat().statusCode(204)
		.log().all();
		
	}

}
