package practice.serialization;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

class Project1 {

	String projectName;
	String projectStatus;
	int teamSize;
	List<String> teamMember;
	ProjectManager projectManager;

	public Project1(String projectName, String projectStatus, int teamSize, List<String> teamMember,
			ProjectManager projectManager) {

		super();
		this.projectName = projectName;
		this.projectStatus = projectStatus;
		this.teamSize = teamSize;
		this.teamMember = teamMember;
		this.projectManager = projectManager;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamMember(List<String> teamMember) {
		this.teamMember = teamMember;
	}

	public List<String> getTeamMember() {
		return teamMember;
	}

	public void setProjectManager(ProjectManager projectManager) {
		this.projectManager = projectManager;
	}

	public ProjectManager getProjectManager() {
		return projectManager;
	}

}

class ProjectManager {

	String name;
	String empID;

	public ProjectManager(String name, String empID) {
		super();
		this.name = name;
		this.empID = empID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public String getEmpID() {
		return empID;
	}

}

public class Run3_POJO {
	public static void main(String[] args) throws DatabindException, IOException {

		ArrayList<String> list = new ArrayList<String>();
		list.add("John");
		list.add("David");
		list.add("Steve");

		ProjectManager pM = new ProjectManager("Rohit", "tp01");

		Project1 project1 = new Project1("FB_126", "Created", 10, list, pM);

		System.out.println(project1.projectName);
		System.out.println(project1.projectStatus);
		System.out.println(project1.teamSize);
		System.out.println(project1.teamMember);
		System.out.println(project1.projectManager);

//Serialization: Using POJO class I am converting this data back to json file
		ObjectMapper objectMapper = new ObjectMapper(); // To convert this object back to json file
		objectMapper.writeValue(new File("./Project1.json"), project1);
	}
}
