package Utilities;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EncryptedPassword {
	
	public static String password = "Galaxe@123";
	public static String secretKey = "1234567890123456";  
	
	public static String encryptPassword(String password, String secretKey) throws Exception {
		// Create a SecretKeySpec using the secret key
		SecretKeySpec key = new SecretKeySpec(secretKey.getBytes(), "AES");

		// Create a Cipher object and initialize it for encryption
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, key);

		// Encrypt the password
		byte[] encryptedPassword = cipher.doFinal(password.getBytes());

		// Return the encrypted password as a Base64 encoded string
		return Base64.getEncoder().encodeToString(encryptedPassword);
	}

	// Method to decrypt the password
	public static Object decryptPassword(String encryptedPassword, String secretKey) throws Exception {
		// Create a SecretKeySpec using the secret key
		SecretKeySpec key = new SecretKeySpec(secretKey.getBytes(), "AES");

		// Create a Cipher object and initialize it for decryption
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, key);

		// Decode the Base64 encoded encrypted password
		byte[] decodedEncryptedPassword = Base64.getDecoder().decode(encryptedPassword);

		// Decrypt the password
		byte[] decryptedPassword = cipher.doFinal(decodedEncryptedPassword);

		// Return the decrypted password as a string
		return new String(decryptedPassword);
	}

}
