package ChatRoom.li.Run;

import ChatRoom.li.GetMessage.GetIP;
import ChatRoom.li.GetMessage.WriteToDatabases;
import ChatRoom.li.LoginScreen.GuestModeWindow;
import ChatRoom.li.LoginScreen.LoginScreen;
/**
 * 运行类，用来运行程序的
 * @author Lrn
 */
public class Run implements GetIP , WriteToDatabases {

    public static void main(String[] args){
        new LoginScreen();
        //new Run().get("123","192.168");
    }

}