package cn.dfxy.learn;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;

public class DepartmentSet {


    @Test
    public void departmentInterface() {
        JFrame frame = new JFrame("科室管理");
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 6, 6);
        frame.setLayout(flowLayout);
        if (frame.getContentPane().isVisible()) {
            JButton jButtonAdd = new JButton("增加科室");
            JButton jButtonDelete = new JButton("删除科室");
            JButton jButtonSeek = new JButton("查看科室");
            JButton jButtonUpdate = new JButton("修改科室");
            BtnListener btnListener = new BtnListener();


            frame.add(jButtonAdd);
            frame.add(jButtonDelete);
            frame.add(jButtonSeek);
            frame.add(jButtonUpdate);
            jButtonAdd.addActionListener(btnListener);
            jButtonSeek.addActionListener(btnListener);
            jButtonDelete.addActionListener(btnListener);
            jButtonUpdate.addActionListener(btnListener);
        }
        JFrameUtils.initFrame(frame, 700, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置窗口属性，关闭时程序不退出
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                JOptionPane.showMessageDialog(frame, "科室管理关闭");//关闭时进行提示
            }
        });
    }

    public void departmentAdd() {
        JFrame frame = new JFrame("科室管理");

        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 6, 6);
        frame.setLayout(flowLayout);
        JLabel jLabel = new JLabel("科室名：");
        JButton jButton = new JButton("确定");
        JTextField jTextField = new JTextField(5);
        jButton.addActionListener(e -> {
            String t1 = jTextField.getText();
            System.out.println(t1);
            Connection connection = JdbcUtils.getConnection();
            String insertSql = "insert into department(name) values(?)";
            PreparedStatement insertPstmt = null;
            try {
                insertPstmt = connection.prepareStatement(insertSql);
                insertPstmt.setString(1, t1);
                insertPstmt.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                JOptionPane.showMessageDialog(frame, "科室增加成功");
                JdbcUtils.close(null, insertPstmt, connection);
            }

        });
        frame.add(jLabel);
        frame.add(jTextField);
        frame.add(jButton);
        JFrameUtils.initFrame(frame, 700, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置窗口属性，关闭时程序不退出
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                JOptionPane.showMessageDialog(frame, "科室增加关闭");//关闭时进行提示
            }
        });
    }

    public void departmentSeek() {
        JFrame frame = new JFrame("科室管理");
        Connection connection = JdbcUtils.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM department");

            JList<String> list = new JList<>();
            DefaultListModel<String> model = new DefaultListModel<>();

            while (resultSet.next()) {
                String value = resultSet.getString(1); // 假设表中只有一列
                model.addElement(value);
            }
            list.setModel(model);
            frame.add(list);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        JFrameUtils.initFrame(frame, 700, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置窗口属性，关闭时程序不退出
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                JOptionPane.showMessageDialog(frame, "科室查看关闭");//关闭时进行提示
            }
        });
    }

    public void departmentDelete() {
        JFrame frame = new JFrame("科室管理");

        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 6, 6);
        frame.setLayout(flowLayout);

        JLabel jLabel = new JLabel("科室名：");
        JButton jButton = new JButton("确定");
        JTextField jTextField = new JTextField(5);
        jButton.addActionListener(e -> {
            String t1 = jTextField.getText();
            System.out.println(t1);
            Connection connection = JdbcUtils.getConnection();
            String deleteSql = "DELETE FROM department WHERE name = ?;";
            PreparedStatement deletePstmt = null;

            try {
                deletePstmt = connection.prepareStatement(deleteSql);
                deletePstmt.setString(1, t1); // 设置参数
                int rowsAffected = deletePstmt.executeUpdate(); // 执行删除操作
                System.out.println("删除了 " + rowsAffected + " 行数据");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } finally {
                JOptionPane.showMessageDialog(frame, "科室删除成功");
                JdbcUtils.close(null, deletePstmt, null);
            }
        });

        frame.add(jLabel);
        frame.add(jTextField);
        frame.add(jButton);
        JFrameUtils.initFrame(frame, 700, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置窗口属性，关闭时程序不退出
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                JOptionPane.showMessageDialog(frame, "科室删除关闭");//关闭时进行提示
            }
        });
    }


    public void departmentUpdate() {
        JFrame frame = new JFrame("科室管理");

        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 6, 6);
        frame.setLayout(flowLayout);

        JLabel jLabeOld = new JLabel("旧科室名：");
        JLabel jLabeNew = new JLabel("新科室名：");
        JButton jButton = new JButton("确定");
        JTextField jTextFieldOld = new JTextField(5);
        JTextField jTextFieldNew = new JTextField(5);
        jButton.addActionListener(e -> {
            String t1 = jTextFieldOld.getText();
            String t2 = jTextFieldNew.getText();
            System.out.println(t1);
            Connection connection = JdbcUtils.getConnection();
            String updateSql = "UPDATE department SET name = ? WHERE name=?"; // 假设需要根据id进行更新
            PreparedStatement updatePstmt = null;

            try {
                updatePstmt = connection.prepareStatement(updateSql);
                updatePstmt.setString(1, t2); // 设置更新后的值
                updatePstmt.setString(2, t1); // 需要更新的科室
                int rowsAffected = updatePstmt.executeUpdate(); // 执行更新操作
                System.out.println("更新了 " + rowsAffected + " 行数据");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } finally {
                JOptionPane.showMessageDialog(frame, "科室修改成功");
                JdbcUtils.close(null, updatePstmt, null);
            }
        });

        frame.add(jLabeOld);
        frame.add(jTextFieldOld);
        frame.add(jLabeNew);
        frame.add(jTextFieldNew);
        frame.add(jButton);
        JFrameUtils.initFrame(frame, 700, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 设置窗口属性，关闭时程序不退出
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                JOptionPane.showMessageDialog(frame, "科室更新关闭"); // 关闭时进行提示
            }
        });
    }

}

