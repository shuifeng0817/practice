package cn.dfxy.learn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class SearchFunction {
    private Map<JButton, String> btnMap = new HashMap<>();

    public void search() {
        JFrame frame = new JFrame("搜索功能");
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 6, 6);
        frame.setLayout(flowLayout);
        // 创建一个按钮数组，对应当天到第六天
        String[] days = new String[]{"当天", "第一天", "第二天", "第三天", "第四天", "第五天", "第六天"};
        String[] dayIdentifiers = new String[]{"day0", "day1", "day2", "day3", "day4", "day5", "day6"};
        for (int i = 0; i < days.length; i++) {
            JButton button = new JButton(days[i] );
            String identifier = dayIdentifiers[i] + "AM"; // 例如 "day0AM" 对“当天上午”
            btnMap.put(button, identifier);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame frame = new JFrame("搜索功能");
                    FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 6, 6);
                    frame.setLayout(flowLayout);
                    // 当按钮被点击时执行的代码
                    String time = btnMap.get(button);
                    Connection connection = JdbcUtils.getConnection();
                    PreparedStatement pstmt = null;
                    try {
                        String sql = "SELECT DISTINCT department FROM consultationinformation";
                        pstmt = connection.prepareStatement(sql);
                        ResultSet rs = pstmt.executeQuery();

                        while (rs.next()) {
                            String departmentName = rs.getString("department"); // 获取department列的值
                            JButton button = new JButton(departmentName); // 为每个部门创建一个按钮
                            button.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    // 按钮点击事件处理
                                    System.out.println("Button clicked: " + departmentName);
                                    JFrame frame = new JFrame("全部信息展示");
                                    FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 6, 6);
                                    frame.setLayout(flowLayout);
                                    Connection connection = JdbcUtils.getConnection();
                                    try {
                                        Statement statement = connection.createStatement();
                                        String query = "SELECT * FROM consultationinformation WHERE department = '" + departmentName + "'";
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
                                            JOptionPane.showMessageDialog(frame, "全部信息展示关闭");//关闭时进行提示
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
                            JOptionPane.showMessageDialog(frame, "预约功能关闭");//关闭时进行提示
                        }
                    });
                }
            });
            frame.add(button);
/*            JButton buttonPM = new JButton(days[i] + "下午");
            identifier = dayIdentifiers[i] + "PM"; // 例如 "day0PM" 对“当天下午”
            btnMap.put(buttonPM, identifier);

            buttonPM.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    JFrame frame = new JFrame("搜索功能");
                    FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 6, 6);
                    frame.setLayout(flowLayout);
                    // 当按钮被点击时执行的代码
                    String time = btnMap.get(buttonPM);
                    Connection connection = JdbcUtils.getConnection();
                    // 注意，这里不再使用?占位符来代替列名，而是直接拼接字符串
                    PreparedStatement pstmt = null;
                    try {
                        String sql = "SELECT DISTINCT department FROM consultationinformation"; // 替换your_table为你的表名
                        pstmt = connection.prepareStatement(sql);
                        ResultSet rs = pstmt.executeQuery();

                        while (rs.next()) {
                            String departmentName = rs.getString("department"); // 获取department列的值
                            JButton button = new JButton(departmentName); // 为每个部门创建一个按钮
                            button.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    // 按钮点击事件处理
                                    System.out.println("Button clicked: " + departmentName);
                                    JFrame frame = new JFrame("全部信息展示");
                                    FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 6, 6);
                                    frame.setLayout(flowLayout);
                                    Connection connection = JdbcUtils.getConnection();
                                    try {
                                        Statement statement = connection.createStatement();
                                        String query = "SELECT * FROM consultationinformation WHERE department = '" + departmentName + "'";
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
                                            JOptionPane.showMessageDialog(frame, "全部信息展示关闭");//关闭时进行提示
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
                            JOptionPane.showMessageDialog(frame, "预约功能关闭");//关闭时进行提示
                        }
                    });
                }
            });

            jPane2.add(buttonPM);*/
        }
        JFrameUtils.initFrame(frame, 700, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置窗口属性，关闭时程序不退出
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                JOptionPane.showMessageDialog(frame, "预约功能关闭");//关闭时进行提示
            }
        });

    }
}
