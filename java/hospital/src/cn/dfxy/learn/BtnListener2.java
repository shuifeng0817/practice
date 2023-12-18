package cn.dfxy.learn;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnListener2 implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        String btnText = btn.getText();
        InformationDisplay informationDisplay =new InformationDisplay();
        informationDisplay.departmentSeek(btnText);
    }
}
