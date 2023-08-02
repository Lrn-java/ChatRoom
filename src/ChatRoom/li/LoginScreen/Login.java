package ChatRoom.li.LoginScreen;

/**
 * 这个接口用于判断数据库中用户名和密码
 * 创建时间：2023/8/2 14:00
 * @author Lrn
 */
public interface Login {

    String USER = "root";
    String PASSWORD = "";
    String URL = "";

    /**
     * 这个方法是用于连接数据库
     */
    default void connectDatabase(){

    }


    /**
     * 这个方法用于获取数据库中的用户名和密码
     * @param user 用户名
     * @param password 密码
     */
    default void getDatabaseMessage(String user,String password){

    }
}
