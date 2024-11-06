package cookies;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ValidatingCookie2 {

	@Test
	public void validateCookie() {
		
		// to validate cookies we have method under then() - cookie
		given().when().get("https://www.google.com")
		.then().cookie("AEC").cookie("NID").log().all();
		
		// this cookie method is present in given, then, response interface also
	}
}
