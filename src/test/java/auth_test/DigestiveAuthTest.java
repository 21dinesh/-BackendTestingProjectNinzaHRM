package auth_test;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DigestiveAuthTest {

	@Test
	public void sampleTest() {
given()
.auth().digest("rohit93m@gmail.com", "Rohit@1993")
.log().all()
.when()
.get("http://49.249.29.5:8091/dashboard/transactions")
.then()
.log().all();
	}
}
