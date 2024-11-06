package requestchaining;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclass.utility.EmployeePOJO;
import pojoclass.utility.ProjectPojo;

public class Scenario_2_AddEmployeeToProject {

	@Test
	public void sampleTest() {

		// Step-1: Create pre-requisites
		Random random = new Random();
		int ranNum = random.nextInt(5000);

		// API-1 ==> Add a project inside the server
		ProjectPojo projectPojoObj = new ProjectPojo("FB_" + ranNum, "Created", "Rohit", 0);

		Response response = given()
				.contentType(ContentType.JSON)
				.body(projectPojoObj)
	
				.when() // Step-2: Perform action
				.post("http://49.249.28.218:8091/addProject");
		         response.then() // Step-3: Validation
				.assertThat()
				.statusCode(201)
				.log().all();
		         
		         //capture project name from response
		         String projectName = response.jsonPath().get("projectName");
		         System.out.println(projectName);
		         
		// API-2 ==> Add an Employee to same project
		       //  String designation, String dob, String email, String empName, double experience,
				//	String mobileNo, String project, String role, String username
		         
	    EmployeePOJO empObj = new EmployeePOJO("Architect", "24/04/1983", "rohit@gmail.com", "user_"+ranNum, 18, "9876543210", projectName, "ROLE_EMPLOYEE", "user_"+ranNum);
	    given()
		.contentType(ContentType.JSON)
		.body(empObj)

		.when() // Step-2: Perform action
		.post("http://49.249.28.218:8091/employees")
        .then() // Step-3: Validation
		.assertThat()
		.statusCode(201)
		.log().all();     

		         
	}
}
