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

public class AppointmentFunction {
    private Map<JButton, String> btnMap = new HashMap<>();


    public void patientInformation() {
        BtnListener btnListener = new BtnListener();
        JFrame frame = new JFrame("预约功能");
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 6, 6);
        frame.setLayout(flowLayout);
        JPanel panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(700, 200));
        panel1.setLayout(flowLayout);
        JPanel panel2 = new JPanel();
        panel2.setLayout(flowLayout);
        // 创建一个水平分割的 JSplitPane
//        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panel1, panel2);
//        splitPane.setDividerLocation(150);
        JLabel name = new JLabel("患者名：");
        JLabel sex = new JLabel("性别：");
        JLabel age = new JLabel("年龄：");
        JTextField jTextFieldName = new JTextField(5);
        JTextField jTextFieldSex = new JTextField(5);
        JTextField jTextFieldAge = new JTextField(5);
        String doctorName = null;

        Connection connection = JdbcUtils.getConnection();
        try {
            String sql = "SELECT name FROM doctor";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            PatientBean patient = new PatientBean();


            while (rs.next()) {
                doctorName = rs.getString("name");
                JButton button = new JButton(doctorName);
                panel2.add(button);
                // 设置按钮的动作监听器（或者其他你需要的操作）
                String finalDoctorName = doctorName;
                button.addActionListener(e -> {
                    String t1 = jTextFieldName.getText();
                    String t2 = jTextFieldSex.getText();
                    int t3 = Integer.parseInt(jTextFieldAge.getText());
                    patient.setName(t1);
                    patient.setSex(t2);
                    patient.setAge(t3);
                    System.out.println("Clicked: " + finalDoctorName);
                    String insertSql = "INSERT INTO patient (name, sex, age) VALUES (?, ?, ?)";
                    Connection connection2 = JdbcUtils.getConnection();
                    PreparedStatement insertPstmt = null;
                    try {
                        insertPstmt = connection2.prepareStatement(insertSql);
                        insertPstmt.setString(1, patient.getName());
                        insertPstmt.setString(2, patient.getSex());
                        insertPstmt.setInt(3, patient.getAge());
                        insertPstmt.executeUpdate();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } finally {
                        JdbcUtils.close(null, insertPstmt, connection2);
                    }
                    AppointmentFunction appointmentFunction = new AppointmentFunction();
                    appointmentFunction.doctorTime(finalDoctorName);
                });


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(null, null, connection);
        }


        panel1.add(name);
        panel1.add(jTextFieldName);
        panel1.add(sex);
        panel1.add(jTextFieldSex);
        panel1.add(age);
        panel1.add(jTextFieldAge);
        frame.add(panel1);
        frame.add(panel2);
        // 添加 splitPane 到 frame
//        frame.add(splitPane);
        JFrameUtils.initFrame(frame, 700, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置窗口属性，关闭时程序不退出
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                JOptionPane.showMessageDialog(frame, "预约功能关闭");//关闭时进行提示
            }
        });
        frame.setVisible(true);
    }


    public  void doctorTime(String doctorName) {
        System.out.println(doctorName);
        JFrame frame = new JFrame("预约功能");
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 6, 6);
        frame.setLayout(flowLayout);
        // 创建一个按钮数组，对应当天到第六天
        String[] days = new String[]{"当天", "第一天", "第二天", "第三天", "第四天", "第五天", "第六天"};
        String[] dayIdentifiers = new String[]{"day0", "day1", "day2", "day3", "day4", "day5", "day6"};

        for (int i = 0; i < days.length; i++) {
            JButton button = new JButton(days[i]+"上午");
            String identifier = dayIdentifiers[i] + "AM"; // 例如 "day0AM" 对“当天上午”
            btnMap.put(button, identifier);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // 当按钮被点击时执行的代码
                    String time = btnMap.get(button);
                    Connection connection = JdbcUtils.getConnection();
                    // 注意，这里不再使用?占位符来代替列名，而是直接拼接字符串
                    String sql = "SELECT " + time + " FROM consultationinformation WHERE name = ?";
                    PreparedStatement pstmt = null;
                    try {
                        pstmt = connection.prepareStatement(sql);
                        pstmt.setString(1, doctorName);
                        ResultSet rs = pstmt.executeQuery();
                        if (rs.next()) {
                            // 假设我们查询的列是整数类型
                            int resultData = rs.getInt(time); // 这里应该使用 time 变量
                            if (resultData != 0) {
                                resultData -= 1;
                                // 更新的 SQL 也应该用相同的方式来构建，不能使用?占位符代替列名
                                String UpDatesql = "UPDATE consultationinformation SET " + time + " = ? WHERE name = ?";
                                pstmt = connection.prepareStatement(UpDatesql);
                                pstmt.setInt(1, resultData);
                                pstmt.setString(2, doctorName);
                                int rowsUpdated = pstmt.executeUpdate();
                                if (rowsUpdated > 0) {
                                    JOptionPane.showMessageDialog(frame, "预约成功");
                                } else {
                                    JOptionPane.showMessageDialog(frame, "预约失败");
                                }

                            } else {
                                JOptionPane.showMessageDialog(frame, "预约失败");
                            }
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    System.out.println("预约 " + doctorName + " 在 " + time);
                }
            });

            frame.add(button);
            JButton buttonPM = new JButton(days[i] + "下午");
            identifier = dayIdentifiers[i] + "PM"; // 例如 "day0PM" 对“当天下午”
            btnMap.put(buttonPM, identifier);

            buttonPM.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // 当按钮被点击时执行的代码
                    String time = btnMap.get(buttonPM);
                    Connection connection = JdbcUtils.getConnection();
                    // 注意，这里不再使用?占位符来代替列名，而是直接拼接字符串
                    String sql = "SELECT " + time + " FROM consultationinformation WHERE name = ?";
                    PreparedStatement pstmt = null;
                    try {
                        pstmt = connection.prepareStatement(sql);
                        pstmt.setString(1, doctorName);
                        ResultSet rs = pstmt.executeQuery();
                        if (rs.next()) {
                            // 假设我们查询的列是整数类型
                            int resultData = rs.getInt(time); // 这里应该使用 time 变量
                            if (resultData != 0) {
                                resultData -= 1;
                                // 更新的 SQL 也应该用相同的方式来构建，不能使用?占位符代替列名
                                String UpDatesql = "UPDATE consultationinformation SET " + time + " = ? WHERE name = ?";
                                pstmt = connection.prepareStatement(UpDatesql);
                                pstmt.setInt(1, resultData);
                                pstmt.setString(2, doctorName);
                                int rowsUpdated = pstmt.executeUpdate();
                                if (rowsUpdated > 0) {
                                    JOptionPane.showMessageDialog(frame, "预约成功");
                                } else {
                                    JOptionPane.showMessageDialog(frame, "预约失败");
                                }

                            } else {
                                JOptionPane.showMessageDialog(frame, "预约失败");
                            }
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    System.out.println("预约 " + doctorName + " 在 " + time);
                }
            });

            frame.add(buttonPM);
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

