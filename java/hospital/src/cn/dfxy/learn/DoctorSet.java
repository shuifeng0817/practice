package cn.dfxy.learn;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.Vector;

public class DoctorSet {
    public void doctorInterface() {
        JFrame frame = new JFrame("医生管理");
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 6, 6);
        frame.setLayout(flowLayout);
        if (frame.getContentPane().isVisible()) {
            JButton jButtonAdd = new JButton("增加医生");
            JButton jButtonDelete = new JButton("删除医生");
            JButton jButtonSeek = new JButton("查看医生");
            JButton jButtonUpdate = new JButton("修改医生");
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
                JOptionPane.showMessageDialog(frame, "医生管理关闭");//关闭时进行提示
            }
        });
    }

    public void doctorAdd() {
        JFrame frame = new JFrame("医生管理");
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 6, 6);
        frame.setLayout(flowLayout);
        JLabel jLabelName = new JLabel("医生名：");
        JLabel jLabelSex = new JLabel("性别：");
        JLabel jLabelDepartment = new JLabel("科室：");
        JButton jButton = new JButton("确定");

        DoctorBean doctor = new DoctorBean();
        JTextField jTextFieldName = new JTextField(5);
        JTextField jTextFieldSex = new JTextField(5);
        JTextField jTextFieldDepartment = new JTextField(5);
        jButton.addActionListener(e -> {
            String t1 = jTextFieldName.getText();
            String t2 = jTextFieldSex.getText();
            String t3 = jTextFieldDepartment.getText();
            doctor.setName(t1);
            doctor.setSex(t2);
            doctor.setDepartmentName(t3);
            Connection connection = JdbcUtils.getConnection();
            String insertSql = "INSERT INTO doctor (name, sex, departmentName) VALUES (?, ?, ?)";
            String insertSql2 = "INSERT INTO ConsultationInformation (name,department) VALUES (?,?)";
            String insertSql3 = "INSERT INTO ConsultationInformation (department) VALUES (?)";
            PreparedStatement insertPstmt = null;
            try {
                insertPstmt =connection.prepareStatement(insertSql);
                insertPstmt.setString(1, doctor.getName());
                insertPstmt.setString(2, doctor.getSex());
                insertPstmt.setString(3, doctor.getDepartmentName());
                insertPstmt.executeUpdate();
                insertPstmt =connection.prepareStatement(insertSql2);
                insertPstmt.setString(1, doctor.getName());
                insertPstmt.setString(2, doctor.getDepartmentName());
                insertPstmt.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                JOptionPane.showMessageDialog(frame, "医生增加成功");
                JdbcUtils.close(null, insertPstmt, connection);
            }

        });
        frame.add(jLabelName);
        frame.add(jTextFieldName);
        frame.add(jLabelSex);
        frame.add(jTextFieldSex);
        frame.add(jLabelDepartment);
        frame.add(jTextFieldDepartment);
        frame.add(jButton);
        JFrameUtils.initFrame(frame, 700, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置窗口属性，关闭时程序不退出
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                JOptionPane.showMessageDialog(frame, "医生增加关闭");//关闭时进行提示
            }
        });
    }

    public void doctorSeek() {
        JFrame frame = new JFrame("医生管理");
        Connection connection = JdbcUtils.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT departmentName, name, sex FROM doctor");

            JTable table = new JTable(ResultSetUtils.buildTableModel(resultSet));
            JScrollPane scrollPane = new JScrollPane(table);
            frame.add(scrollPane);
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
                JOptionPane.showMessageDialog(frame, "医生查找关闭");//关闭时进行提示
            }
        });
    }


    public void doctorDelete() {
        JFrame frame = new JFrame("医生管理");

        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 6, 6);
        frame.setLayout(flowLayout);

        JLabel jLabel = new JLabel("医生名：");
        JButton jButton = new JButton("确定");
        JTextField jTextField = new JTextField(5);
        jButton.addActionListener(e -> {
            String t1 = jTextField.getText();
            System.out.println(t1);
            Connection connection = JdbcUtils.getConnection();
            String deleteSql = "DELETE FROM doctor WHERE name = ?;";
            String deleteSql2 = "DELETE FROM ConsultationInformation WHERE name = ?;";
            PreparedStatement deletePstmt = null;

            try {
                deletePstmt = connection.prepareStatement(deleteSql);
                deletePstmt.setString(1, t1); // 设置参数
                int rowsAffected = deletePstmt.executeUpdate(); // 执行删除操作
                System.out.println("删除了 " + rowsAffected + " 行数据");
                deletePstmt = connection.prepareStatement(deleteSql2);
                deletePstmt.setString(1, t1); // 设置参数
                rowsAffected = deletePstmt.executeUpdate(); // 执行删除操作
                System.out.println("删除了 " + rowsAffected + " 行数据");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } finally {
                JOptionPane.showMessageDialog(frame, "医生删除成功");
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
                JOptionPane.showMessageDialog(frame, "医生删除关闭");//关闭时进行提示
            }
        });
    }

    public void doctorUpdate() {
        JFrame frame = new JFrame("科室管理");

        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 6, 6);
        frame.setLayout(flowLayout);

        JLabel jLabeOld = new JLabel("修改医生名：");
        JLabel jLabeName = new JLabel("姓名：");
        JLabel jLabeSex = new JLabel("性别：");
        JLabel jLabeDepartment = new JLabel("科室名：");
        JButton jButton = new JButton("确定");
        JTextField jTextFieldOld = new JTextField(5);
        JTextField jTextFieldName = new JTextField(5);
        JTextField jTextFieldSex = new JTextField(5);
        JTextField jTextFielDepartment = new JTextField(5);
        jButton.addActionListener(e -> {
            DoctorBean doctorBean = new DoctorBean();
            String t1 = jTextFieldOld.getText();
            String t2 = jTextFieldName.getText();
            String t3 = jTextFieldSex.getText();
            String t4 = jTextFielDepartment.getText();
            System.out.println(t1);
            Connection connection = JdbcUtils.getConnection();
            String updateSql = "UPDATE doctor SET name = ?,sex = ? , departmentName = ? WHERE name=?";
            String updateSql2 = "UPDATE ConsultationInformation SET name = ? WHERE name=?";
            String updateSql3 = "UPDATE ConsultationInformation SET department = ? WHERE name=?";
            PreparedStatement updatePstmt = null;
            try {
                updatePstmt = connection.prepareStatement(updateSql);
                updatePstmt.setString(1, t2); // 设置更新后的值
                updatePstmt.setString(2, t3); // 设置更新后的值
                updatePstmt.setString(3, t4); // 设置更新后的值
                updatePstmt.setString(4, t1); // 需要更新的医生
                int rowsAffected = updatePstmt.executeUpdate(); // 执行更新操作
                updatePstmt = connection.prepareStatement(updateSql2);
                updatePstmt.setString(1, t2); // 需要更新的医生
                updatePstmt.setString(2, t1); // 需要更新的医生
                rowsAffected = updatePstmt.executeUpdate(); // 执行更新操作
                updatePstmt = connection.prepareStatement(updateSql3);
                updatePstmt.setString(1, t4); // 需要更新的科室
                updatePstmt.setString(2, t2); // 需要更新的医生
                rowsAffected = updatePstmt.executeUpdate(); // 执行更新操作
                System.out.println("更新了 " + rowsAffected + " 行数据");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } finally {
                JOptionPane.showMessageDialog(frame, "修改成功");
                JdbcUtils.close(null, updatePstmt, null);
            }
        });

        frame.add(jLabeOld);
        frame.add(jTextFieldOld);
        frame.add(jLabeName);
        frame.add(jTextFieldName);
        frame.add(jLabeSex);
        frame.add(jTextFieldSex);
        frame.add(jLabeDepartment);
        frame.add(jTextFielDepartment);
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
