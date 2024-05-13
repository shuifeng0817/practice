package com.liuDay005;

public class Test2 {
    public static final String EMP_DATA = "ename:李兴华|job:134";

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        String result[] = EMP_DATA.split("\\|");
        for (String data : result) {
            String[] split = data.split(":");
            switch (split[0]) {
                case "ename":
                    test1.setEname(split[1]);
                    break;
                case "job":
                    test1.setJob(split[1]);
                    break;
            }
        }
        System.out.println(test1);
    }
}
