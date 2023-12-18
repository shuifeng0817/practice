package cn.dfxy.training;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class NumGame {
    public static Map<JButton, int[]> btnMap = new LinkedHashMap<>();
    public static JButton btn9;
    public static JFrame frame = new JFrame("数字游戏");

    public void start() {
//        JFrame frame = new JFrame("数字游戏");
        GridLayout gridLayout = new GridLayout(3, 3);
        frame.setLayout(gridLayout);
        int[] nums = loadOrGenerateNums();
        //int[] nums = generateNums();
        NumBtnListener numBtnListener = new NumBtnListener();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            JButton btn = new JButton(String.valueOf(num));//将n+1的结果转换为字符串类型
            if (num == 9) {
                btn9 = btn;
                btn.setVisible(false);//将9窗口隐藏
            }
            btn.addActionListener(numBtnListener);
            int row = i / 3;//求行号
            int col = i % 3;//求列号
            int[] location = {row, col};//用一维数组存放行号和列号
            btnMap.put(btn, location);//将按钮和行号列号对应
            frame.add(btn);
        }
        NumWindowAdapter numWindowAdapter = new NumWindowAdapter();
        frame.addWindowListener(numWindowAdapter);
        JFrameUtils.initFrame(frame, 300, 300);
    }

    private int[] loadOrGenerateNums() {
        //1.先尝试从数据库中加载
        int[] nums = loadNum();
        //2.如果库中不存在就生成
        if (nums == null) {
            nums = generateNums();
        }
        return nums;
    }

    private int[] loadNum() {
        int[] nums = null;
        Connection connection = JdbcUtils.getConnection();
        String sql = "select * from btn_nums";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                String numsStr = resultSet.getString("nums");
                String[] split = numsStr.split(",");
                nums = new int[split.length];
                for (int i = 0; i < split.length; i++) {
                    String numStr = split[i];
                    nums[i] = Integer.parseInt(numStr);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nums;
    }

    private int[] generateNums() {
        int[] nums = new int[9];
        Random random = new Random();


        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            int num;
            do {
                num = random.nextInt(9) + 1; // 生成1到9之间的随机数
            } while (set.contains(num)); // 如果生成的随机数存在于set中，则重新生成

            nums[i] = num; // 将随机数放入数组
            set.add(num); // 将随机数放入set
        }


        /*for (int i = 0; i < nums.length; i++) {
            int num = random.nextInt(9) + 1;
            nums[i] = num;
        }*/
        return nums;
    }


    //  判断两个位置是否相邻
//行-行=0且列-列=1
//列-列=0且行-行=1
    public static boolean isNeighbor(int[] one, int[] another) {
        boolean isNeighbor;
        int oneRow = one[0];
        int oneCol = one[1];
        int anotherRow = another[0];
        int anotherCol = another[1];
        if (oneRow - anotherRow == 0 && Math.abs(oneCol - anotherCol) == 1) {
            isNeighbor = true;
        } else if (oneCol - anotherCol == 0 && Math.abs(oneRow - anotherRow) == 1) {
            isNeighbor = true;
        } else {
            isNeighbor = false;
        }
        return isNeighbor;

    }
}
