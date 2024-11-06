package miscellaneous_topics;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GraphQLApiTest {
	
	@Test
	public void graphQLApiTest() {
		
		String graphQLQuery = "{ findProject(projectId:\"NH_PROJ_985\")"
				+ "{ projectId"
				+ " projectName"
				+ " status"
				+ " createdBy"
				+ " teamSize"
				+ " }"
				+ " }";
		Response response = given()
				//.header("Content-Type","application/json")
				.body(graphQLQuery)
				.contentType(ContentType.JSON)
				.post("http://49.249.28.218:8091/getProjectByProjectId");
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		response.then().log().all();
	}
	
	
	@Test
	public void graphQLApiTest2() {
		
		String graphQLQuery = "{ getAllProjects"
				+ "{ projectId"
				+ " projectName"
				+ " status"
				+ " }"
				+ " }";
		Response response = given()
				//.header("Content-Type","application/json")
				.body(graphQLQuery)
				.contentType(ContentType.JSON)
				.post("http://49.249.28.218:8091/getAll");
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		response.then().log().all();
	}

@Test
public void graphQLApiTest3() {
	
	String graphQLQuery = " mutation { addProject( projectName: \"xyz_12349999002\","
			+ " teamSize: 0,"
			+ " createdBy: \"Rohit\","
			+ " createdOn: \"2024-10-01\","
			+ " status: \"Created\" )"
			+ " { projectId projectName teamSize createdBy createdOn status } }";
	
	Response resp = given().contentType(ContentType.JSON)
			.body(graphQLQuery)
			.post("http://49.249.28.218:8091/addProject-graphql");
			
			String responseBody = resp.getBody().asString();
			System.out.println(responseBody);
			resp.then().log().all();
}

@Test
public void graphQLApiTest4() {
	
	String graphQLQuery = " mutation { updateProject( projectId: \"NH_PROJ_3142\""
			+ " projectName: \"xyz_12349999001\","
			+ " teamSize: 0,"
			+ " createdBy: \"R\","
			+ " createdOn: \"2024-10-01\","
			+ " status: \"Created\" )"
			+ " { projectId projectName teamSize createdBy createdOn status } }";
	
	Response resp = given().contentType(ContentType.JSON)
			.body(graphQLQuery)
			.post("http://49.249.28.218:8091/updateProject-graphql");
			
			String responseBody = resp.getBody().asString();
			System.out.println(responseBody);
			resp.then().log().all();
}


		
}
