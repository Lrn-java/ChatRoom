package ChatRoom.li.LoginScreen;

import javax.swing.*;

/**
 * 这个类注册失败后抛出的异常行为
 * @author Lrn
 */
public class UserNameMessageException extends Exception{

    private final String user;
    public  UserNameMessageException(String user){
        super(user);
        this.user = user;
    }


    /**
     * 捕获异常时，弹出对话框
     */
    @Override
    public void printStackTrace() {
        super.printStackTrace();
        JOptionPane.showMessageDialog(null,user,"注册失败!",JOptionPane.ERROR_MESSAGE);
    }
}
