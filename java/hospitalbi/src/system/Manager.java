package system;

import java.util.Scanner;

public class Manager {
    //控制器方法，存放各种选项输入菜单方法
    public static void welcome() {
        //主菜单方法
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("========医院挂号管理系统========");
            System.out.println("1.科室管理");
            System.out.println("2.医生管理");
            System.out.println("3.坐诊信息设置");
            System.out.println("4.全部信息展示");
            System.out.println("5.预约功能");
            System.out.println("6.搜索功能");
            System.out.println("7.查询功能");
            System.out.println("8.退出系统");
            System.out.println("请输入你要执行的操作");
            String choose = sc.next();
            switch (choose) {
                case "1": {
                    manageDep();
                    break;
                }
                case "2": {
                    manageDr();
                    break;
                }
                case "3": {
                    Functions.setSchedule();
                    break;
                }
                case "4": {
                    Functions.showAll();
                    break;
                }
                case "5": {
                    Functions.drBook();
                    break;
                }
                case "6": {
                    Functions.searchTime();
                    break;
                }
                case "7": {
                    Functions.searchDr();
                    break;
                }
                case "8": {
                    sc.close();
                    System.out.println("程序结束，感谢使用");
                    System.exit(0);
                }
                default: {
                    System.out.println("输入有误，请重新输入");
                }
            }
        }
    }


    public static void manageDep() {
        //科室管理菜单方法
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("========科室管理========");
            System.out.println("1.新增科室");
            System.out.println("2.删除科室");
            System.out.println("3.修改科室");
            System.out.println("4.返回上一级");
            System.out.println("请输入你要执行的操作");
            String choose = sc.next();
            switch (choose) {
                case "1": {
                    Functions.addDep();
                    break;
                }
                case "2": {
                    Functions.deleteDep();
                    break;
                }
                case "3": {
                    Functions.modifyDep();
                    break;
                }
                case "4": {
                    return;
                }
                default: {
                    System.out.println("输入有误，请重新输入");
                }
            }
        }
    }

    public static void manageDr() {
        //医生管理菜单方法
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("========医生管理========");
            System.out.println("1.录入医生信息");
            System.out.println("2.修改医生信息");
            System.out.println("3.返回上一级");
            System.out.println("请输入你要执行的操作");
            String choose = sc.next();
            switch (choose) {
                case "1": {
                    Functions.addDr();
                    break;
                }
                case "2": {
                    Functions.modifyDr();
                    break;
                }
                case "3": {
                    return;
                }
                default: {
                    System.out.println("输入有误，请重新输入");
                }
            }
        }
    }

}