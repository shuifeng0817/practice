package cn.dfxy.training;

import javax.swing.*;
import java.awt.*;

public class JFrameUtils {
    public static void main(String[] args) {
        JFrame frame = new JFrame("这个是我第一个图形化界面的例子");
        initFrame(frame, 300, 300);
    }

    //获取屏幕的分辨率 设置窗体在屏幕的居中位置。
    public static void initFrame(JFrame frame, int width, int height) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        //获取一个与系统相关工具类对
        //获取屏幕的分辨率
        Dimension d = toolkit.getScreenSize();
        int x = (int) d.getWidth();
        int y = (int) d.getHeight();
        frame.setBounds((x - width) / 2, (y - height) / 2
                , width, height);
        //setVisible 设置窗体的可见性。
        frame.setVisible(true);
        //设置窗体关闭事件
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
