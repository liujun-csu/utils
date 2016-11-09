package cn.edu.csu;
import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import org.apache.commons.codec.binary.Base64;

//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;

public class SecurityUtil {
    public static String DES = "AES"; // optional value AES/DES/DESede

    public static String CIPHER_ALGORITHM = "AES"; // optional value AES/DES/DESede


    public static Key getKey(String strKey) {
        try {
            if (strKey == null) {
                strKey = "";
            }
            KeyGenerator _generator = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(strKey.getBytes());
            _generator.init(128, secureRandom);
            return _generator.generateKey();
        } catch (Exception e) {
            throw new RuntimeException(" 初始化密钥出现异常 ");
        }
    }

    public static String encrypt(String data, String key) throws Exception {
        SecureRandom sr = new SecureRandom();
        Key secureKey = getKey(key);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secureKey, sr);
        byte[] bt = cipher.doFinal(data.getBytes());
//        @SuppressWarnings("restriction")
//		String strS = new BASE64Encoder().encode(bt);
		String strS = Base64.encodeBase64String(bt);
        return strS;
    }


    public static String decrypt(String message, String key) throws Exception {
        SecureRandom sr = new SecureRandom();
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        Key secureKey = getKey(key);
        cipher.init(Cipher.DECRYPT_MODE, secureKey, sr);
//        @SuppressWarnings("restriction")
//		byte[] res = new BASE64Decoder().decodeBuffer(message);
		byte[] res = Base64.decodeBase64(message);
        res = cipher.doFinal(res);
        return new String(res);
    }

    public static void main(String[] args) throws Exception {
        String message = "123456";
        String key = "landLeaf";
        String encryptMsg = encrypt(message, key);
        System.out.println("encrypted message is below :");
        System.out.println(encryptMsg);

        String decryptedMsg = decrypt(encryptMsg, key);
        System.out.println("decrypted message is below :");
        System.out.println(decryptedMsg);
    }
}
