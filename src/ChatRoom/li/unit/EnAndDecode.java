package ChatRoom.li.unit;

import javax.crypto.*;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;

public class EnAndDecode {
    public byte[] encode (String content) throws GeneralSecurityException {
        String key = "key";
//        String code = "code";
        byte[] encode = encode(key.getBytes(), content.getBytes());
        ArrayList arrayList = new EdcryptionArrLoad().EdcryptionArrLoad(content);
       return encode;


    }
    private static SecretKey getkey (byte[] key) throws NoSuchAlgorithmException {
        SecureRandom sha1PRNG = SecureRandom.getInstance("SHA1PRNG");
        sha1PRNG.setSeed(key);
        KeyGenerator aes = KeyGenerator.getInstance("AES");
        aes.init(128, sha1PRNG);
        return aes.generateKey();
    }
    public static byte[] encode(byte[] code,byte[] key) throws java.security.GeneralSecurityException {
        SecretKey getkey = getkey(key);
        Cipher aes = Cipher.getInstance("AES");
        aes.init(Cipher.ENCRYPT_MODE,getkey);
        return aes.doFinal(code);
    }




}
