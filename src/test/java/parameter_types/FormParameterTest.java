package parameter_types;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class FormParameterTest {
	
	@Test
	public void sampleTest() {
		given()
		.formParam("teamSize", 10)
		.log().all()
		.when()
		.get("http://49.249.28.218:8091/project")
		//formParam() can't be used with get request coz we don't have a body
		.then()
		.log().all();
	}
}
