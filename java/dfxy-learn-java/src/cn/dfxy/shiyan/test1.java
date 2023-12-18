package cn.dfxy.shiyan;

public class test1 {

    public static void main(String[] args) {
     /*   // 声明并赋值整数型变量
        int a = 10;
        // 输出整数型变量
        System.out.println("整数类型: " + a);

        // 声明并赋值浮点型变量
        double b = 3.14;
        // 输出浮点型变量
        System.out.println("浮点类型: " + b);

        // 声明并赋值字符型变量
        char c = 'A';
        // 输出字符型变量
        System.out.println("字符类型: " + c);

        // 声明并赋值布尔型变量
        boolean d = true;
        // 输出布尔型变量
        System.out.println("布尔类型: " + d);

        // 声明并赋值字符串类型变量
        String e = "Hello, World!";
        // 输出字符串型变量
        System.out.println("字符串类型: " + e);*/


       /* int a = 10;
        int b = 5;
        int c = 3;

        // 算术表达式
        int result1 = a * (b + c);
        System.out.println("算术表达式的结果: " + result1);

        // 比较表达式
        boolean result2 = a > b;
        System.out.println("比较表达式的结果: " + result2);

        // 逻辑表达式
        boolean result3 = (a > b) && (b > c);
        System.out.println("逻辑表达式的结果: " + result3);

        // 条件表达式
        int result4 = (a > b) ? a : b;
        System.out.println("条件表达式的结果: " + result4);

        // 位运算表达式
        int result5 = a & b;
        System.out.println("位运算表达式的结果: " + result5);*/


        /*int a = 10;
        int b = 5;

        // if语句
        if (a > b) {
            System.out.println("a大于b");
        } else {
            System.out.println("a小于等于b");
        }
        // for循环
        System.out.println("使用for循环输出0到9：");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        // while循环
        int i = 0;
        System.out.println("使用while循环输出0到4：");
        while (i < 5) {
            System.out.print(i + " ");
            i++;
        }
        System.out.println();
        // do-while循环
        int j = 0;
        System.out.println("使用do-while循环输出0到4：");
        do {
            System.out.print(j + " ");
            j++;
        } while (j < 5);
        System.out.println();
        // switch语句
        int option = 2;
        System.out.print("根据选项输出对应信息：");
        switch (option) {
            case 1:
                System.out.println("选项1");
                break;
            case 2:
                System.out.println("选项2");
                break;
            default:
                System.out.println("其他选项");
        }*/

        int a = 10;
        int b = 3;
        int result1 = a + b; // 加法
        int result2 = a - b; // 减法
        int result3 = a * b; // 乘法
        int result4 = a / b; // 除法
        int result5 = a % b; // 取模
        a++; // 递增
        b--; // 递减

        System.out.println("加法结果：" + result1);
        System.out.println("减法结果：" + result2);
        System.out.println("乘法结果：" + result3);
        System.out.println("除法结果：" + result4);
        System.out.println("取模结果：" + result5);
        System.out.println("a递增后的值：" + a);
        System.out.println("b递减后的值：" + b);
    }

}
