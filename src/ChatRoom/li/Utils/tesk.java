package ChatRoom.li.Utils;

import java.security.GeneralSecurityException;
import java.util.Arrays;

public class tesk {
    public static void main(String[] args) throws GeneralSecurityException {
        String s = "sdl";
        byte[] tyconversione = typeconversione.tyconversione(s);
        System.out.println(Arrays.toString(tyconversione));

        byte[] sdls = new EnAndDecode().encode(s);
        System.out.println(Arrays.toString(sdls));
        byte[] decode = new EnAndDecode().decode(sdls);
        System.out.println(Arrays.toString(decode));


    }
}
