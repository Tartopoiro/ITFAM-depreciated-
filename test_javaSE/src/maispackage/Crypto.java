package maispackage;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Crypto {
    private static final String ALGO = "AES";
    private static byte[] getSEL() {
        String sel = "buigiufbxbcgn,fxhgw,nwfhg,wddffbfbfb";
        byte[] key = sel.getBytes();
        byte[] key32 = new byte[32];
        System.arraycopy(key, 0, key32, 0, 32);
        return key32;
    }
    public static String encrypt(String value) throws Exception {

        SecretKeySpec spec = new SecretKeySpec(getSEL(), ALGO);
        Cipher cipher = Cipher.getInstance(ALGO);
        cipher.init(Cipher.ENCRYPT_MODE, spec);
        byte[] encryptedBytes = cipher.doFinal(value.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encryptedValue) throws Exception {

        SecretKeySpec spec = new SecretKeySpec(getSEL(), ALGO);
        Cipher cipher = Cipher.getInstance(ALGO);
        cipher.init(Cipher.DECRYPT_MODE, spec);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedValue));
        return new String(decryptedBytes);
    }
}
