package cn.dfxy.learn;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.Vector;

public class ConsultationInformationSet {
    public void consultationInterface() {
        JFrame frame = new JFrame("坐诊信息设置");
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 6, 6);
        frame.setLayout(flowLayout);
        if (frame.getContentPane().isVisible()) {
            JButton jButtonSeek = new JButton("查看坐诊信息");
            JButton jButtonUpdate = new JButton("修改坐诊信息");
            BtnListener btnListener = new BtnListener();


            frame.add(jButtonSeek);
            frame.add(jButtonUpdate);
            jButtonSeek.addActionListener(btnListener);
            jButtonUpdate.addActionListener(btnListener);
        }
        JFrameUtils.initFrame(frame, 700, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置窗口属性，关闭时程序不退出
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                JOptionPane.showMessageDialog(frame, "坐诊信息设置关闭");//关闭时进行提示
            }
        });
    }

    public void consultationSeek() {
        JFrame frame = new JFrame("坐诊信息");
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 6, 6);
        frame.setLayout(flowLayout);
        JLabel jLabel = new JLabel("医生名：");
        JLabel jLabe2 = new JLabel("数字为能预约数");
        JTextField jTextField = new JTextField(5);
        JButton jButton = new JButton("确定");
        jButton.addActionListener(e -> {
            String t1 = jTextField.getText();
            JFrame frame2 = new JFrame("坐诊信息");
            frame2.setLayout(flowLayout);

            JFrameUtils.initFrame(frame2, 1500, 600);
            frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置窗口属性，关闭时程序不退出
            frame2.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    JOptionPane.showMessageDialog(frame2, "坐诊信息设置关闭");//关闭时进行提示
                }
            });
            Connection connection = JdbcUtils.getConnection();
            try {

                Statement statement = connection.createStatement();
                String query = "SELECT * FROM consultationinformation WHERE name = '" + t1 + "'";
                ResultSet resultSet = statement.executeQuery(query);
                JTable table = new JTable(ResultSetUtils.buildTableModel(resultSet));
                /*TableColumnModel columnModel = table.getColumnModel();
                for (int column = 0; column < table.getColumnCount(); column++) {
                    int preferredWidth = 8; // 希望的列宽度
                    columnModel.getColumn(column).setPreferredWidth(preferredWidth);
                }*/
                JScrollPane scrollPane = new JScrollPane(table);

                // 设置首选宽度和高度
                int preferredWidth = 1200; // 宽度，按照你的需求设定
                int preferredHeight = 600; // 高度，按照你的需求设定
                Dimension preferredSize = new Dimension(preferredWidth, preferredHeight);// 应用首选大小
                scrollPane.setPreferredSize(preferredSize);


                frame2.add(scrollPane);

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException ex2) {
                    ex2.printStackTrace();
                }
            }
        });

        frame.add(jLabel);
        frame.add(jTextField);
        frame.add(jButton);
        frame.add(jLabe2);


        JFrameUtils.initFrame(frame, 700, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置窗口属性，关闭时程序不退出
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                JOptionPane.showMessageDialog(frame, "坐诊信息设置关闭");//关闭时进行提示
            }
        });
    }



    public void consultationUpdate() {
        JFrame frame = new JFrame("坐诊信息");
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 6, 6);
        frame.setLayout(flowLayout);
        JLabel jLabel = new JLabel("医生名：");
        JLabel jLabel2 = new JLabel("当天上午：");
        JLabel jLabel3 = new JLabel("当天下午：");
        JLabel jLabel4 = new JLabel("第二天上午：");
        JLabel jLabel5 = new JLabel("第二天下午：");
        JLabel jLabel6 = new JLabel("第三天上午：");
        JLabel jLabel7 = new JLabel("第三天下午：");
        JLabel jLabel8 = new JLabel("第四天上午：");
        JLabel jLabel9 = new JLabel("第四天下午：");
        JLabel jLabel10 = new JLabel("第五天上午：");
        JLabel jLabel11 = new JLabel("第五天下午：");
        JLabel jLabel12 = new JLabel("第六天上午：");
        JLabel jLabel13 = new JLabel("第六天下午：");
        JLabel jLabel14 = new JLabel("第七天下午：");
        JLabel jLabel15 = new JLabel("第七天下午：");
        JLabel jLabe2 = new JLabel("数字为能预约数");
        JTextField jTextField = new JTextField(5);
        JTextField jTextField2 = new JTextField(5);
        JTextField jTextField3 = new JTextField(5);
        JTextField jTextField4 = new JTextField(5);
        JTextField jTextField5 = new JTextField(5);
        JTextField jTextField6 = new JTextField(5);
        JTextField jTextField7 = new JTextField(5);
        JTextField jTextField8 = new JTextField(5);
        JTextField jTextField9 = new JTextField(5);
        JTextField jTextField10 = new JTextField(5);
        JTextField jTextField11 = new JTextField(5);
        JTextField jTextField12 = new JTextField(5);
        JTextField jTextField13 = new JTextField(5);
        JTextField jTextField14 = new JTextField(5);
        JTextField jTextField15 = new JTextField(5);
        JButton jButton = new JButton("确定");
        jButton.addActionListener(e -> {
            String t1 = jTextField.getText();
            int t2 = Integer.parseInt(jTextField2.getText());
            int t3 = Integer.parseInt(jTextField3.getText());
            int t4 = Integer.parseInt(jTextField4.getText());
            int t5 = Integer.parseInt(jTextField5.getText());
            int t6 = Integer.parseInt(jTextField6.getText());
            int t7 = Integer.parseInt(jTextField7.getText());
            int t8 = Integer.parseInt(jTextField8.getText());
            int t9 = Integer.parseInt(jTextField9.getText());
            int t10 = Integer.parseInt(jTextField10.getText());
            int t11 = Integer.parseInt(jTextField11.getText());
            int t12 = Integer.parseInt(jTextField12.getText());
            int t13 = Integer.parseInt(jTextField13.getText());
            int t14 = Integer.parseInt(jTextField13.getText());
            int t15 = Integer.parseInt(jTextField13.getText());


            Connection connection = JdbcUtils.getConnection();
            try {
                // 假设要修改的表名为users，修改name为"张三"的记录
                String sql = "UPDATE consultationinformation SET day0AM = ?, day0PM = ?,day1AM = ?, day1PM = ?,day2AM = ?, day2PM = ?,day3AM = ?, day3PM = ?,day4AM = ?, day4PM = ?,day5AM = ?, day5PM = ?,day6AM = ?, day6PM = ? WHERE name = ?";
                // 设置需要更新的列和对应的值
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, t2);
                preparedStatement.setInt(2, t3);
                preparedStatement.setInt(3, t4);
                preparedStatement.setInt(4, t5);
                preparedStatement.setInt(5, t6);
                preparedStatement.setInt(6, t7);
                preparedStatement.setInt(7, t8);
                preparedStatement.setInt(8, t9);
                preparedStatement.setInt(9, t10);
                preparedStatement.setInt(10, t11);
                preparedStatement.setInt(11, t12);
                preparedStatement.setInt(12, t13);
                preparedStatement.setInt(13, t14);
                preparedStatement.setInt(14, t15);
                preparedStatement.setString(15, t1);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("数据更新成功！");
                } else {
                    System.out.println("未找到匹配的数据行，更新失败。");
                }
            } catch (SQLException ex) {
                System.out.println("数据更新失败：" + ex.getMessage());
            }finally {
                JdbcUtils.close(null, null, connection);
            }
        });


        frame.add(jLabel);
        frame.add(jTextField);
        frame.add(jLabel2);
        frame.add(jTextField2);
        frame.add(jLabel3);
        frame.add(jTextField3);
        frame.add(jLabel4);
        frame.add(jTextField4);
        frame.add(jLabel5);
        frame.add(jTextField5);
        frame.add(jLabel6);
        frame.add(jTextField6);
        frame.add(jLabel7);
        frame.add(jTextField7);
        frame.add(jLabel8);
        frame.add(jTextField8);
        frame.add(jLabel9);
        frame.add(jTextField9);
        frame.add(jLabel10);
        frame.add(jTextField10);
        frame.add(jLabel11);
        frame.add(jTextField11);
        frame.add(jLabel12);
        frame.add(jTextField12);
        frame.add(jLabel13);
        frame.add(jTextField13);
        frame.add(jLabel14);
        frame.add(jTextField14);
        frame.add(jLabel15);
        frame.add(jTextField15);


        frame.add(jButton);
        frame.add(jLabe2);


        JFrameUtils.initFrame(frame, 700, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置窗口属性，关闭时程序不退出
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                JOptionPane.showMessageDialog(frame, "坐诊信息修改关闭");//关闭时进行提示
            }
        });
    }


}
