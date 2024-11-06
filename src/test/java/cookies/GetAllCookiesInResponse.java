package cookies;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.Map;

import io.restassured.response.Response;

public class GetAllCookiesInResponse {
	
	@Test
	public void getAllCookies() {
		
		// to get all cookies we have a method getCookies() in Response
		// (so break the line after get)
		Response response = given().when().get("https://www.google.com");
		
		// to capture all cookies info
		Map<String, String> allCookies = response.getCookies();
		
		// to capture only keys
		System.out.println(allCookies.keySet());
		
		// to capture value using key
		for(String cookieKey : allCookies.keySet()) {
			String cookieValue = response.getCookie(cookieKey);
			System.out.println(cookieKey+" "+cookieValue);
		}
	}
}
