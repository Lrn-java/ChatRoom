/*
*
*
*
* */





package ChatRoom.li.Utils;
import javax.crypto.*;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class EnAndDecode {

    private final String keyy = "key";

    private  byte[] Type_conversioned(String code) {
        byte[] bytes;


        bytes = code.getBytes();


        return bytes;
    }
    private  SecretKey getkey(byte[] key) throws NoSuchAlgorithmException {
        SecureRandom sha1PRNG = SecureRandom.getInstance("SHA1PRNG");
        sha1PRNG.setSeed(key);
        KeyGenerator aes = KeyGenerator.getInstance("AES");
        aes.init(128, sha1PRNG);
        return aes.generateKey();
    }

    private  byte[] encodem(byte[] code, byte[] key) throws java.security.GeneralSecurityException {
        SecretKey getkey = getkey(key);
        Cipher aes = Cipher.getInstance("AES");
        aes.init(Cipher.ENCRYPT_MODE, getkey);
        return aes.doFinal(code);
    }

    private   byte[] decodem(byte[] code, byte[] key) throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        SecretKey getkey = getkey(key);
        Cipher aes = Cipher.getInstance("AES");
        aes.init(Cipher.DECRYPT_MODE, getkey);
        return aes.doFinal(code);
    }

    public byte[] encode(String content) throws GeneralSecurityException {

//        byte[] con = Type_conversion(content);
//        byte[] key = Type_conversion(keyy);
////        String string = Base64.getEncoder().encodeToString(content.getBytes());
////        System.out.println();
//        byte[] bytes = content.getBytes();
//        System.out.println(Arrays.toString(bytes));
////        byte[] bytes1 = key.getBytes();
////        byte[] encodem = encodem(bytes, bytes1);
////        System.out.println(Arrays.toString(encodem));
////        byte[] decodem = decodem(encodem, bytes1);
////        System.out.println(Arrays.toString(decodem));
//        byte[] encodem = encodem(Type_conversion(content), Type_conversion(key));
//        System.out.println(Arrays.toString(encodem));
//        byte[] decodem = decodem(encodem, Type_conversion(key));
//        System.out.println(Arrays.toString(decodem));
        byte[] kbytes = Type_conversioned(this.keyy);
        byte[] cbytes = Type_conversioned(content);
        return encodem(cbytes, kbytes);


    }

    public byte[] decode(byte[] content) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        byte[] kbytes = Type_conversioned(this.keyy);
        return decodem(content, kbytes);

    }


}
