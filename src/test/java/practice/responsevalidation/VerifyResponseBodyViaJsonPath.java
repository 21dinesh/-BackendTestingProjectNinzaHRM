package practice.responsevalidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

public class VerifyResponseBodyViaJsonPath {

	@Test
	public void sampleTest() {
		
		Response response = given().get("http://49.249.28.218:8091/projects-paginated");

		response.then().log().all();
		
		// Assertion on Response Body
		response.then().assertThat().body("numberOfElements", Matchers.greaterThanOrEqualTo(20));
		response.then().assertThat().body("pageable.sort.unsorted", Matchers.equalTo(true));
		response.then().assertThat().body("content[0].projectId", Matchers.equalTo("NH_PROJ_998"));
		
		ArrayList<String> arrayList = response.jsonPath().get("content[*].projectId");
		System.out.println(arrayList);
		

		
		/*
		 * int data = response.jsonPath().get("numberOfElements");
		 * System.out.println(data);
		 * 
		 * boolean data1 = response.jsonPath().get("pageable.sort.unsorted");
		 * System.out.println(data1);
		 * 
		 * String data3 = response.jsonPath().get("content[0].projectId");
		 * System.out.println(data3);
		 */
		
		

	}
}