package encryption;

import java.util.Base64;

import org.testng.annotations.Test;

public class EncodingAndDecodingTest {

	@Test
	public void sampleTest() {

		String encodedData = new String(Base64.getEncoder().encode("Rohit".getBytes()));
		System.out.println(encodedData);

		String decodedData = new String(Base64.getDecoder().decode("Um9oaXQ=".getBytes()));
		System.out.println(decodedData);
	}
}
