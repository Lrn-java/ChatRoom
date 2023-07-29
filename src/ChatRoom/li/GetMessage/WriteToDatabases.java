package ChatRoom.li.GetMessage;

import java.sql.*;
import java.util.Random;

import static java.lang.System.out;


/**
 * 这个接口是用于数据写入数据库，不同的用法将不同的写入
 *
 * @author Lrn
 */
public interface WriteToDatabases {

    String mysql_user = "root";
    String mysql_password = "758206lrnandlxnA";
    String databasesURL = "jdbc:mysql://192.168.1.7:3306/user_info";

    default void getMassage(String iD, String usermessage, String password1) {
        //写入到user_message数据库中，这个数据库中有一个表，用来保存用户名和密码这些基本信息
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(databasesURL, mysql_user, mysql_password);
            //数据库的连接
            String insert = "INSERT INTO `users` (ID, username,password) VALUES (?, ?, ?)";
            ;
            PreparedStatement ps = connection.prepareStatement(insert);
            ps.setString(1, iD);
            ps.setString(2, usermessage);
            ps.setString(3, password1);
            int a = ps.executeUpdate();


        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }


    }

    /**
     * 生成一个6位的随机数，用于绑定ID
     *
     * @return 随机生成6位数
     */
    default int random_ID() {
        return 100000 + new Random().nextInt(900000);
    }


    /***
     * 获取IP并写入到数据库
     * @param ID 用户ID号
     * @param IP 用户ID地址
     */
    default void getIP(String ID, String IP) {
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            //创建连接
            Connection connection = DriverManager.getConnection(databasesURL, mysql_user, mysql_password);

            //数据库的连接
            String insert = "INSERT INTO `ip_addresses` (ID, ip_address) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(insert);
            ps.setString(1, ID);
            ps.setString(2, IP);

            ps.executeUpdate(); // execute the query and write to the database

            //关闭连接
            ps.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    String value = null;
    /**
     * 调用这个方法后就可以进行查询是否有重复ID
     * @param ID 这个ID是
     * @param IP
     */
    default void duplicateID(String ID, String IP) {
        try (Connection connection = DriverManager.getConnection(databasesURL, mysql_user, mysql_password)) {
            String sql = "SELECT COUNT(*) FROM ip_addresses WHERE ID = ?";
            String insertSql = "INSERT INTO ip_addresses (ID, ip_address) VALUES (?, ?)";

            boolean isDuplicate = true;

            do {
                int valueToCheck = random_ID();

                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setInt(1, valueToCheck);
                    ResultSet resultSet = statement.executeQuery();

                    if (resultSet.next()) {
                        int count = resultSet.getInt(1);
                        if (count > 0) {
                            out.println("有");
                            // 数据库中已存在与生成的ID相同的记录，重新生成一个新的ID
                        } else {
                            // 数据库中不存在与生成的ID相同的记录，结束循环，将ID和IP写入数据库
                            isDuplicate = false;
                            try (PreparedStatement insertStatement = connection.prepareStatement(insertSql)) {
                                insertStatement.setInt(1, valueToCheck);
                                insertStatement.setString(2, IP);
                                insertStatement.executeUpdate();
                            }
                        }
                    }

                    resultSet.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            } while (isDuplicate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}