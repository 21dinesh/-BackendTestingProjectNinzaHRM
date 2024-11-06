package mocking_solution;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreditCardPaymentTest {

	@Test
	public void sampleTest() {
		
JSONObject jObj = new JSONObject();
jObj.put("creditcard", "1234567891237");
jObj.put("cvv", "123");
jObj.put("cardName", "rohit");

		given()
		.contentType(ContentType.JSON)
		.body(jObj)
		.when()
		.post("http://localhost:8889/credit-card")
		.then()
		.log().all();

	}
}
