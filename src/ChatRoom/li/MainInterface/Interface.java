package ChatRoom.li.MainInterface;

import javax.swing.*;
import java.awt.*;

/**
 * 创建界面类，这个界面是主界面的布局标签
 * @author Lrn
 */
public class Interface extends JFrame {

    Container container = getContentPane();
    private Interface(){

    }

    /**
     * 把主界面返回出去
     * @return 返回主界面
     */
    public static Interface anInterface(){
        return new Interface();
    }
}
