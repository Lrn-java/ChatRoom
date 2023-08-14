package ChatRoom.li.Utils;
import javax.crypto.*;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 *
 */
public class EnAndDecode {

    private final String keyy = "key";

    /**
     * 字符串转换为字节数组
     * @param code
     * @return
     */
    private  byte[] Type_conversioned(String code) {
        byte[] bytes;
        bytes = code.getBytes();
        return bytes;
    }

    /**
     * 生成密钥
     * @param key
     * @return
     * @throws NoSuchAlgorithmException
     */
    private  SecretKey getkey(byte[] key) throws NoSuchAlgorithmException {
        SecureRandom sha1PRNG = SecureRandom.getInstance("SHA1PRNG");
        sha1PRNG.setSeed(key);
        KeyGenerator aes = KeyGenerator.getInstance("AES");
        aes.init(128, sha1PRNG);
        return aes.generateKey();
    }

    /**
     * 加密操作
     * @param code
     * @param key
     * @return
     * @throws java.security.GeneralSecurityException
     */
    private  byte[] encodem(byte[] code, byte[] key) throws java.security.GeneralSecurityException {
        SecretKey getkey = getkey(key);
        Cipher aes = Cipher.getInstance("AES");
        aes.init(Cipher.ENCRYPT_MODE, getkey);
        return aes.doFinal(code);
    }

    /**
     * 解密
     * @param code
     * @param key
     * @return
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     * @throws InvalidKeyException
     */
    private   byte[] decodem(byte[] code, byte[] key) throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        SecretKey getkey = getkey(key);
        Cipher aes = Cipher.getInstance("AES");
        aes.init(Cipher.DECRYPT_MODE, getkey);
        return aes.doFinal(code);
    }

    /**
     * 字符串加密
     * @param content
     * @return
     * @throws GeneralSecurityException
     */
    public byte[] encode(String content) throws GeneralSecurityException {
        byte[] kbytes = Type_conversioned(this.keyy);
        byte[] cbytes = Type_conversioned(content);
        return encodem(cbytes, kbytes);
    }

    /**
     *
     * @param content
     * @return
     * @throws NoSuchPaddingException
     * @throws IllegalBlockSizeException
     * @throws NoSuchAlgorithmException
     * @throws BadPaddingException
     * @throws InvalidKeyException
     */
    public byte[] decode(byte[] content) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        byte[] kbytes = Type_conversioned(this.keyy);
        return decodem(content, kbytes);

    }
}