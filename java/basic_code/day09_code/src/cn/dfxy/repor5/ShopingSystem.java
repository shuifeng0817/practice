package cn.dfxy.repor5;

import java.util.Scanner;
public class ShopingSystem {
    public static void main(String[] args){

        String choose3;
        do {
            Scanner input = new Scanner(System.in);
            //1.主界面
            System.out.println("======================");
            System.out.println("========1.登录========");
            System.out.println("========2.退出========");
            System.out.println("======================");
            System.out.println("请输入选项（1   or  2）");
            int choose1 = input.nextInt();
            if (choose1 == 1) {
                //进入登录界面
                System.out.println("======请登录======");
                System.out.println("请输入用户名：");//输入用户名
                String username = input.next();
                System.out.println("请输入密码：");//输入密码
                String password = input.next();


                //登录成功
                if ("zzz".equals(username) && "123456".equals(password)) {
                    System.out.println("欢迎用户：" + username);
                    System.out.println("->进入购物系统");
                    //打印商品菜单
                    System.out.println("商品编号\t商品名称\t\t\t商品单价");
                    System.out.println("1\t\t落地收纳柜\t\t55.8");
                    System.out.println("2\t\t明星海报周边\t\t135");
                    System.out.println("3\t\t恐龙毛绒玩具\t\t38.8");

                    double money1=0;//1的购物车单价
                    double money2 = 0;//2的购物车单价
                    double money3 =0;//3的购物车单价
                    double money = 0;//总金额


                    //do...while循环实现先多次购买
                    String choose2;
                    do {
                        System.out.println("请输入你要购买的商品编号：");
                        int no = input.nextInt();
                        if(no == 1){
                            System.out.println("请输入你要购买的数量：");
                            int sum1 = input.nextInt();
                            money1 = 55.8;
                            money1 *= sum1;
                            System.out.println("1的金额为："+money1);

                        }else if(no == 2){
                            System.out.println("请输入你要购买的数量：");
                            int sum2 = input.nextInt();
                            money2 = 135.0;
                            money2 *= sum2;
                            System.out.println("2的金额为："+money2);

                        }else if(no == 3){
                            System.out.println("请输入你要购买的数量：");
                            int sum3 = input.nextInt();
                            money3 = 38.8;
                            money3 *= sum3;
                            System.out.println("3的金额为："+money3);
                        }else {
                            System.out.println("选择有误请重新输入");
                        }
                        //计算总体金额
                        money = money1 + money2 + money3;
                        System.out.println("总金额为："+money);
                        System.out.println("是否继续购买(n/y)");
                        choose2 = input.next();
                    }while("y".equals(choose2));

                    if(money>=299){
                        System.out.println("总金额已经满299打八八折");
                        money*=0.88;
                        System.out.println("总金额为："+money);
                    }
                    int i;//控制循环的循环变量的
                    do {
                        System.out.println("请付钱");
                        double usermoney = input.nextDouble();
                        i = 1;
                        if (usermoney<money){
                            System.out.println("你的钱不足请");
                            i--;
                        }else{
                            usermoney-=money;
                            System.out.println("找零"+usermoney);
                        }
                    }while (i!=1);
                    //z最后一项商城菜单
                    System.out.println("========================");
                    System.out.println("========谢谢惠顾========");
                    System.out.println("======输入0退出系统=====");
                    System.out.println("========================");
                    int j = input.nextInt();
                    if (j==0){
                        break;
                    }


                } else {//登录失败
                    System.out.println("用户名或密码有误，已退出");
                    return;
                }
            } else if (choose1 == 2) {

            } else {
                System.out.println("输入有误，程序自动退出");
                break;
            }
            System.out.println("是否要退出系统：(n/y)");
            choose3 = input.next();
        }while("n".equals(choose3));
        System.out.println("欢迎您下次光临");
    }
}
