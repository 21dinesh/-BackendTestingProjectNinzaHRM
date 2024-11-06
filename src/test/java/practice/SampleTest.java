package practice;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class SampleTest {
	
	@Test
	public void samplePostRequestTest() {
	
		Response response = given()
		.auth().basic("sk_test_tR3PYbcVNZZ796tH88S4VQ2u:","")
		.formParam("name", "rohit")
		.formParam("phone", "9876543210")
		.log().all()
		.when()
		.post("https://api.stripe.com/v1/customers");
		response.then()
		.log().all();
	}

	@Test
	public void sampleGetRequestTest() {
		
		Response response = get("https://reqres.in/api/users?page=1");
		//get method will execute this end point via http protocol
		
		response.prettyPrint();
		System.out.println("========================================");
		response.prettyPeek();
		System.out.println("========================================");
		System.out.println(response.prettyPrint());
		System.out.println("========================================");
		System.out.println(response.prettyPeek());

		
	}
}
