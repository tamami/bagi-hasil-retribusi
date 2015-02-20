package lab.aikibo.test;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import lab.aikibo.util.Encrypt;

public class MD5Test {
	
	public static void main(String args[]) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidAlgorithmParameterException {
		String text = "RAHASIA";
		System.out.println("Hasilnya : " + Encrypt.getEncrypted(text));
		String result = Encrypt.getEncrypted2(text);
		System.out.println("Hasil ke-2 : " + result);
		System.out.println("Decode : " + Encrypt.getDecrypted2(result));
	}

}
