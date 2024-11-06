package encryption;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.testng.annotations.Test;

import encryptanddecrypt.utility.EncryptAndDecryptUtility;

public class AES_EncryptTest {

	@Test
	public void sampleTest() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		
		String privateKey = "Ac03tEam@j!tu_#1";
		String actualData = "{\"name\":\"rohit\",\"id\":\"tp01\"}";
		
		//This data is going to be encrypted using the private key
		EncryptAndDecryptUtility ed = new EncryptAndDecryptUtility();
		String encryptedData = ed.encrypt(actualData, privateKey);
		
		System.out.println(encryptedData);
		//Now after encryption this data is not at all understandable, this is called cryptographic text
		
		actualData = ed.decrypt(encryptedData, privateKey);
		System.out.println(actualData);
		
		//This is called AES encryption, it is a symmetric encryption, for both encryption and decryption we are going to use the same private key 
	    
	}
}
