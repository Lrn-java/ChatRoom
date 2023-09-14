package ChatRoom.li.MainInterface;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 创建界面类，这个界面是主界面的布局标签
 * @author Lrn
 */
public class Interface extends JFrame {

    protected int wide = 910;
    protected int high = 640;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    protected final int getScreenWide = screenSize.width;
    protected final int getScreenHigh = screenSize.height;

    private final Container container = getContentPane();
    private final JPanel PersonalInformationPanel = new JPanel();
    private final JPanel ContactPanel = new JPanel();
    private final JPanel ChatPanel = new JPanel();
    private final JPanel SearchPanel = new JPanel();
    public Interface(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(wide, high);
        setLocation(getsX(), getsY());
        setIconImage(null);
        setBackground(new Color(0xFFFFFF));

        setLayout(new LayoutManager() {

            @Override
            public void addLayoutComponent(String name, Component comp) {

            }

            @Override
            public void removeLayoutComponent(Component comp) {

            }

            @Override
            public Dimension preferredLayoutSize(Container parent) {
                // 指定首选尺寸的逻辑
                // 根据组件内容或布局要求计算首选宽度和高度，并返回一个 Dimension 对象
                int preferredWidth = 700;
                int preferredHeight = 500;
                return new Dimension(preferredWidth, preferredHeight);
            }

            @Override
            public Dimension minimumLayoutSize(Container parent) {
                // 指定最小尺寸的逻辑
                // 根据组件内容或布局要求计算最小宽度和高度，并返回一个 Dimension 对象
                int minimumWidth = 700;
                int minimumHeight = 500;
                return new Dimension(minimumWidth, minimumHeight);
            }

            @Override
            public void layoutContainer(Container parent) {
                PersonalInformationPanel.setBounds(0, 0, 55, parent.getHeight());
                SearchPanel.setBounds(55,0,250,50);
                ContactPanel.setBounds(55, 0, 250, parent.getHeight());
                ChatPanel.setBounds(60,0,parent.getWidth(), parent.getHeight());
            }
        });

        Color color = new Color(0,0,0,40);
        Border black = new MatteBorder(0,0,0,1,color);

        /*
         * 个人信息面板
         */
        PersonalInformationPanel.setBackground(new Color(0x2E2E2E));
        /*
         * 搜索面板
         */
        SearchPanel.setBackground(new Color(0xF7F7F7));
        SearchPanel.setBorder(black);
        /*
         * 联系人面板
         */
        ContactPanel.setBackground(new Color(0xEBE8E7));
        ContactPanel.setBorder(black);
        /*
         * 聊天面板
         */
        ChatPanel.setBackground(new Color(0xF5F5F5));

        add(PersonalInformationPanel);
        add(SearchPanel);
        add(ContactPanel);
        add(ChatPanel);

        setSearchBox();
        setMinimumSize(new Dimension(796,503));
        setVisible(true);
    }

    /**
     * 计算窗口水平位置
     *
     * @return 窗口水平位置
     */
    protected int getsX() {
        //通过屏幕宽度减去窗口宽度并除以2，得到水平位置
        return (this.getScreenWide - wide) / 2;
    }

    /**
     * 计算窗口垂直位置
     *
     * @return 窗口垂直位置
     */
    protected int getsY() {
        //通过屏幕高度减去窗口高度并除以2，得到垂直位置
        return (this.getScreenHigh - high) / 2;
    }

    JTextField searchBox = new JTextField("🔍搜索");

    /**
     * 设置搜索框
     */
    private void setSearchBox(){
        searchBox.setBounds(10,10,60,30);
        searchBox.setLayout(null);
        searchBox.setBackground(new Color(0xF5F5F5F5, true));

        searchBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                searchBox.setBackground(new Color(0xFFFFFF));
                super.mouseClicked(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if(searchBox.getText().equals("🔍搜索")){

                }else{
                    searchBox.setBackground(new Color(0xFFFFFF));
                    try {
                        Thread.sleep(200);
                        searchBox.setText("🔍搜索");
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                super.mouseExited(e);
            }

        });
        SearchPanel.add(searchBox);
    }
}