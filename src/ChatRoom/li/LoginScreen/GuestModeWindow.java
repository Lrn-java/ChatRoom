package ChatRoom.li.LoginScreen;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * @author Lrn
 */
public class GuestModeWindow {

    /**
     * high：窗口高度
     * Dimension：获取屏幕像素
     * getScreenWide：获取屏幕宽度
     * getScreenHigh：获取屏幕高度
     */

    private final int wide = 400;
    private final int high = 400;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    protected final int getScreenWide = screenSize.width;
    protected final int getScreenHigh = screenSize.height;

    /**
     * 窗口及窗口组件
     */
    JFrame jFrame = new JFrame("游客登陆");
    Container container = jFrame.getContentPane();
    JTextField jTextField = new JTextField();
    JPasswordField jPasswordFieldOne = new JPasswordField();
    JPasswordField jPasswordFieldTwo = new JPasswordField();
    JLabel userLabel = new JLabel("请输入用户名:");
    JLabel passWorldLabelOne = new JLabel("请输入第一次密码:");
    JLabel passworldLabelTwo = new JLabel("请输入第二次密码:");

    /**
     * 窗口之间的阻塞
     */
    Object lock = new Object();

    /**
     * 游客模式注册窗口
     */
    public GuestModeWindow(){
        jFrame.setSize(wide,high);
        jFrame.setLocation(setX(),setY());
        jFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        jFrame.setBackground(new Color(0xFFFFFF));
        jFrame.setLayout(null);

        setTextField();
        //窗口可见性
        jFrame.setVisible(true);
    }

    /**
     * 计算水平窗口位置
     *
     * @return 水平位置
     */
    public int setX(){
        return (this.getScreenWide - wide ) / 2;
    }

    /**
     * 计算垂直位置
     *
     * @return 垂直位置
     */
    public int setY(){
        return (this.getScreenHigh - high ) / 2;
    }

    /**
     * 通过固定汉字，随机生成一个用户名
     * @return 随机生成用户名
     */
    private static String generateSimpleChineseChar(){
        String[] chineseChars = {
                "一", "二", "三", "四", "五", "六", "七", "八", "九", "十",
                "百", "千", "万", "人", "天", "山", "水", "火", "木", "金"
        };
        Random random = new Random();
        int index = random.nextInt(chineseChars.length);
        return chineseChars[index];
    }

    /**
     * 设置用户名文本框
     */
    public void setTextField(){
        int count = 5;
        //将随机生成的五个汉字依次添加到add中
        StringBuilder user = new StringBuilder();
        for (int i = 0; i < count; i++) {
            user.append(generateSimpleChineseChar());
        }
        //默认显示随机生成的用户名
        jTextField.setText(String.valueOf(user));
        jTextField.setBounds(140,50,150,25);
        container.add(jTextField);
    }


}