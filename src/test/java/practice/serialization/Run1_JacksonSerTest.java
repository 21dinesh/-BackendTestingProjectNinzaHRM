package practice.serialization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonPropertyOrder(value = {"createdBy", "projectName", "teamSize", "status"})
@JsonIgnoreProperties(value = {"teamSize"}, allowSetters=true) //allowSetters=true is mandatory
class Project { // POJO class (POJO : Plain Old Java Object)
	// Generally the business class you create during serialization, that class we
	// call it as POJO class in java

	private String projectName;
	@JsonProperty(value ="created By")
	private String createdBy;
	private String status;
	private int teamSize;

	private Project() {
	} // Empty constructor created for de-serialization. You can make it public as well
//InvalidDefinitionException will come when we are not using empty constructor
	
	public Project(String projectName, String createdBy, String status, int teamSize) {
		super();
		this.projectName = projectName;
		this.createdBy = createdBy;
		this.status = status;
		this.teamSize = teamSize;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
}

public class Run1_JacksonSerTest {
	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {

		Project pObj = new Project("FB_125", "Rohit", "Created", 0); // Creating a java object for the above POJO class

		ObjectMapper objectMapper = new ObjectMapper(); // To convert this java object to JSON file that is to achieve
														// jackson serialization or marshalling
		objectMapper.writeValue(new File("./project.json"), pObj); // Here jackson serialization happens
		System.out.println("Ends");

//By taking help of setters method it will write data back to json file, that is, 
//all the properties available in the POJO class object will be converted to JSON file,
//so that conversion is taken care by ObjectMapper
	}
}
