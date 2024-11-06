package parameter_types;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class QueryParameterTest {
	
	@Test
	public void sampleTest() {
		given()
		//We can also use DataProvider to pass this data here
		.queryParam("teamSize", 10)
		.log().all()
		.when()
		.get("http://49.249.28.218:8091/project")
		.then()
		.log().all();
	}
}
