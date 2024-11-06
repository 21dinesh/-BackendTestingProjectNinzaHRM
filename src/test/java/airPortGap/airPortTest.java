package airPortGap;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class airPortTest {
	@Test
	public void airPortAPI() {
		
		baseURI ="https://airportgap.com/api";
		
		Response resp=given().get("/airports");
		resp.then().log().all();
		String id1=resp.jsonPath().get("data[2].id");
		String id2=resp.jsonPath().get("data[3].id");
		System.out.println(id1);
		System.out.println(id2);
		System.out.println("==============1st API END==============");
		
		Response resp1=given().get("/airports/"+id1);
		resp1.then().log().all();
		System.out.println(resp1);
		System.out.println("==============2nd API END==============");
		
		Response resp2=given().post("/airports/distance?from="+id1+"&to="+id2+"");
		resp2.then().log().all();
		Float km=resp2.jsonPath().get("data.attributes.kilometers");
		Float mil=resp2.jsonPath().get("data.attributes.miles");
		Float nautical_mile=resp2.jsonPath().get("data.attributes.nautical_miles");
		System.out.println("kilometers "+km);
		System.out.println("miles "+mil);
		System.out.println("nautical_mile "+nautical_mile);
		
		System.out.println("==============3rd API END==============");
		
		Response resp3= given().formParam("email","test@airportgap.com").formParam("password", "airportgappassword").post("/tokens");
		resp3.then().log().all();
		String token=resp3.jsonPath().get("token");
		System.out.println("token"+token);
		System.out.println("==============4th API END==============");
		
		Response resp4= given().header("Authorization","Bearer token="+token).formParam("airport_id", id2).formParam("note","this is the note").post("/favorites");
		String fav_id=resp4.jsonPath().get("data.id");
		resp4.then().log().all(); 
		System.out.println("==============5th API END==============");
		
		Response resp5=given().header("Authorization","Bearer token="+token).formParam("note","this is the NEW note").patch("/favorites/"+fav_id);
		
		resp5.then().log().all(); 
		System.out.println("==============6th API END==============");
		
		Response respDel=given().header("Authorization", "Bearer token="+token).delete("/favorites/clear_all");
		respDel.then().log().all(); 
	} 

}
