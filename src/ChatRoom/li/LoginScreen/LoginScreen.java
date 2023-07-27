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
    protected   int wide = 695;
    protected   int high = 530;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    protected final int getScreenWide = screenSize.width;
    protected final int getScreenHigh = screenSize.height;
    private final JTextField jTextField = new JTextField();
    private final JPasswordField jPasswordField = new JPasswordField();
    private final Container container = getContentPane();
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
        ImageIcon imageIcon = new ImageIcon("src\\ChatRoom\\li\\Material\\登录界面素材.png");
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
    protected int getsX(){
        //通过屏幕宽度减去窗口宽度并除以2，得到水平位置
        return (this.getScreenWide - wide ) / 2;
    }

    /**
     * 计算窗口垂直位置
     *
     * @return 窗口垂直位置
     */
    protected int getsY(){
        //通过屏幕高度减去窗口高度并除以2，得到垂直位置
        return (this.getScreenHigh - high) / 2;
    }

    /**
     * 设置文本框属性
     */
    protected void setTextField(){
        //设置下边框可见
        Border border = BorderFactory.createMatteBorder(0,0,1,0,Color.BLACK);
        final String text = "        QQ账号/游客账号";

        jTextField.setText(text);
        jTextField.setFont(new Font("微软雅黑",Font.PLAIN,15));
        jTextField.setBounds(440,250,200,30);
        jTextField.setOpaque(false);
        jTextField.setForeground(new Color(0,0,0,128));
        jTextField.setBorder(border);

        jPasswordField.setFont(new Font("微软雅黑",Font.PLAIN,15));
        jPasswordField.setBounds(440,300,200,30);
        jPasswordField.setBorder(border);

        //添加鼠标监听效果
        jTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jTextField.setText("");
                super.mouseClicked(e);
            }

            @Override
            public void mouseExited(MouseEvent e){
                if(jTextField.getText().equals("")){
                    jTextField.setText(text);
                    jTextField.setOpaque(false);
                    jTextField.setForeground(new Color(0,0,0,128));
                }
                super.mouseExited(e);
            }

        });

        jTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(!jTextField.getText().equals(text)){
                    jTextField.setOpaque(false);
                    jTextField.setForeground(new Color(0x000000));
                }
                jTextField.setOpaque(false);
                jTextField.setForeground(new Color(0,0,0,128));

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(!jTextField.getText().equals(text)){
                    jTextField.setOpaque(false);
                    jTextField.setForeground(new Color(0x000000));
                }
                jTextField.setOpaque(false);
                jTextField.setForeground(new Color(0,0,0,128));

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(jTextField.getText().equals(text)){
                    jTextField.setOpaque(false);
                    jTextField.setForeground(new Color(0,0,0,128));
                }
                jTextField.setOpaque(false);
                jTextField.setForeground(new Color(0x000000));
            }
        });
        //添加组件
        container.add(jTextField);
        container.add(jPasswordField);
    }

    /**
     * 设置按钮属性
     */
    protected void setButton(){
        VisitorLogin.setText("游客登录");
        VisitorLogin.setBounds(553,340,88,30);
        VisitorLogin.setBackground(new Color(0x328FFA));
        VisitorLogin.setForeground(new Color(0xFFFFFF));

        QQ_Login.setText("登 录");
        QQ_Login.setBounds(440,340,88,30);
        QQ_Login.setBackground(new Color(0x328FFA));
        QQ_Login.setForeground(new Color(0xFFFFFF));

        VisitorLogin.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                new GuestModeWindow();
                super.mouseClicked(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                VisitorLogin.setFont(new Font("微软雅黑",Font.PLAIN,13));
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                VisitorLogin.setFont(new Font("Dialog",Font.PLAIN,12));
                VisitorLogin.setText("游客登录");
                super.mouseExited(e);
            }
        });

        QQ_Login.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                QQ_Login.setFont(new Font("微软雅黑",Font.PLAIN,13));
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                QQ_Login.setFont(new Font("Dialog",Font.PLAIN,12));
                QQ_Login.setText("登 录");
                super.mouseExited(e);
            }
        });

        //添加按钮
        container.add(VisitorLogin);
        container.add(QQ_Login);
    }

}