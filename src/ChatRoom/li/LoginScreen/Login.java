package ChatRoom.li.LoginScreen;

import ChatRoom.li.GetMessage.WriteToDatabases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 这个接口用于判断数据库中用户名和密码
 * 创建时间：2023/8/2 14:00
 * @author Lrn
 */
public interface Login  {

    String MYSQL_USER = "root";
    String MYSQL_PASSWORD = "";
    String MYSQL_URL = "jdbc:mysql://:3306/user_info";

    /**
     * 这个方法是用于连接数据库
     */
    default void connectDatabase(){
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(MYSQL_URL, MYSQL_USER, MYSQL_PASSWORD);
            //数据库的连接
            String insert = "INSERT INTO `users` (ID, username,password) VALUES (?, ?, ?)";
            String select = "SELECT ID,IP FROM 'users' ";
            String sql = "SELECT COUNT(*) FROM ip_addresses WHERE ID = ?";



        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 这个方法用于获取数据库中的用户名和密码
     * @param user 用户名
     * @param password 密码
     */
    default void getDatabaseMessage(String user,String password){

    }

}
