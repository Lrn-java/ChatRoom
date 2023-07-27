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
                "的", "一", "是", "了", "我", "你", "他", "她", "它", "们", "在", "和", "有", "人", "这", "中", "大",
                "为", "上", "个", "国", "不", "地", "到", "以", "说", "时", "要", "就", "出", "会", "可", "也", "得",
                "能", "还", "下", "过", "子", "对", "自", "年", "前", "能", "后", "就", "到", "等", "与", "面", "着"
        };
        Random random = new Random();
        int index = random.nextInt(chineseChars.length);
        return chineseChars[index];
    }

    /**
     * 设置用户名框，并随机生成一个数组
     */
    public void setTextField(){
        int count = 5;
        //将随机生成的五个汉字依次添加到user中
        StringBuilder user = new StringBuilder();
        for (int i = 0; i < count; i++) {
            user.append(generateSimpleChineseChar());
        }
        //默认显示随机生成的用户名
        jTextField.setText(String.valueOf(user));
        jTextField.setBounds(130,50,150,28);
        container.add(jTextField);
    }


}