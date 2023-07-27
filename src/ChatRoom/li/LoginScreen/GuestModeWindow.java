package ChatRoom.li.LoginScreen;

import javax.swing.*;
import javax.swing.border.Border;
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
    JLabel welcome = new JLabel("欢迎注册ChatRoom");
    JLabel title = new JLabel("每一天,乐在沟通");
    JLabel userName = new JLabel("用户名");
    JLabel passwordOne = new JLabel("密 码:");
    JLabel passwordTwo = new JLabel("密 码:");

    JButton enroll = new JButton("立即注册");


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


        //添加注册界面标签
        welcome.setBounds(100,20,200,40);
        welcome.setFont(new Font("黑体",Font.BOLD,22));
        container.add(welcome);

        title.setBounds(100,52,130,30);
        title.setFont(new Font("黑体",Font.PLAIN,15));
        container.add(title);

        //添加登录界面背景
        ImageIcon imageIcon = new ImageIcon("src\\ChatRoom\\li\\Material\\注册背景.png");
        JLabel jLabel = new JLabel(imageIcon);
        jLabel.setBounds(0,0,wide,high);
        Integer minValue = Integer.MIN_VALUE;
        jFrame.getLayeredPane().add(jLabel,minValue);
        JPanel jPanel = (JPanel) jFrame.getContentPane();

        setTextField();

        jFrame.setResizable(false);
        jPanel.setOpaque(false);
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
     * 通过固定汉字，这个方法被调用后，会随机进行排列组合一个用户名
     * @return 随机生成用户名
     */
    private static String generateSimpleChineseChar(){
        String[] chineseChars = {
                "的", "一", "是", "了", "我", "你", "他", "她", "它", "们", "在", "和", "有", "人", "这", "中", "大",
                "为", "上", "个", "国", "不", "地", "到", "以", "说", "时", "要", "就", "出", "会", "可", "也", "得",
                "能", "还", "下", "过", "子", "对", "自", "年", "前", "能", "后", "就", "到", "等", "与", "面", "着",
                "&","*","#","@","<",">","/","^","%","-","}","{","[","]","s","a","P"
        };
        int index = new Random().nextInt(chineseChars.length);
        return chineseChars[index];
    }

    /**
     * 设置注册用户名框
     */
    public void setTextField(){
        Border border = BorderFactory.createMatteBorder(0,0,1,0,Color.BLACK);
        int count = 5;
        //随机生成一个用户名并追加到user中
        StringBuilder user = new StringBuilder();
        for (int i = 0; i < count; i++) {
            user.append(generateSimpleChineseChar());
        }

        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new FlowLayout());
        panel.add(jTextField);

        //默认显示随机生成的用户名
        jTextField.setText(String.valueOf(user));
        jTextField.setBounds(100,100,180,28);
        jTextField.setBorder(border);

        userName.setBounds(100,75,60,30);
        passwordOne.setBounds(100,130,50,30);
        passwordTwo.setBounds(100,190,50,30);

        jPasswordFieldOne.setBounds(100,160,180,28);
        jPasswordFieldOne.setBorder(border);

        jPasswordFieldTwo.setBounds(100,220,180,28);
        jPasswordFieldTwo.setBorder(border);

        enroll.setBounds(100,260,180,40);
        enroll.setBackground(new Color(0x0085FF));
        enroll.setForeground(new Color(0xFFFFFF));

        //添加组件
        container.add(userName);
        container.add(passwordOne);
        container.add(passwordTwo);

        container.add(jTextField);
        container.add(jPasswordFieldOne);
        container.add(jPasswordFieldTwo);
        container.add(enroll);
    }


}