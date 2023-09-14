package ChatRoom.li.GetMessage;


import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Lrn
 */
public interface SelectDatabase extends GetIP{

    String mysql_user = "root";
    String mysql_password = "hello";

    String databasesURL = "jdbc:mysql://:3306/user_info";

    /**
     * 查询数据库中的数据
     */
    default boolean checkCredentials(String username, String password) {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(databasesURL, mysql_user, mysql_password);

            String query = "SELECT ID, password FROM users WHERE ID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            // 用户存在且密码匹配
            if (resultSet.next()) {
                String dbPassword = resultSet.getString("password");
                if (dbPassword.equals(password)) {
                    System.out.println("用户名和密码匹配");
                    return true;
                }
            }
            // 用户不存在或密码不匹配
            JOptionPane.showMessageDialog(null, "账号密码不正确，请检查后输入");
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }
}