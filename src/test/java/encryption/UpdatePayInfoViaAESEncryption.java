package encryption;

import org.testng.annotations.Test;

import encryptanddecrypt.utility.EncryptAndDecryptUtility;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class UpdatePayInfoViaAESEncryption {

	@Test
	public void sampleTest() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {

		EncryptAndDecryptUtility ed = new EncryptAndDecryptUtility();

		String jBody = "{ \"employee\": { \"empId\":\"NH_00121\", \"designation\": \"string\", \"dob\": \"dd/MM/yyyy\", \"email\": \"string\", \"empName\": \"string\", \"experience\": 0, \"mobileNo\": \"string\", \"project\": \"string\", \"role\": \"string\", \"username\": “string” }, \"basicPlusVda\": 0, \"hra\": 5000, \"insurance\": 3000, \"lta\":2000 , \"lwf\": 5000, \"netPay\": 5000, \"payroll_id\": 0, \"pf\": 0, \"pt\": 0, \"stat_bonus\": 0}";

		String jReqBody = ed.encrypt(jBody, "Ac03tEam@j!tu_#1");
		System.out.println(jReqBody);
		
		Response response = given().body(jReqBody).when().put("http://49.249.28.218:8091/payroll");
		response.then().log().all();
	}
}
