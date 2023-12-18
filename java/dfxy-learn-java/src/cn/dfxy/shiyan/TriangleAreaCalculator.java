package cn.dfxy.shiyan;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TriangleAreaCalculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("三角形面积计算器");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JLabel label1 = new JLabel("边长1:");
        JTextField textField1 = new JTextField(10);
        JLabel label2 = new JLabel("边长2:");
        JTextField textField2 = new JTextField(10);
        JLabel label3 = new JLabel("边长3:");
        JTextField textField3 = new JTextField(10);
        JButton calculateButton = new JButton("计算面积");
        JLabel resultLabel = new JLabel();

        panel.add(label1);
        panel.add(textField1);
        panel.add(label2);
        panel.add(textField2);
        panel.add(label3);
        panel.add(textField3);
        panel.add(calculateButton);
        panel.add(resultLabel);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double a = Double.parseDouble(textField1.getText());
                double b = Double.parseDouble(textField2.getText());
                double c = Double.parseDouble(textField3.getText());

                double s = (a + b + c) / 2;
                double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));

                resultLabel.setText("三角形的面积为: " + area);
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}

