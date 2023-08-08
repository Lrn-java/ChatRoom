package ChatRoom.li.LoginScreen;

import javax.swing.*;

/**
 * 这个类是一个信息处理异常
 * @author Lrn
 */
public class InformationException extends Exception{

    private final String user;
    public  InformationException(String user){
        super(user);
        this.user = user;
    }
    /**
     * 捕获异常时，弹出对话框
     */
    @Override
    public void printStackTrace() {
        super.printStackTrace();
        JOptionPane.showMessageDialog(null,user,"登录失败!",JOptionPane.ERROR_MESSAGE);
    }

}
