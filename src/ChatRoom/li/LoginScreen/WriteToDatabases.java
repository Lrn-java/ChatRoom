package ChatRoom.li.LoginScreen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;


/**
 * 这个接口是用于数据写入数据库，不同的用法将不同的写入
 *
 * @author Lrn
 */
public interface WriteToDatabases {

    /*String mysql_user = "root";
    String mysql_password = "";
    String databasesURL = "jdbc:mysql://*:3306/user_info";*/

    default void getMassage(String iD, String usermessage, String password1){
        //写入到user_message数据库中，这个数据库中有一个表，用来保存用户名和密码这些基本信息
        /*try {

            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");



            //创建连接
            Connection connection = DriverManager.getConnection(databasesURL,mysql_user,mysql_password);
            //数据库的连接
            String insert = "INSERT INTO `users` (ID, username,password) VALUES (?, ?, ?)";;
            PreparedStatement ps = connection.prepareStatement(insert);
            ps.setString(1, iD);
            ps.setString(2, usermessage);
            ps.setString(3, password1);
            int a = ps.executeUpdate();

            //抛出异常
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }*/
    }

    //随机生成ID
    default int random_ID(){
        Random random = new Random();
        return 100000 + random.nextInt(900000);
    }


    //获取IP
    /*default void getIP(String ID,String IP){
        try {

            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            //创建连接
            Connection connection = DriverManager.getConnection(databasesURL,mysql_user,mysql_password);
            //数据库的连接
            String insert = "INSERT INTO `message` (user, u_password) VALUES (?, ?)";;
            PreparedStatement ps = connection.prepareStatement(insert);
            ps.setString(1, ID);
            ps.setString(2, IP);
            int rowsInserted = ps.executeUpdate();

            //抛出异常
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }*/
}