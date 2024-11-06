package cookies;

import static io.restassured.RestAssured.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class PassingCookies {
	
	@Test
	public void singleCookie() {
		given()
		.cookie("AEC", "AVYB7coDLN50mKdMkHM4WVbj0s9UjOljxSUsvZAO1FzLwq77L7QWY2zw0OE")
		.log().all()
		.when()
		.post("https://www.google.com")
		.then()
		.log().all();
	}
	
	@Test
	public void passMultipleCookiesTest() {
		Response response = given()
		.cookie("username", "rohit","numbers","012"+"034"+"056")
		.log().all()
		.when()
		.post("http://49.249.28.218:8091/project/NH_PROJ_990");
		
		//Validate cookies
		response.then()
		.cookie("username")
		.log().all();
		
	    Map<String, String> cookies = response.getCookies();
	    System.out.println(cookies);
	}
}
