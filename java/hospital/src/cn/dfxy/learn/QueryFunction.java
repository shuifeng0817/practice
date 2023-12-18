package cn.dfxy.learn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;

public class QueryFunction {
    public void function(){
        JFrame frame = new JFrame("查询功能");
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 6, 6);
        frame.setLayout(flowLayout);
        // 当按钮被点击时执行的代码
        Connection connection = JdbcUtils.getConnection();
        PreparedStatement pstmt = null;
        try {
            String sql = "SELECT DISTINCT name FROM consultationinformation";
            pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name"); // 获取department列的值
                JButton button = new JButton(name); // 为每个部门创建一个按钮
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // 按钮点击事件处理
                        System.out.println("Button clicked: " + name);
                        JFrame frame = new JFrame("查询功能");
                        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 6, 6);
                        frame.setLayout(flowLayout);
                        Connection connection = JdbcUtils.getConnection();
                        try {
                            Statement statement = connection.createStatement();
                            String query = "SELECT * FROM consultationinformation WHERE name = '" + name + "'";
                            ResultSet resultSet = statement.executeQuery(query);
                            JTable table = new JTable(ResultSetUtils.buildTableModel(resultSet));
                            JScrollPane scrollPane = new JScrollPane(table);
                            // 设置首选宽度和高度
                            int preferredWidth = 1200; // 宽度，按照你的需求设定
                            int preferredHeight = 600; // 高度，按照你的需求设定
                            Dimension preferredSize = new Dimension(preferredWidth, preferredHeight);// 应用首选大小
                            scrollPane.setPreferredSize(preferredSize);
                            frame.add(scrollPane);
                        } catch (SQLException e2) {
                            throw new RuntimeException(e2);
                        }
                        JFrameUtils.initFrame(frame, 1300, 600);
                        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置窗口属性，关闭时程序不退出
                        frame.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosed(WindowEvent e) {
                                JOptionPane.showMessageDialog(frame, "查询功能关闭");//关闭时进行提示
                            }
                        });
                    }
                });
                frame.add(button); // 将按钮添加到面板
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        } finally {
            JdbcUtils.close(null, null, connection);
        }
        JFrameUtils.initFrame(frame, 700, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置窗口属性，关闭时程序不退出
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                JOptionPane.showMessageDialog(frame, "查询功能关闭");//关闭时进行提示
            }
        });

    }
}
