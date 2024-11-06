package practice;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Run2 {

	@Test
	public void sampleTest() {
		given()
		.formParam("name", "rohit")
		.formParam("email", "rohit@gmail.com")
		.formParam("password", "11213")
		.log().all()
		.when()
		.post("https://reqres.in/api/users")
		.then()
		.statusCode(200)
		.log().all()
		;

	}
}
