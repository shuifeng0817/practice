package cn.dfxy.learn;

import javax.swing.*;
import java.awt.*;

public class MainInterface {

    public void start () {
        JFrame frame = new JFrame("医院挂号");
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER,6,6);
        frame.setLayout(flowLayout);
        JPanel jPanel = new JPanel();
        jPanel.setPreferredSize(new Dimension(200, 200));
        JPanel jPane2 = new JPanel();
        jPanel.setLayout(flowLayout);
        jPane2.setLayout(flowLayout);
        BtnListener btnListener = new BtnListener();


        JLabel jLabel = new JLabel("医院挂号系统");
        Font currentFont = jLabel.getFont();// 获取当前标签的字体
        Font newFont = new Font(currentFont.getFontName(), Font.PLAIN, 30);// 创建新的字体，设置字体大小为30
        jLabel.setFont(newFont);// 设置标签的字体为新的字体
        JButton departmentSet = new JButton("科室管理");
        JButton doctorSet = new JButton("医生管理");
        JButton consultationSet = new JButton("坐诊信息设置");
        JButton informationDisplay = new JButton("全部信息展示");
        JButton appointmentFunction = new JButton("预约功能");
        JButton searchFunction = new JButton("搜索功能");
        JButton queryFunction = new JButton("查询功能");
        jPanel.add(jLabel);
        jPane2.add(departmentSet);
        jPane2.add(doctorSet);
        jPane2.add(consultationSet);
        jPane2.add(informationDisplay);
        jPane2.add(appointmentFunction);
        jPane2.add(searchFunction);
        jPane2.add(queryFunction);
        frame.add(jPanel);
        frame.add(jPane2);
        departmentSet.addActionListener(btnListener);
        doctorSet.addActionListener(btnListener);
        consultationSet.addActionListener(btnListener);
        informationDisplay.addActionListener(btnListener);
        appointmentFunction.addActionListener(btnListener);
        searchFunction.addActionListener(btnListener);
        queryFunction.addActionListener(btnListener);
        JFrameUtils.initFrame(frame, 700, 600);
    }

}
