package auth_test;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class Auth2_0_Test {

	@Test
	public void sampleTest() {
		
	 Response response = given()
	  .formParam("client_id", "ninza-client")
	  .formParam("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
	  .formParam("grant_type", "client_credentials")
	//oauth2.0 supports multiple grant types
	.when()
	  //In the client app i have specified which application to talk, if the bearer token is correct it will redirect
	  //the request to actual resource
	.post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
	response.then()
	.log().all();
	
	//capture token from the response [KeyClock (oauth 2.0)]
	String token = response.jsonPath().get("access_token");
		
given()
.auth().oauth2(token)
.when()
.get("http://49.249.28.218:8091/projects")
.then()
.log().all();
	}
}
