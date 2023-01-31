/*package whatever //do not write package name here */

// Java code of above approach
// Importing required packages

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class GFG {
	public static void main(String[] args) throws IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException, NoSuchAlgorithmException, InvalidKeyException {
		String path = "C:\\Users\\fahimXD\\Desktop\\ddd\\ll";
		File fObj = new File(path);
		File[] ew = fObj.listFiles();

		for (File i : ew) {
			System.out.println("raw");
			String ee = i.toString().substring(i.toString().lastIndexOf("\\") + 1, i.toString().length() - 4).replace("@","/");
			enc(ee);

		}


	}


	public static void enc(String str) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, NoSuchAlgorithmException {
		String s = null;

		Cipher desCipher = Cipher.getInstance("DES");
		String encodedKey = "I9DOH5L4q38=";

		byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
		SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "DES");



		try {
			byte[] decode = Base64.getDecoder().decode(str);

			desCipher.init(Cipher.DECRYPT_MODE, originalKey);
			byte[] textDecrypted
					= desCipher.doFinal(decode);
			s = new String(textDecrypted);
			System.out.println(s);
		}catch (Exception e){
			s = e.toString();
			System.out.println(e);
		}


	}
}


