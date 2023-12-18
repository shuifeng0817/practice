package cn.dfxy.training;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Set;

public class NumBtnListener implements ActionListener {
    private int step;

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        JButton btn9 = NumGame.btn9;
        int[] location = NumGame.btnMap.get(btn);
        int[] btn9location = NumGame.btnMap.get(btn9);
        boolean isNeighbor = NumGame.isNeighbor(location, btn9location);
        if (isNeighbor) {
            step++;
            String btnText = btn.getText();
            String btn9Text = btn9.getText();
            btn.setText(btn9Text);
            btn9.setText(btnText);
            btn9.setVisible(true);
            btn.setVisible(false);
            NumGame.btn9 = btn;
            boolean victory = isVictory();
            if(victory){
                Connection connection = JdbcUtils.getConnection();
                String deleteSql ="delete from btn_nums";
                PreparedStatement deletePstmt=null;
                try {
                    deletePstmt =connection.prepareStatement(deleteSql);
                    deletePstmt.executeUpdate();
                    ;
                }catch (SQLException ex){
                    ex.printStackTrace();
                }finally {
                    JdbcUtils.close(null,deletePstmt,connection);
                }
                JOptionPane.showMessageDialog(NumGame.frame,"恭喜您获胜，一共走了"+step+"步","恭喜您获胜",JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        }
        System.out.println("位置是" + Arrays.toString(location));
    }
    boolean isVictory(){
        boolean isVictory = true;
        Set<JButton> btnSet = NumGame.btnMap.keySet();
        int i=0;
        for (JButton btn : btnSet) {
            String btnText = btn.getText();
            int btnNum =Integer.parseInt(btnText);
            if(btnNum != ++i){
                isVictory =false;
                break;
            }
        }
        return isVictory;
    }
}

