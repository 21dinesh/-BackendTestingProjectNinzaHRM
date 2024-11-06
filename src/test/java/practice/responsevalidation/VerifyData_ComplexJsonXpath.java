package practice.responsevalidation;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

public class VerifyData_ComplexJsonXpath {
	
	@Test
	public void sampleTest() {
		Response response = given().get("http://49.249.28.218:8091/projects-paginated");

		response.then().log().all();
		
		ArrayList<String> arrayList = JsonPath.read(response.asString(),"content[*].projectName");
		//read method always returns ArrayList
		
		for(String data : arrayList) {
		System.out.println(data);
		}
		
		ArrayList<String> arrayList1 = JsonPath.read(response.asString(),"content[*].[?(@.projectName=='GreenAPPLE_4064')].projectId");
		String actualProjectId = arrayList1.get(0);
		
		Assert.assertEquals(actualProjectId, "NH_PROJ_979");
		
		//extract firstProjectId
		//DB validation
		//request chaining
		
	}
}
