package practice.responsevalidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class VerifyResponseHeaderTest {

	@Test
	public void verifyHeader() {
		
		Response response = given()
				.log().all()
				.when().get("http://49.249.28.218:8091/projects");
				
		response.then().log().all();
		
        //Assertion on Response Header
		response.then().assertThat().contentType(ContentType.JSON);
		response.then().assertThat().statusLine("HTTP/1.1 200 ");
		response.then().assertThat().statusCode(200);
		response.then().assertThat().header("Transfer-Encoding","chunked");
		

	}
}
