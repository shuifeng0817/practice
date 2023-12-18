package cn.dfxy.shiyan;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileCopy {
    public static void main(String[] args) {
       /* try (FileInputStream fis = new FileInputStream("D:\\test.txt");
             FileOutputStream fos = new FileOutputStream("D:\\test\\test1.txt")) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
            System.out.println("文件拷贝成功");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
       /* Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("请输入第一个整数: ");
            int num1 = scanner.nextInt();

            System.out.print("请输入第二个整数: ");
            int num2 = scanner.nextInt();

            if (num2 == 0) {
                System.out.println("除数不能为0，请重新输入第二个整数");
                num2 = scanner.nextInt();
            }

            int result = num1 / num2;
            System.out.println("两个整数相除的结果是: " + result);
        } catch (InputMismatchException e) {
            System.out.println("请输入有效的整数");
        } catch (ArithmeticException e) {
            System.out.println("除零错误，请输入非零整数");
        } finally {
            scanner.close();
        }*/


        try {
            div();
        } catch (ArithmeticException e) {
            System.out.println("除零错误，请输入非零整数");
        } catch (InputMismatchException e) {
            System.out.println("请输入有效的整数");
        }
    }

    public static void div() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("请输入第一个整数: ");
            int num1 = scanner.nextInt();

            System.out.print("请输入第二个整数: ");
            int num2 = scanner.nextInt();

            if (num2 == 0) {
                throw new ArithmeticException("除数不能为0");
            }

            int result = num1 / num2;
            System.out.println("两个整数相除的结果是: " + result);
        } finally {
            scanner.close();
        }
    }
}
