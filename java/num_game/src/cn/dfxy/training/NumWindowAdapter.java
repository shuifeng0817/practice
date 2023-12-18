package cn.dfxy.training;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

public class NumWindowAdapter extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
        Set<JButton> btnSet =NumGame.btnMap.keySet();
        StringBuilder numsSb =new StringBuilder();
        int i=0;
        for (JButton btn : btnSet) {
            String numStr = btn.getText();
            numsSb.append(numStr);
            if(++i<btnSet.size()){
                numsSb.append(",");
            }
        }
        Connection connection = JdbcUtils.getConnection();
        String insertSql ="insert into btn_nums(nums) values(?)";
        String deleteSql ="delete from btn_nums";
        PreparedStatement insertPstmt=null;
        PreparedStatement deletePstmt=null;
        try {
            deletePstmt =connection.prepareStatement(deleteSql);
            deletePstmt.executeUpdate();
            insertPstmt =connection.prepareStatement(insertSql);
            insertPstmt.setString(1, numsSb.toString());
            insertPstmt.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            JdbcUtils.close(null,insertPstmt,connection);
            JdbcUtils.close(null,deletePstmt,null);
        }
    }
}
