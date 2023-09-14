package ChatRoom.li.Run;

import ChatRoom.li.GetMessage.GetIP;
import ChatRoom.li.GetMessage.WriteToDatabases;
import ChatRoom.li.LoginScreen.LoginScreen;
import com.mysql.cj.log.Log;

import java.net.SocketException;

/**
 * 运行类，用来运行程序的
 * @author Lrn
 */
public class Run implements GetIP , WriteToDatabases {

    public static void main(String[] args) throws SocketException {
        new LoginScreen();
    }
}