package practice.responsevalidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class VerifyResponseTimeTest {

	@Test
	public void verifyResponseTime() {
		
		Response response = given().get("http://49.249.28.218:8091/projects");
				
		response.then().log().all();

		long timeTaken = response.time();
		System.out.println(timeTaken);
		long timeTakenSec = response.timeIn(TimeUnit.SECONDS);
		System.out.println(timeTakenSec);

         //Assertion on Response Time, better practice is to go with Matchers
		response.then().assertThat().time(Matchers.lessThan(1500L));
		response.then().assertThat().time(Matchers.greaterThan(300L));
		response.then().assertThat().time(Matchers.both(Matchers.lessThan(1500L)).and(Matchers.greaterThan(300L)));
	}
}
