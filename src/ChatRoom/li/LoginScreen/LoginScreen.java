package ChatRoom.li.LoginScreen;

import javax.swing.*;
import javax.swing.border.Border;
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


    private final JTextField jTextField = new JTextField();
    private final JPasswordField jPasswordField = new JPasswordField();
    private final Container container = getContentPane();

    private final ImageIcon imageIcon = new ImageIcon("D:\\IDEA-Work\\ChatRoom\\src\\ChatRoom\\li\\Material\\登录界面素材.png");
    private final JButton VisitorLogin = new JButton();
    private final JButton QQ_Login = new JButton();


    public LoginScreen(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(wide,high);
        setLocation(getsX(),getsY());
        setIconImage(null);
        setBackground(new Color(0xFFFFFF));

        setLayout(null);

        //添加登录界面背景
        JLabel jLabel = new JLabel(imageIcon);
        jLabel.setBounds(0,0,400,530);
        Integer minValue = Integer.MIN_VALUE;
        getLayeredPane().add(jLabel,minValue);
        JPanel jPanel = (JPanel) getContentPane();

        Border border = BorderFactory.createMatteBorder(0,0,1,0,Color.BLACK);

        jTextField.setText("QQ账号/游客账号");
        jTextField.setBounds(440,250,200,30);
        jTextField.setBorder(border);

        jPasswordField.setText("密码");
        jPasswordField.setBounds(440,300,200,30);
        jPasswordField.setBorder(border);

        VisitorLogin.setText("游客登录");
        VisitorLogin.setBounds(553,340,85,30);

        QQ_Login.setText("登 录");
        QQ_Login.setBounds(440,340,85,30);


        //添加组件
        container.add(jTextField);
        container.add(jPasswordField);
        //添加按钮
        container.add(VisitorLogin);
        container.add(QQ_Login);

        setResizable(false);
        jPanel.setOpaque(false);
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