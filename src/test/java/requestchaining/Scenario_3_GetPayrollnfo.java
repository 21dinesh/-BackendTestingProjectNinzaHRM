package requestchaining;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Scenario_3_GetPayrollnfo {
	
@Test
public void sampleTest() {
	
	// API-1==> Get Authentication
	 Response response =given()
			 
	 //Pass the protocol information
	  .formParam("client_id", "ninza-client")
	  .formParam("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
	  .formParam("grant_type", "client_credentials")
	 .when()
	 .post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
	 //Post request is being used to carry the protocol information and to get the token
	 response.then()
	 .log().all();
	 
	//Capture the token from the response
	 String token = response.jsonPath().get("access_token");
	 
	// API-2 ==> Get Payroll Info
	 given()
	 .auth().oauth2(token)
	.get("http://49.249.28.218:8091/admin/payrolls")
	.then()
	.log().all();
	
}
}
