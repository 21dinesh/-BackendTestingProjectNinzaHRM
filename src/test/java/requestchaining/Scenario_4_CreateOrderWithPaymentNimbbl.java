package requestchaining;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Scenario_4_CreateOrderWithPaymentNimbbl {
	
@Test
public void sampleTest() {
	
	//https://nimbbl.biz/docs/api-reference/introduction/
	
	baseURI = "https://api.nimbbl.tech";
	
	//Authorization POST request to generate Token
	
	JSONObject jObj = new JSONObject();
	jObj.put("access_key","access_key_pKx7rWVgVpbXQvq2");
	jObj.put("access_secret","access_secret_DX3w55VKAkXbx7aB");
	
	Response response = given()
	.body(jObj)
	.contentType(ContentType.JSON)
	.post("api/v3/generate-token");
	response.then()
	.log().all();
	String bearerToken = response.jsonPath().get("token");
	
	//Create an order POST request

	File fileObj = new File("./src/test/resources/nimbbl_order.json");
	
	Response response1 = given()
	.body(fileObj)
	.contentType(ContentType.JSON)
	.header("Authorization","Bearer "+bearerToken)
	.post("/api/v3/create-order");
	response1.then()
	.log().all();
	String orderId = response1.jsonPath().get("order_id");
	String userToken = response1.jsonPath().get("user.token");
	
	
	//Initiate payment POST request
	
	JSONObject jObj1 = new JSONObject();
	jObj1.put( "order_id", orderId);
	jObj1.put( "callback_url", "https://mangoseller.awesome/transaction-response");
	jObj1.put( "payment_mode_code", "net_banking");
	jObj1.put( "bank_code", "axis");
		
	Response response2 = given()
	.body(jObj1)
	.contentType(ContentType.JSON)
	.auth().oauth2(bearerToken)
	.post("api/v3/initiate-payment");
	 response2.then()
	.log().all();
	
	
  }


}
