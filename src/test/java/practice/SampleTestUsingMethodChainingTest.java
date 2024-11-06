package practice;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class SampleTestUsingMethodChainingTest {
	
	@Test
	public void getRequestTest() {
		
//		get("https://reqres.in/api/users?page=1").prettyPrint();
//		prettyPrint() will only return the response pay load
		
//		Response response = RestAssured.get("https://reqres.in/api/users?page=1");
//		get method will execute this end point via http protocol
//		System.out.println(response.prettyPrint());
		
		get("https://reqres.in/api/users?page=1").then().log().all();
//		then().log().all() will give you complete information about the response 
//		like response header and response body
	}
}
