package ChatRoom.li.LoginScreen;

import javax.swing.*;
import java.awt.*;


/**
 * 这个类的作用创建登录界面的属性
 * @author Lrn
 */
public class LoginScreen extends JFrame {
    /**
     * 我们需要对不同设备的屏幕尺寸大小来定义登录界面的坐标，因此有以下成员变量
     * wide：窗口宽度
     * high：窗口高度
     * Dimension：获取屏幕像素
     * getScreenWide：获取屏幕宽度
     * getScreenHigh：获取屏幕高度
     */
    private final int wide = 695;
    private final int high = 530;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private final int getScreenWide = screenSize.width;
    private final int getScreenHigh = screenSize.height;


    public LoginScreen(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(wide,high);
        setLocation(getsX(),getsY());

        setVisible(true);
    }

    /**
     * 计算窗口水平位置
     *
     * @return 窗口水平位置
     */
    private int getsX(){
        //通过屏幕宽度减去窗口宽度并除以2，得到水平位置
        return (this.getScreenWide - wide ) / 2;
    }

    /**
     * 计算窗口垂直位置
     *
     * @return 窗口垂直位置
     */
    private int getsY(){
        //通过屏幕高度减去窗口高度并除以2，得到垂直位置
        return (this.getScreenHigh - high) / 2;
    }

}
