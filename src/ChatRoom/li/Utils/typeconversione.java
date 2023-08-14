package ChatRoom.li.Utils;


public  class typeconversione {
    public static byte[] tyconversione(String ... code){
        //传进来会是个string的arrlist
        byte[] bytes = new byte[0];
        for (String s : code) {
            bytes = s.getBytes();

        }
        return bytes;
    }
}
