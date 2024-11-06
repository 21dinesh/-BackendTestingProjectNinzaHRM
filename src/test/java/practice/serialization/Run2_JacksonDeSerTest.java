package practice.serialization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Run2_JacksonDeSerTest {
	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		// De-serialization means converting json file back to java object

		ObjectMapper objectMapper = new ObjectMapper();
		Project pObj = objectMapper.readValue(new File("./project.json"), Project.class);
		
		// second argument is name of the POJO class
		// readValue method goes to this file and converts the entire json file into object of this POJO class
		// We will receive the object in pObj variable
		// so that entire json file will be converted into java object, which is called as de-serialization
		
		System.out.println(pObj.getProjectName());
		System.out.println(pObj.getCreatedBy());
		System.out.println(pObj.getStatus());
		System.out.println(pObj.getTeamSize());
		//We are using getters to retrieve the data
		
	}
}
