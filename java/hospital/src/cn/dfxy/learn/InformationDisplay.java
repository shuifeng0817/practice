package cn.dfxy.learn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.ArrayList;

public class InformationDisplay {
    public void departmentClassification() {
        JFrame frame = new JFrame("全部信息展示");
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 6, 6);
        frame.setLayout(flowLayout);
        BtnListener2 btnListener2 = new BtnListener2();

        // 从MySQL中查询name字段信息
        ArrayList<String> departmentNames = new ArrayList<>();
        Connection connection = JdbcUtils.getConnection();
        String sql = "SELECT name FROM department";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                departmentNames.add(name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(null, null, connection);
        }

        // 创建按钮并设置文本
        for (String name : departmentNames) {
            JButton button = new JButton(name);
            frame.add(button);
            button.addActionListener(btnListener2);
        }



        JFrameUtils.initFrame(frame, 700, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置窗口属性，关闭时程序不退出
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                JOptionPane.showMessageDialog(frame, "全部信息展示关闭");//关闭时进行提示
            }
        });
    }

    public void departmentSeek(String name){
        JFrame frame = new JFrame("全部信息展示");
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 6, 6);
        frame.setLayout(flowLayout);
        Connection connection = JdbcUtils.getConnection();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM doctor WHERE departmentName = '" + name + "'";
            ResultSet resultSet = statement.executeQuery(query);
            JTable table = new JTable(ResultSetUtils.buildTableModel(resultSet));
            JScrollPane scrollPane = new JScrollPane(table);
            // 设置首选宽度和高度
            int preferredWidth = 500; // 宽度，按照你的需求设定
            int preferredHeight = 600; // 高度，按照你的需求设定
            Dimension preferredSize = new Dimension(preferredWidth, preferredHeight);// 应用首选大小
            scrollPane.setPreferredSize(preferredSize);
            frame.add(scrollPane);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        JFrameUtils.initFrame(frame, 600, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置窗口属性，关闭时程序不退出
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                JOptionPane.showMessageDialog(frame, "全部信息展示关闭");//关闭时进行提示
            }
        });

    }
}
