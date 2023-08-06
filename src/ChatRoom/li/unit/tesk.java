package ChatRoom.li.unit;

import sun.java2d.pipe.AAShapePipe;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;

public class tesk {
    public static void main(String[] args) {
//        new EdcryptionArrLoad().EdcryptionArrLoad("ss","ll");
        try {
            byte[] encode = new EnAndDecode().encode("hahah");
            System.out.println("加密："+Arrays.toString(encode));
            String s = new String(encode);
            System.out.println(s);
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }


    }
}
