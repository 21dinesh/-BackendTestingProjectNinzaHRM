package datadriventesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import file.utility.ExcelUtility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.IOException;

public class AddMultipleProjectTest {

	@Test(dataProvider = "getData")
	public void sampleTest(String pName, String status) {

		String reqBody = "{\r\n" + "  \"createdBy\": \"Rohit\",\r\n" + "  \"projectName\": \"" + pName + "\",\r\n"
				+ "  \"status\": \"" + status + "\",\r\n" + "  \"teamSize\": 0\r\n" + "}";
		given().contentType(ContentType.JSON).body(reqBody).when().post("http://49.249.28.218:8091/addProject").then()
				.log().all();
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		
		/*
		 * First the control comes to @DataProvider annotated method. @DataProvider
		 * annotation by taking help of the Apache POI excel utility, reads all the
		 * data available from excel and constructs an object array. Entire object
		 * array data will be sent to @Test annotated method test case and that same
		 * test case will be executed multiple times with different sets of data. This
		 * is the concept of dataProvider annotation.
		 */	
		
		ExcelUtility excelUtils = new ExcelUtility();
		int rowcount = excelUtils.getRowCount("project");

		Object[][] objArr = new Object[rowcount][2];
		
		for( int i=0;i<rowcount;i++) {
			
			objArr[i][0] = excelUtils.getDataFromExcel("project", i+1, 0 );
			objArr[i][1] = excelUtils.getDataFromExcel("project", i+1, 1);
		}

		return objArr;
	}

}
