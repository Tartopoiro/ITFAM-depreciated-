package com.accountx.controleur;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Properties;

public class CryptoUtils {

    private static final String ALGO = "AES";

    private static byte[] getSEL() {
        //recupération du SEL
        String sel ="";
        String selPath = "../../../../../accountX/src/main/webapp/WEB-INF/SEL.properties";
        Properties properties = new Properties();
        InputStream inputStream = null;

        try {
            inputStream = new FileInputStream(selPath);
            properties.load(inputStream);
            sel = properties.getProperty("sel");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        byte[] key = sel.getBytes();
        byte[] key32 = new byte[32];
        System.arraycopy(key, 0, key32, 0, 32);
        return key32;
    }
    //Methode pour crypter avec l'algo AES
    public static String encrypt(String value) throws Exception {
        SecretKeySpec spec = new SecretKeySpec(getSEL(), ALGO);
        Cipher cipher = Cipher.getInstance(ALGO);
        cipher.init(Cipher.ENCRYPT_MODE, spec);
        byte[] encryptedBytes = cipher.doFinal(value.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
    //Methode pour décrypter avec l'algo AES
    public static String decrypt(String encryptedValue) throws Exception {
        SecretKeySpec spec = new SecretKeySpec(getSEL(), ALGO);
        Cipher cipher = Cipher.getInstance(ALGO);
        cipher.init(Cipher.DECRYPT_MODE, spec);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedValue));
        return new String(decryptedBytes);
    }
}
