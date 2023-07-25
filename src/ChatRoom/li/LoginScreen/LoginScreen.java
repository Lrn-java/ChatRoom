package ChatRoom.li.LoginScreen;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

/**
 * 这个类是定义登录界面属性
 * 创建时间：2023/7/25 17:30
 * @author Lrn
 */
public class LoginScreen extends JFrame {
    /**
     * 我们需要对不同设备的屏幕尺寸来定义登录界面的坐标，因此有以下重要成员变量
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

    /**
     * 登录界面属性
     */
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

        //添加组件
        setButton();
        setTextField();

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

    /**
     * 设置文本框属性
     */
    private void setTextField(){
        //设置下边框可见
        Border border = BorderFactory.createMatteBorder(0,0,1,0,Color.BLACK);

        jTextField.setText("QQ账号/游客账号");
        jTextField.setFont(new Font("微软雅黑",Font.PLAIN,15));
        jTextField.setBounds(440,250,200,30);
        jTextField.setBorder(border);

        jPasswordField.setFont(new Font("微软雅黑",Font.PLAIN,15));
        jPasswordField.setBounds(440,300,200,30);
        jPasswordField.setBorder(border);

        jTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jTextField.setText("");
                super.mouseClicked(e);
            }

            @Override
            public void mouseExited(MouseEvent e){
                if(jTextField.getText().equals("")){
                    jTextField.setText("QQ账号/游客账号");
                }

                super.mouseExited(e);
            }

        });

        //添加组件
        container.add(jTextField);
        container.add(jPasswordField);
    }

    /**
     * 设置按钮属性
     */
    private void setButton(){
        VisitorLogin.setText("游客登录");
        VisitorLogin.setBounds(553,340,85,30);
        VisitorLogin.setBackground(new Color(0x328FFA));
        VisitorLogin.setForeground(new Color(0xFFFFFF));

        QQ_Login.setText("登 录");
        QQ_Login.setBounds(440,340,85,30);
        QQ_Login.setBackground(new Color(0x328FFA));
        QQ_Login.setForeground(new Color(0xFFFFFF));

        VisitorLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                VisitorLogin.setText("");
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                VisitorLogin.setText("游客登录");
                super.mouseExited(e);
            }
        });

        //添加按钮
        container.add(VisitorLogin);
        container.add(QQ_Login);
    }

}