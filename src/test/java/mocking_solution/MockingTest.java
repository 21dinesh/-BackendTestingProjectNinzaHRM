package mocking_solution;

import org.mockito.Mockito;
import org.testng.Assert;

//Code to develop PAN Card mocking solution using Mockito

class PANCard {

	public String isValid(String panCard) {

		// Business Library
		if (panCard.matches("[A-Z]{5}[0-9]{4}[A-Z]") == true) {
			// Inside matches() function i am giving pattern of the Pan Card schema
			// The matches() function will take care of the validation that is the passed
			// PAN card is valid or not
			return "is valid PAN";
		} else {
			return "is invalid PAN";
		}
	}

	public static PANCard getMockObject() {
		PANCard mockObj = Mockito.mock(PANCard.class);
		//inside mock() function you have to specify for which class you are planning to develop a mocking solution or stub
		//By taking help of mock() function i am going to develop mocking solution for PANCard class
		//if you want to use mock data, call this method, this method will return the object of PANCard
		//Using this object you have to call isValid() method
		
		//To develop mock(dummy) data or PAN Card no.
		Mockito.when(mockObj.isValid("ABCDE1234A")).thenReturn("Valid PAN Card");
		Mockito.when(mockObj.isValid("ABCDE1234B")).thenReturn("Valid PAN Card");
		Mockito.when(mockObj.isValid("ABCDE1234C")).thenReturn("Invalid PAN Card");
		//Now as per this method if you want to use the above business logic, you have to use only the above three pan cards
		// i am providing. During testing we have to use only these 3. And this is a STUB actually
		return mockObj;
	}
}

public class MockingTest {

	public static void main(String[] args) {
    PANCard obj = PANCard.getMockObject();
    System.out.println(obj.isValid("ABCDE1234A"));
    System.out.println(obj.isValid("ABCDE1234B"));
    System.out.println(obj.isValid("ABCDE1234C")); // Not valid
    System.out.println(obj.isValid("ABCDE1234D")); // Output will be null as it means even though this data comes under the
    //schema of the PAN card, this data is not added in the mocking solution
    System.out.println(obj.isValid("ABCDE1234a")); // null output
    
    Assert.assertEquals(obj.isValid("ABCDE1234D"),"Valid PAN Card");
	}

}
